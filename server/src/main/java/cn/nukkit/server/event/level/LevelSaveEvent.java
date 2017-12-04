package cn.nukkit.server.event.level;

import cn.nukkit.server.event.HandlerList;
import cn.nukkit.server.level.Level;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class LevelSaveEvent extends LevelEvent {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    public LevelSaveEvent(Level level) {
        super(level);
    }

}
