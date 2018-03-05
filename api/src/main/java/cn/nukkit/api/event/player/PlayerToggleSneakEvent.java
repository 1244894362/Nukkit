package cn.nukkit.api.event.player;

import cn.nukkit.api.Player;
import cn.nukkit.api.event.Cancellable;

public class PlayerToggleSneakEvent implements PlayerEvent, Cancellable {
    private final Player player;
    private final boolean isSneaking;
    private boolean cancelled;

    public PlayerToggleSneakEvent(Player player, boolean isSneaking) {
        this.player = player;
        this.isSneaking = isSneaking;
    }

    public boolean isSneaking() {
        return isSneaking;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
