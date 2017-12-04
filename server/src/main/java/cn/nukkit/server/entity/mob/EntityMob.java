package cn.nukkit.server.entity.mob;

import cn.nukkit.server.entity.EntityCreature;
import cn.nukkit.server.level.format.FullChunk;
import cn.nukkit.server.nbt.tag.CompoundTag;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public abstract class EntityMob extends EntityCreature {

    public EntityMob(FullChunk chunk, CompoundTag nbt) {
        super(chunk, nbt);
    }
}
