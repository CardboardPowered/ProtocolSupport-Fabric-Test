package protocolsupport.protocol.packet.handler.common;

import net.minecraft.server.v1_10_R1.NetworkManager;
import protocolsupport.protocol.packet.handler.AbstractHandshakeListener;
import protocolsupport.protocol.packet.handler.AbstractLoginListener;

public class LegacyHandshakeListener extends AbstractHandshakeListener {

	public LegacyHandshakeListener(NetworkManager networkmanager) {
		super(networkmanager);
	}

	@Override
	public AbstractLoginListener getLoginListener(NetworkManager networkManager) {
		return new LegacyLoginListener(networkManager);
	}

}
