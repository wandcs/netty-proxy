/**
 * @(#)ProxyHandler, 14-6-19. 
 */
package io.proxy;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

/**
 * @author eric
 */
public class ProxyHandler extends ChannelInitializer<SocketChannel> {
    private final String remoteHost;
    private final int remotePort;

    public ProxyHandler(String remoteHost, int remotePort) {
        this.remoteHost = remoteHost;
        this.remotePort = remotePort;
    }

    @Override
    public void initChannel(SocketChannel ch) {
        ch.pipeline().addLast(
                new LoggingHandler(LogLevel.INFO),
                new PreHandle(remoteHost, remotePort));
    }
}
