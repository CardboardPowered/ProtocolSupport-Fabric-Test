package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_9r1_9r2_10_11_12r1_12r2;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.packet.middle.clientbound.play.MiddleUpdateMap;
import protocolsupport.protocol.packet.middleimpl.ClientBoundPacketData;
import protocolsupport.protocol.serializer.ArraySerializer;
import protocolsupport.protocol.serializer.VarNumberSerializer;
import protocolsupport.protocol.typeremapper.mapcolor.MapColorMappingRegistry;
import protocolsupport.protocol.typeremapper.utils.MappingTable.ArrayBasedIntMappingTable;

public class UpdateMap extends MiddleUpdateMap {

	public UpdateMap(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void writeToClient() {
		ClientBoundPacketData updatemap = ClientBoundPacketData.create(PacketType.CLIENTBOUND_PLAY_UPDATE_MAP);
		VarNumberSerializer.writeVarInt(updatemap, id);
		updatemap.writeByte(scale);
		updatemap.writeBoolean(showIcons);
		ArraySerializer.writeVarIntTArray(updatemap, icons, (to, icon) -> {
			to.writeByte(((icon.type <= 9 ? icon.type : 0) << 4) | icon.direction);
			to.writeByte(icon.x);
			to.writeByte(icon.z);
		});
		updatemap.writeByte(columns);
		if (columns > 0) {
			ArrayBasedIntMappingTable colorRemapper = MapColorMappingRegistry.INSTANCE.getTable(version);
			for (int i = 0; i < colors.length; i++) {
				colors[i] = (byte) colorRemapper.get(colors[i] & 0xFF);
			}
			updatemap.writeByte(rows);
			updatemap.writeByte(xstart);
			updatemap.writeByte(zstart);
			ArraySerializer.writeVarIntByteArray(updatemap, colors);
		}
		codec.write(updatemap);
	}

}
