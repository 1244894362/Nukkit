package cn.nukkit.server.level.sound;

import cn.nukkit.server.math.Vector3;
import cn.nukkit.server.network.protocol.LevelEventPacket;

/**
 * Created on 2015/11/21 by xtypr.
 * Package cn.nukkit.server.level.sound in project Nukkit .
 */
public class DoorCrashSound extends LevelEventSound {
    public DoorCrashSound(Vector3 pos) {
        this(pos, 0);
    }

    public DoorCrashSound(Vector3 pos, float pitch) {
        super(pos, LevelEventPacket.EVENT_SOUND_DOOR_CRASH, pitch);
    }
}
