package protocolsupport.protocol.packet.middleimpl.serverbound.play.v_4_5_6_7_8_9r1_9r2_10_11_12r1_12r2_13_14r1_14r2_15_16r1_16r2;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.serverbound.play.MiddleInventoryTransaction;

public class InventoryTransaction extends MiddleInventoryTransaction {

	public InventoryTransaction(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void readClientData(ByteBuf clientdata) {
		windowId = clientdata.readUnsignedByte();
		actionNumber = clientdata.readShort();
		accepted = clientdata.readBoolean();
	}

}
