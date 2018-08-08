package com.laomn.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * 订票服务器端
 * 
 * @author xwalker
 *
 */
public class ReceiveServer {

	/**
	 * 初始化 构造车次和车票余数
	 */
	public ReceiveServer() {

	}

	public void bind(int port) throws Exception {
		// 配置NIO线程组
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			// 服务器辅助启动类配置
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).option(ChannelOption.SO_BACKLOG, 100)
					.handler(new LoggingHandler(LogLevel.ERROR)).childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							// 添加对象解码器 负责对序列化POJO对象进行解码 设置对象序列化最大长度为1M 防止内存溢出
							// 设置线程安全的WeakReferenceMap对类加载器进行缓存 支持多线程并发访问 防止内存溢出
							ch.pipeline().addLast(
									new ObjectDecoder(1024 * 1024, ClassResolvers.weakCachingConcurrentResolver(this
											.getClass().getClassLoader())));
							// 添加对象编码器 在服务器对外发送消息的时候自动将实现序列化的POJO对象编码
							ch.pipeline().addLast(new ObjectEncoder());
							ch.pipeline().addLast(new ReceiveServerhandler());
						}
					});
			// 绑定端口 同步等待绑定成功
			ChannelFuture f = b.bind(port).sync();
			// 等到服务端监听端口关闭
			f.channel().closeFuture().sync();
		} finally {
			// 优雅释放线程资源
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}
	}

	public static void main(String[] args) throws Exception {
		int port = 8000;
		new ReceiveServer().bind(port);
	}

}