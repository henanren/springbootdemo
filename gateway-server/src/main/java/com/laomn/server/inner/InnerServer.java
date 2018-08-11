package com.laomn.server.inner;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class InnerServer {
	private static final Logger logger = LoggerFactory.getLogger(InnerServer.class);

	public InnerServer() {

	}

	@Autowired
	private InnerServerhandler innerServerhandler;

	public void bind(int port) throws Exception {
		// 配置NIO线程组
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			// 服务器辅助启动类配置
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, 1024).handler(new LoggingHandler(LogLevel.ERROR))
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							// 添加对象解码器 负责对序列化POJO对象进行解码 设置对象序列化最大长度为1M 防止内存溢出
							// 设置线程安全的WeakReferenceMap对类加载器进行缓存 支持多线程并发访问 防止内存溢出
							// ch.pipeline().addLast(
							// new ObjectDecoder(1024 * 1024,
							// ClassResolvers.weakCachingConcurrentResolver(this
							// .getClass().getClassLoader())));
							// 添加对象编码器 在服务器对外发送消息的时候自动将实现序列化的POJO对象编码
							// ch.pipeline().addLast(new ObjectEncoder());

							ch.pipeline().addLast(
									new io.netty.handler.codec.string.StringEncoder(java.nio.charset.Charset
											.forName("utf-8")));
							ch.pipeline().addLast(innerServerhandler); // 客户端触发操作
							ch.pipeline().addLast(new ByteArrayEncoder());

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
		int port = 8001;
		new InnerServer().bind(port);
		logger.info("启动服务。");
	}

	@PostConstruct
	public void init() {
		logger.info("InnerServer    port : " + port);
		try {
			bind(port);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Value("${inner.server.port}")
	private int port;

}