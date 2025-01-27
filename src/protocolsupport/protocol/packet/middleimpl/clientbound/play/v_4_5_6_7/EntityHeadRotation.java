package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleEntityHeadRotation;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;

public class EntityHeadRotation extends MiddleEntityHeadRotation {

	public EntityHeadRotation(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void writeToClient() {
		ClientBoundPacketData entityheadrotation = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_ENTITY_HEAD_ROTATION);
		entityheadrotation.writeInt(entityId);
		entityheadrotation.writeByte(headRot);
		codec.write(entityheadrotation);
	}

}
