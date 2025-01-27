package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleCollectEffect;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.VarNumberSerializer;

public class CollectEffect extends MiddleCollectEffect {

	public CollectEffect(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void writeToClient() {
		ClientBoundPacketData collecteffect = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_COLLECT_EFFECT);
		VarNumberSerializer.writeVarInt(collecteffect, entityId);
		VarNumberSerializer.writeVarInt(collecteffect, collectorId);
		codec.write(collecteffect);
	}

}
