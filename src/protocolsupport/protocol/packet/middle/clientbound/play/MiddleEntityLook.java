package protocolsupport.protocol.packet.middle.clientbound.play;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.CancelMiddlePacketException;
import protocolsupport.protocol.storage.netcache.NetworkEntityCache;
import protocolsupport.protocol.types.networkentity.NetworkEntity;

public abstract class MiddleEntityLook extends MiddleEntity {

	public MiddleEntityLook(MiddlePacketInit init) {
		super(init);
	}

	protected final NetworkEntityCache entityCache = cache.getEntityCache();

	protected NetworkEntity entity;
	protected byte yaw;
	protected byte pitch;
	protected boolean onGround;

	@Override
	protected void readServerData(ByteBuf serverdata) {
		super.readServerData(serverdata);
		entity = entityCache.getEntity(entityId);
		yaw = serverdata.readByte();
		pitch = serverdata.readByte();
		onGround = serverdata.readBoolean();

		if (entity == null) {
			throw CancelMiddlePacketException.INSTANCE;
		}
	}

	@Override
	protected void handleReadData() {
		entity.getDataCache().setLook(pitch, yaw);
	}

}
