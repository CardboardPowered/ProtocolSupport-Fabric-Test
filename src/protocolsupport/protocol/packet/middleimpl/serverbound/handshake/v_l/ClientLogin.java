package protocolsupport.protocol.packet.middleimpl.serverbound.handshake.v_l;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.ServerBoundMiddlePacket;
import protocolsupport.protocol.packet.middleimpl.ServerBoundPacketData;
import protocolsupport.protocol.serializer.StringSerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;
import protocolsupport.protocol.utils.ProtocolVersionsHelper;

public class ClientLogin extends ServerBoundMiddlePacket {

	public ClientLogin(MiddlePacketInit init) {
		super(init);
	}

	protected String username;
	protected String hostname;
	protected int port;

	@Override
	protected void readClientData(ByteBuf clientdata) {
		String[] data = StringSerializer.readShortUTF16BEString(clientdata, Short.MAX_VALUE).split("[;]");
		String[] addrdata = data[1].split("[:]");
		username = data[0];
		hostname = addrdata[0];
		port = Integer.parseInt(addrdata[1]);
	}

	@Override
	protected void writeToServer() {
		ServerBoundPacketData setprotocol = ServerBoundPacketData.create(PacketType.SERVERBOUND_HANDSHAKE_START);
		VarNumberSerializer.writeVarInt(setprotocol, ProtocolVersionsHelper.LATEST_PC.getId());
		StringSerializer.writeVarIntUTF8String(setprotocol, hostname);
		setprotocol.writeShort(port);
		VarNumberSerializer.writeVarInt(setprotocol, 2);
		codec.read(setprotocol);

		ServerBoundPacketData loginstart = ServerBoundPacketData.create(PacketType.SERVERBOUND_LOGIN_START);
		StringSerializer.writeVarIntUTF8String(loginstart, username);
		codec.read(loginstart);
	}

}
