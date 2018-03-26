package cn.nukkit.server.entity.monster;

import cn.nukkit.api.entity.monster.Guardian;
import cn.nukkit.server.NukkitServer;
import cn.nukkit.server.entity.EntityType;
import cn.nukkit.server.entity.LivingEntity;
import cn.nukkit.server.level.NukkitLevel;
import com.flowpowered.math.vector.Vector3f;

public class GuardianEntity extends LivingEntity implements Guardian {

    public GuardianEntity(Vector3f position, NukkitLevel level, NukkitServer server) {
        super(EntityType.GUARDIAN, position, level, server, 30);
    }
}
