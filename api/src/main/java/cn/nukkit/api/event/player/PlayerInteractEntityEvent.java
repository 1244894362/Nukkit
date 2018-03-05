package cn.nukkit.api.event.player;

import cn.nukkit.api.Player;
import cn.nukkit.api.entity.Entity;
import cn.nukkit.api.event.Cancellable;
import cn.nukkit.api.item.ItemInstance;

public class PlayerInteractEntityEvent implements PlayerEvent, Cancellable {
    private final Player player;
    private final Entity entity;
    private final ItemInstance item;
    private boolean cancelled;

    public PlayerInteractEntityEvent(Player player, Entity entity, ItemInstance item) {
        this.player = player;
        this.entity = entity;
        this.item = item;
    }

    @Override
    public Player getPlayer() {
        return player;
    }

    public Entity getEntity() {
        return entity;
    }

    public ItemInstance getItem() {
        return item;
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
