package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_14r1_14r2_15_16r1_16r2;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleInventoryHorseOpen;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public class InventoryHorseOpen extends MiddleInventoryHorseOpen {

	public InventoryHorseOpen(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void writeToClient() {
		ClientBoundPacketData windowhorseopen = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_WINDOW_HORSE_OPEN);
		windowhorseopen.writeByte(windowId);
		VarNumberSerializer.writeVarInt(windowhorseopen, slots);
		windowhorseopen.writeInt(entityId);
		codec.write(windowhorseopen);
	}

}
