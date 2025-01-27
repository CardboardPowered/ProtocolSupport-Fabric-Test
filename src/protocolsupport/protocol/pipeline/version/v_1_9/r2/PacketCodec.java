package protocolsupport.protocol.pipeline.version.v_1_9.r2;

import protocolsupport.protocol.packet.PacketType;
import protocolsupport.protocol.pipeline.version.util.codec.ModernPacketCodec;

public class PacketCodec extends ModernPacketCodec {

	protected static final PacketCodec instance = new PacketCodec();

	{
		registry.register(PacketType.CLIENTBOUND_LOGIN_DISCONNECT, 0x0);
		registry.register(PacketType.CLIENTBOUND_LOGIN_ENCRYPTION_BEGIN, 0x1);
		registry.register(PacketType.CLIENTBOUND_LOGIN_SUCCESS, 0x2);
		registry.register(PacketType.CLIENTBOUND_LOGIN_SET_COMPRESSION, 0x3);
		registry.register(PacketType.CLIENTBOUND_STATUS_SERVER_INFO, 0x0);
		registry.register(PacketType.CLIENTBOUND_STATUS_PONG, 0x1);
		registry.register(PacketType.CLIENTBOUND_PLAY_KEEP_ALIVE, 0x1F);
		registry.register(PacketType.CLIENTBOUND_PLAY_START_GAME, 0x23);
		registry.register(PacketType.CLIENTBOUND_PLAY_CHAT, 0xF);
		registry.register(PacketType.CLIENTBOUND_PLAY_UPDATE_TIME, 0x44);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_EQUIPMENT, 0x3C);
		registry.register(PacketType.CLIENTBOUND_PLAY_SPAWN_POSITION, 0x43);
		registry.register(PacketType.CLIENTBOUND_PLAY_SET_HEALTH, 0x3E);
		registry.register(PacketType.CLIENTBOUND_PLAY_RESPAWN, 0x33);
		registry.register(PacketType.CLIENTBOUND_PLAY_POSITION, 0x2E);
		registry.register(PacketType.CLIENTBOUND_PLAY_HELD_SLOT, 0x37);
		registry.register(PacketType.CLIENTBOUND_LEGACY_PLAY_USE_BED, 0x2F);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_ANIMATION, 0x6);
		registry.register(PacketType.CLIENTBOUND_PLAY_SPAWN_NAMED, 0x5);
		registry.register(PacketType.CLIENTBOUND_PLAY_COLLECT_EFFECT, 0x48);
		registry.register(PacketType.CLIENTBOUND_PLAY_SPAWN_OBJECT, 0x0);
		registry.register(PacketType.CLIENTBOUND_PLAY_SPAWN_LIVING, 0x3);
		registry.register(PacketType.CLIENTBOUND_PLAY_SPAWN_PAINTING, 0x4);
		registry.register(PacketType.CLIENTBOUND_PLAY_SPAWN_EXP_ORB, 0x1);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_VELOCITY, 0x3B);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_DESTROY, 0x30);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_NOOP, 0x28);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_REL_MOVE, 0x25);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_LOOK, 0x27);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_REL_MOVE_LOOK, 0x26);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_TELEPORT, 0x49);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_HEAD_ROTATION, 0x34);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_STATUS, 0x1B);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_LEASH, 0x3A);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_METADATA, 0x39);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_EFFECT_ADD, 0x4B);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_EFFECT_REMOVE, 0x31);
		registry.register(PacketType.CLIENTBOUND_PLAY_SET_EXPERIENCE, 0x3D);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_ATTRIBUTES, 0x4A);
		registry.register(PacketType.CLIENTBOUND_PLAY_CHUNK_SINGLE, 0x20);
		registry.register(PacketType.CLIENTBOUND_PLAY_BLOCK_CHANGE_MULTI, 0x10);
		registry.register(PacketType.CLIENTBOUND_PLAY_BLOCK_CHANGE_SINGLE, 0xB);
		registry.register(PacketType.CLIENTBOUND_PLAY_BLOCK_ACTION, 0xA);
		registry.register(PacketType.CLIENTBOUND_PLAY_BLOCK_BREAK_ANIMATION, 0x8);
		registry.register(PacketType.CLIENTBOUND_PLAY_EXPLOSION, 0x1C);
		registry.register(PacketType.CLIENTBOUND_PLAY_WORLD_EVENT, 0x21);
		registry.register(PacketType.CLIENTBOUND_PLAY_WORLD_SOUND, 0x46);
		registry.register(PacketType.CLIENTBOUND_PLAY_WORLD_PARTICLES, 0x22);
		registry.register(PacketType.CLIENTBOUND_PLAY_GAME_STATE_CHANGE, 0x1E);
		registry.register(PacketType.CLIENTBOUND_LEGACY_PLAY_SPAWN_GLOBAL, 0x2);
		registry.register(PacketType.CLIENTBOUND_PLAY_WINDOW_OPEN, 0x13);
		registry.register(PacketType.CLIENTBOUND_PLAY_WINDOW_CLOSE, 0x12);
		registry.register(PacketType.CLIENTBOUND_PLAY_WINDOW_SET_SLOT, 0x16);
		registry.register(PacketType.CLIENTBOUND_PLAY_WINDOW_SET_ITEMS, 0x14);
		registry.register(PacketType.CLIENTBOUND_PLAY_WINDOW_DATA, 0x15);
		registry.register(PacketType.CLIENTBOUND_PLAY_WINDOW_TRANSACTION, 0x11);
		registry.register(PacketType.CLIENTBOUND_PLAY_UPDATE_MAP, 0x24);
		registry.register(PacketType.CLIENTBOUND_PLAY_BLOCK_TILE, 0x9);
		registry.register(PacketType.CLIENTBOUND_PLAY_SIGN_EDITOR, 0x2A);
		registry.register(PacketType.CLIENTBOUND_PLAY_PLAYER_INFO, 0x2D);
		registry.register(PacketType.CLIENTBOUND_PLAY_PLAYER_ABILITIES, 0x2B);
		registry.register(PacketType.CLIENTBOUND_PLAY_TAB_COMPLETE, 0xE);
		registry.register(PacketType.CLIENTBOUND_PLAY_SCOREBOARD_OBJECTIVE, 0x3F);
		registry.register(PacketType.CLIENTBOUND_PLAY_SCOREBOARD_SCORE, 0x42);
		registry.register(PacketType.CLIENTBOUND_PLAY_SCOREBOARD_DISPLAY_SLOT, 0x38);
		registry.register(PacketType.CLIENTBOUND_PLAY_SCOREBOARD_TEAM, 0x41);
		registry.register(PacketType.CLIENTBOUND_PLAY_CUSTOM_PAYLOAD, 0x18);
		registry.register(PacketType.CLIENTBOUND_PLAY_KICK_DISCONNECT, 0x1A);
		registry.register(PacketType.CLIENTBOUND_PLAY_RESOURCE_PACK, 0x32);
		registry.register(PacketType.CLIENTBOUND_PLAY_CAMERA, 0x36);
		registry.register(PacketType.CLIENTBOUND_PLAY_WORLD_BORDER, 0x35);
		registry.register(PacketType.CLIENTBOUND_PLAY_TITLE, 0x45);
		registry.register(PacketType.CLIENTBOUND_PLAY_PLAYER_LIST_HEADER_FOOTER, 0x47);
		registry.register(PacketType.CLIENTBOUND_PLAY_ENTITY_PASSENGERS, 0x40);
		registry.register(PacketType.CLIENTBOUND_PLAY_CHUNK_UNLOAD, 0x1D);
		registry.register(PacketType.CLIENTBOUND_PLAY_WORLD_CUSTOM_SOUND, 0x19);
		registry.register(PacketType.CLIENTBOUND_PLAY_SERVER_DIFFICULTY, 0xD);
		registry.register(PacketType.CLIENTBOUND_PLAY_COMBAT_EVENT, 0x2C);
		registry.register(PacketType.CLIENTBOUND_PLAY_BOSS_BAR, 0xC);
		registry.register(PacketType.CLIENTBOUND_PLAY_SET_COOLDOWN, 0x17);
		registry.register(PacketType.CLIENTBOUND_PLAY_VEHICLE_MOVE, 0x29);
	}

}
