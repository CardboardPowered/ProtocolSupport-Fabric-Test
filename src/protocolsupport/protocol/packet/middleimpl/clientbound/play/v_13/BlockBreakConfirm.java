package protocolsupport.protocol.packet.middleimpl.clientbound.play.v_13;

import protocolsupport.protocol.packet.middleimpl.clientbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13.AbstractChunkCacheBlockBreakConfirm;
import protocolsupport.protocol.typeremapper.block.BlockRemappingHelper;
import protocolsupport.protocol.typeremapper.block.FlatteningBlockData;
import protocolsupport.protocol.typeremapper.block.FlatteningBlockData.FlatteningBlockDataTable;
import protocolsupport.protocol.typeremapper.block.LegacyBlockData;
import protocolsupport.protocol.typeremapper.utils.MappingTable.ArrayBasedIntMappingTable;

public class BlockBreakConfirm extends AbstractChunkCacheBlockBreakConfirm {

	public BlockBreakConfirm(MiddlePacketInit init) {
		super(init);
	}

	protected final ArrayBasedIntMappingTable blockDataRemappingTable = LegacyBlockData.REGISTRY.getTable(version);
	protected final FlatteningBlockDataTable flatteningBlockDataTable = FlatteningBlockData.REGISTRY.getTable(version);

	@Override
	protected void writeToClient() {
		codec.write(BlockChangeSingle.create(position, BlockRemappingHelper.remapFlatteningBlockDataId(blockDataRemappingTable, flatteningBlockDataTable, blockId)));
	}

}
