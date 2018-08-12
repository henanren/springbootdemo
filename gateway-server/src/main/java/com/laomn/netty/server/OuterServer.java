package com.laomn.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
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

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.laomn.utils.Constants;

@Component
public class OuterServer {
	private static final Logger logger = LoggerFactory.getLogger(OuterServer.class);
	@Autowired
	private OuterServerhandler outerServerhandler;

	public OuterServer() {

	}

	public void bind(int port) throws Exception {
		// 配置NIO线程组
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {

			// // 保持连接数
			// bootstrap.option(ChannelOption.SO_BACKLOG, 1024 * 1024);
			// // 有数据立即发送
			// bootstrap.option(ChannelOption.TCP_NODELAY, true);
			// // 保持连接
			// bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
			// // 服务器辅助启动类配置
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
					.option(ChannelOption.SO_BACKLOG, 1024 * 1024).option(ChannelOption.TCP_NODELAY, true)
					.option(ChannelOption.SO_KEEPALIVE, true).handler(new LoggingHandler(LogLevel.INFO))
					.childHandler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							// 添加对象解码器 负责对序列化POJO对象进行解码 设置对象序列化最大长度为1M 防止内存溢出
							// 设置线程安全的WeakReferenceMap对类加载器进行缓存 支持多线程并发访问 防止内存溢出
							// Integer.MAX_VALUE,
							ch.pipeline().addLast(
									new ObjectDecoder(1024 * 1024, ClassResolvers.weakCachingConcurrentResolver(this
											.getClass().getClassLoader())));
							// 添加对象编码器 在服务器对外发送消息的时候自动将实现序列化的POJO对象编码
							ch.pipeline().addLast(new ObjectEncoder());

							// ch.pipeline().addLast(
							// new
							// io.netty.handler.codec.string.StringEncoder(java.nio.charset.Charset
							// .forName("utf-8")));
							ch.pipeline().addLast(outerServerhandler); // 客户端触发操作
							// ch.pipeline().addLast(new ByteArrayEncoder());
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
		new OuterServer().bind(port);
		logger.info("启动服务。");
	}

	public static void sendMsg(String key, Object msg) {
		if (StringUtils.isNoneBlank(key)) {
			Channel channel = Constants.CUSTOMER_CHANNEL_CACHE.get(key);
			if (channel != null) {
				channel.writeAndFlush(msg);
			}
		}

	}

	@PostConstruct
	public void init() {
		Runnable run = new Runnable() {
			public void run() {
				System.err.println("outerServer    port : " + port);
				logger.info("outerServer    port : " + port);
				try {
					bind(port);
				} catch (Exception e) {
					logger.error(e.getMessage());
				}
			}
		};
		new Thread(run).start();

	}

	@Value("${outer.server.port}")
	private int port;

}