package com.nukkitx.server.entity.monster;

import com.flowpowered.math.vector.Vector3f;
import com.nukkitx.api.entity.monster.Ghast;
import com.nukkitx.server.NukkitServer;
import com.nukkitx.server.entity.EntityType;
import com.nukkitx.server.entity.LivingEntity;
import com.nukkitx.server.level.NukkitLevel;

public class GhastEntity extends LivingEntity implements Ghast {

    public GhastEntity(Vector3f position, NukkitLevel level, NukkitServer server) {
        super(EntityType.GHAST, position, level, server, 10);
    }
}
