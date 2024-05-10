package com.hj.myrpc.server.service;

import com.hj.myrpc.base.config.ServerConfig;
import com.hj.myrpc.registry.access.ServiceRegistry;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;


public class Server {
     private EventLoopGroup bossGroup;
     private EventLoopGroup workerGroup;

     private ChannelFuture channelFuture;

     /**
      * 这个group主要是区分不同的集群，比如商品集群，订单集群，属于不同的group，在zk中注册不同的服务分组
      */
     private String group;
     private int port;

     private ServerConfig serverConfig;

     private ServiceRegistry serviceRegistry;

     public Server(ServerConfig serverConfig,String group, int port) {
          this.serverConfig = serverConfig;
          this.group = group;
          this.port = port;
          bossGroup = new NioEventLoopGroup();
          workerGroup = new NioEventLoopGroup();
     }

     public void start(){
          ServerBootstrap bootstrap=new ServerBootstrap();
          bootstrap.group(bossGroup,workerGroup)
                  .channel(NioServerSocketChannel.class)
                  .childHandler(new My)
     }

}
