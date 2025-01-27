package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2.AbstractKnownEntityPassengers;
import protocolsupport.protocol.serializer.ArraySerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public class EntityPassengers extends AbstractKnownEntityPassengers {

	public EntityPassengers(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void writeToClient() {
		ClientBoundPacketData entitypassengers = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_ENTITY_PASSENGERS);
		VarNumberSerializer.writeVarInt(entitypassengers, vehicleId);
		ArraySerializer.writeVarIntVarIntArray(entitypassengers, passengersIds);
		codec.write(entitypassengers);
	}

}
