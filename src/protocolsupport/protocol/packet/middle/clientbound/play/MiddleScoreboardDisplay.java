package protocolsupport.protocol.packet.middle.clientbound.play;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.ClientBoundMiddlePacket;
import protocolsupport.protocol.serializer.StringSerializer;

public abstract class MiddleScoreboardDisplay extends ClientBoundMiddlePacket {

	public MiddleScoreboardDisplay(MiddlePacketInit init) {
		super(init);
	}

	protected int position;
	protected String name;

	@Override
	protected void readServerData(ByteBuf serverdata) {
		position = serverdata.readUnsignedByte();
		name = StringSerializer.readVarIntUTF8String(serverdata);
	}

}
