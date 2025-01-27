package protocolsupport.protocol.packet.middle.clientbound.play;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.CancelMiddlePacketException;
import protocolsupport.protocol.typeremapper.basic.GenericIdSkipper;

public abstract class MiddleEntityEffectRemove extends MiddleEntity {

	public MiddleEntityEffectRemove(MiddlePacketInit init) {
		super(init);
	}

	protected int effectId;

	@Override
	protected void readServerData(ByteBuf serverdata) {
		super.readServerData(serverdata);
		effectId = serverdata.readByte();
	}

	@Override
	protected void handleReadData() {
		if (GenericIdSkipper.EFFECT.getTable(version).isSet(effectId)) {
			throw CancelMiddlePacketException.INSTANCE;
		}
	}

}
