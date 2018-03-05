package cn.nukkit.api.event.player;

import cn.nukkit.api.Player;
import cn.nukkit.api.event.Cancellable;

public class PlayerCommandPreprocessEvent extends PlayerMessageEvent implements Cancellable {
    private boolean cancelled;

    public PlayerCommandPreprocessEvent(final Player player, String message) {
        super(player, message);
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
