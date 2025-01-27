package protocolsupport.protocol.packet.middleimpl.serverbound.login.v_4_5_6_7;

import io.netty.buffer.ByteBuf;
import protocolsupport.protocol.packet.middle.serverbound.login.MiddleEncryptionResponse;
import protocolsupport.protocol.serializer.ArraySerializer;

public class EncryptionResponse extends MiddleEncryptionResponse {

	public EncryptionResponse(MiddlePacketInit init) {
		super(init);
	}

	@Override
	protected void readClientData(ByteBuf clientdata) {
		sharedSecret = ArraySerializer.readShortByteArraySlice(clientdata, 256);
		verifyToken = ArraySerializer.readShortByteArraySlice(clientdata, 256);
	}

}
