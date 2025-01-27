package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2.AbstractLocationOffsetEntityTeleport;

public class EntityTeleport extends AbstractLocationOffsetEntityTeleport {

	public EntityTeleport(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void writeToClient() {
		codec.write(create(entityId, x, y, z, yaw, pitch));
	}

	public static ClientBoundPacketData create(int entityId, double x, double y, double z, byte yaw, byte pitch) {
		ClientBoundPacketData entityteleport = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_ENTITY_TELEPORT);
		entityteleport.writeInt(entityId);
		entityteleport.writeInt((int) (x * 32));
		entityteleport.writeInt((int) (y * 32));
		entityteleport.writeInt((int) (z * 32));
		entityteleport.writeByte(yaw);
		entityteleport.writeByte(pitch);
		return entityteleport;
	}

}
