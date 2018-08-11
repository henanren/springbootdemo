package com.laomn.client.outer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayEncoder;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OuterClient {
	private static final Logger logger = LoggerFactory.getLogger(OuterClient.class);
	@Value("${inner.server.host}")
	private String host;
	@Value("${inner.server.port}")
	private int port;
	@Autowired
	private OuterClientHandler outerClientHandler;
	private static SocketChannel CHANNEL;

	public void connect(int port, String host) throws Exception {
		// 配置客户端线程组
		EventLoopGroup group = new NioEventLoopGroup();
		try {
			// 配置客户端启动辅助类
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class).option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<SocketChannel>() {
						@Override
						protected void initChannel(SocketChannel ch) throws Exception {
							// 添加POJO对象解码器 禁止缓存类加载器
							// ch.pipeline().addLast(
							// new ObjectDecoder(1024 * 1024,
							// ClassResolvers.cacheDisabled(this.getClass()
							// .getClassLoader())));
							// 设置发送消息编码器
							// ch.pipeline().addLast(new ObjectEncoder());
							// 设置网络IO处理器

							ch.pipeline().addLast(
									new io.netty.handler.codec.string.StringEncoder(java.nio.charset.Charset
											.forName("utf-8")));
							ch.pipeline().addLast(outerClientHandler);
							ch.pipeline().addLast(new ByteArrayEncoder());
							// ch.pipeline().addLast(new ChunkedWriteHandler());
							CHANNEL = ch;

						}
					});
			// 发起异步服务器连接请求 同步等待成功
			ChannelFuture f = b.connect(host, port).sync();
			// 等到客户端链路关闭
			f.channel().closeFuture().sync();

		} finally {
			// 优雅释放线程资源
			group.shutdownGracefully();
		}

	}

	public static void main(String[] args) throws Throwable {

		new OuterClient().connect(8000, "127.0.0.1");
	}

	@PostConstruct
	public void init() {
		logger.info("OuterClient  host : " + host + " port : " + port);
		try {
			connect(port, host);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	public static void sendMsg(Object msg) {
		CHANNEL.writeAndFlush(msg);
	}
}