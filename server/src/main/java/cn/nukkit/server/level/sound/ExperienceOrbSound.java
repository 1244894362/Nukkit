package cn.nukkit.server.level.sound;

import cn.nukkit.server.math.Vector3;
import cn.nukkit.server.network.protocol.LevelEventPacket;

/**
 * Created by Pub4Game on 28.06.2016.
 */
public class ExperienceOrbSound extends LevelEventSound {
    public ExperienceOrbSound(Vector3 pos) {
        this(pos, 0);
    }

    public ExperienceOrbSound(Vector3 pos, float pitch) {
        super(pos, LevelEventPacket.EVENT_SOUND_EXPERIENCE_ORB, pitch);
    }
}
