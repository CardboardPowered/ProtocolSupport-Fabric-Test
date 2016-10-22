package protocolsupport.protocol.pipeline.common;

import java.io.IOException;
import java.net.SocketAddress;
import java.nio.channels.ClosedChannelException;
import java.util.HashSet;

import org.bukkit.Bukkit;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.handler.timeout.ReadTimeoutException;
import protocolsupport.api.Connection;
import protocolsupport.api.ProtocolSupportAPI;
import protocolsupport.api.events.ConnectionCloseEvent;
import protocolsupport.api.events.ConnectionOpenEvent;
import protocolsupport.api.events.PlayerDisconnectEvent;
import protocolsupport.logger.AsyncErrorLogger;
import protocolsupport.protocol.ConnectionImpl;
import protocolsupport.protocol.storage.ProtocolStorage;
import protocolsupport.utils.netty.ChannelUtils;

public class LogicHandler extends ChannelDuplexHandler {

	private static final HashSet<Class<? extends Throwable>> ignoreExceptions = new HashSet<>();
	static {
		ignoreExceptions.add(ClosedChannelException.class);
		ignoreExceptions.add(ReadTimeoutException.class);
		ignoreExceptions.add(IOException.class);
	}

	private final ConnectionImpl connection;
	public LogicHandler(ConnectionImpl connection) {
		this.connection = connection;
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (connection.handlePacketReceive(msg)) {
			super.channelRead(ctx, msg);
		}
	}

	@Override
	public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
		if (connection.handlePacketSend(msg)) {
			super.write(ctx, msg, promise);
		} else {
			promise.setSuccess();
		}
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable e) throws Exception {
		super.exceptionCaught(ctx, e);
		if (!ignoreExceptions.contains(e.getClass())) {
			SocketAddress remoteaddr = ChannelUtils.getNetworkManagerSocketAddress(ctx.channel());
			AsyncErrorLogger.INSTANCE.log(e, remoteaddr, ProtocolSupportAPI.getProtocolVersion(remoteaddr));
		}
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
		Bukkit.getPluginManager().callEvent(new ConnectionOpenEvent(connection));
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		super.channelInactive(ctx);
		SocketAddress addr = ChannelUtils.getNetworkManagerSocketAddress(ctx.channel());
		Connection connection = ProtocolStorage.getConnection(addr);
		String username = ChannelUtils.getUserName(ctx.channel());
		if (username != null) {
			Bukkit.getPluginManager().callEvent(new PlayerDisconnectEvent(connection, username));
		}
		Bukkit.getPluginManager().callEvent(new ConnectionCloseEvent(connection));
		ProtocolStorage.removeConnection(addr);
	}

}
