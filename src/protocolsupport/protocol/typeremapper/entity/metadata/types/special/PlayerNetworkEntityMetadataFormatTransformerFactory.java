package protocolsupport.protocol.typeremapper.entity.metadata.types.special;

import protocolsupport.api.ProtocolVersion;
import protocolsupport.protocol.serializer.NetworkEntityMetadataSerializer.NetworkEntityMetadataList;
import protocolsupport.protocol.typeremapper.entity.metadata.object.NetworkEntityMetadataFormatTransformer;
import protocolsupport.protocol.typeremapper.entity.metadata.object.value.NetworkEntityMetadataObjectIndexValueNoOpTransformer;
import protocolsupport.protocol.typeremapper.entity.metadata.object.value.NetworkEntityMetadataObjectIndexValueNumberToIntTransformer;
import protocolsupport.protocol.typeremapper.entity.metadata.types.base.LivingNetworkEntityMetadataFormatTransformerFactory;
import protocolsupport.protocol.types.networkentity.NetworkEntity;
import protocolsupport.protocol.types.networkentity.metadata.NetworkEntityMetadataObject;
import protocolsupport.protocol.types.networkentity.metadata.NetworkEntityMetadataObjectIndex;
import protocolsupport.protocol.types.networkentity.metadata.objects.NetworkEntityMetadataObjectByte;
import protocolsupport.protocol.utils.ProtocolVersionsHelper;
import protocolsupport.utils.BitUtils;
import protocolsupport.utils.CollectionsUtils.ArrayMap;

public class PlayerNetworkEntityMetadataFormatTransformerFactory extends LivingNetworkEntityMetadataFormatTransformerFactory {

	public static final PlayerNetworkEntityMetadataFormatTransformerFactory INSTANCE = new PlayerNetworkEntityMetadataFormatTransformerFactory();

	public static final String DATA_KEY_BASE_FLAGS = "Player_BaseFlags";

	protected static class HandUseAsBaseFlagsTransformer {

		protected byte baseflags;
		protected byte usehands;

		public void updateBaseFlags(byte baseflags) {
			this.baseflags = baseflags;
		}

		public void updateUseHands(byte usehands) {
			this.usehands = usehands;
		}

		public byte getComputedBaseFlags() {
			return (byte) BitUtils.setIBit(baseflags, 4, usehands);
		}

	}

	protected PlayerNetworkEntityMetadataFormatTransformerFactory() {
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.ADDITIONAL_HEARTS, 14), ProtocolVersionsHelper.UP_1_15);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.ADDITIONAL_HEARTS, 13), ProtocolVersionsHelper.ALL_1_14);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.ADDITIONAL_HEARTS, 11), ProtocolVersionsHelper.RANGE__1_10__1_13_2);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.ADDITIONAL_HEARTS, 10), ProtocolVersionsHelper.ALL_1_9);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.ADDITIONAL_HEARTS, 17), ProtocolVersionsHelper.DOWN_1_8);

		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.SCORE, 15), ProtocolVersionsHelper.UP_1_15);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.SCORE, 14), ProtocolVersionsHelper.ALL_1_14);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.SCORE, 12), ProtocolVersionsHelper.RANGE__1_10__1_13_2);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.SCORE, 11), ProtocolVersionsHelper.ALL_1_9);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNumberToIntTransformer(NetworkEntityMetadataObjectIndex.Player.SCORE, 18), ProtocolVersionsHelper.DOWN_1_8);

		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.SKIN_FLAGS, 16), ProtocolVersionsHelper.UP_1_15);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.SKIN_FLAGS, 15), ProtocolVersionsHelper.ALL_1_14);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.SKIN_FLAGS, 13), ProtocolVersionsHelper.RANGE__1_10__1_13_2);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.SKIN_FLAGS, 12), ProtocolVersionsHelper.ALL_1_9);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.SKIN_FLAGS, 10), ProtocolVersion.getAllBetween(ProtocolVersion.MINECRAFT_1_8, ProtocolVersion.MINECRAFT_1_6_1));

		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.MAIN_HAND, 17), ProtocolVersionsHelper.UP_1_15);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.MAIN_HAND, 16), ProtocolVersionsHelper.ALL_1_14);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.MAIN_HAND, 14), ProtocolVersionsHelper.RANGE__1_10__1_13_2);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.MAIN_HAND, 13), ProtocolVersionsHelper.ALL_1_9);

		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.LEFT_SHOULDER_ENTITY, 18), ProtocolVersionsHelper.UP_1_15);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.LEFT_SHOULDER_ENTITY, 17), ProtocolVersionsHelper.ALL_1_14);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.LEFT_SHOULDER_ENTITY, 15), ProtocolVersionsHelper.RANGE__1_12__1_13_2);

		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.RIGHT_SHOULDER_ENTITY, 19), ProtocolVersionsHelper.UP_1_15);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.RIGHT_SHOULDER_ENTITY, 18), ProtocolVersionsHelper.ALL_1_14);
		addTransformer(new NetworkEntityMetadataObjectIndexValueNoOpTransformer(NetworkEntityMetadataObjectIndex.Player.RIGHT_SHOULDER_ENTITY, 16), ProtocolVersionsHelper.RANGE__1_12__1_13_2);

		addTransformer(new NetworkEntityMetadataFormatTransformer() {
			@Override
			public void transform(NetworkEntity entity, ArrayMap<NetworkEntityMetadataObject<?>> original, NetworkEntityMetadataList remapped) {
				NetworkEntityMetadataObjectByte baseflags = NetworkEntityMetadataObjectIndex.Entity.BASE_FLAGS.getObject(original);
				NetworkEntityMetadataObjectByte handuse = NetworkEntityMetadataObjectIndex.EntityLiving.HAND_USE.getObject(original);
				if ((baseflags != null) || (handuse != null)) {
					HandUseAsBaseFlagsTransformer transformer = entity.getDataCache().computeDataIfAbsent(DATA_KEY_BASE_FLAGS, k -> new HandUseAsBaseFlagsTransformer());
					if (baseflags != null) {
						transformer.updateBaseFlags(baseflags.getValue());
					}
					if (handuse != null) {
						transformer.updateUseHands((byte) (handuse.getValue() & 1));
					}
					remapped.add(0, new NetworkEntityMetadataObjectByte(transformer.getComputedBaseFlags()));
				}
			}
		}, ProtocolVersionsHelper.DOWN_1_8);
	}

}
