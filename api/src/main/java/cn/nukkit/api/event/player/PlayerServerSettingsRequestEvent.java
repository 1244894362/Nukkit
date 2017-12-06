package cn.nukkit.api.event.player;

import cn.nukkit.api.Player;
import cn.nukkit.server.event.Cancellable;
import cn.nukkit.server.event.HandlerList;
import cn.nukkit.server.form.window.FormWindow;

import java.util.Map;

/**
 * @author CreeperFace
 */
public class PlayerServerSettingsRequestEvent extends PlayerEvent implements Cancellable {

    private static final HandlerList handlers = new HandlerList();

    public static HandlerList getHandlers() {
        return handlers;
    }

    private Map<Integer, FormWindow> settings;

    public PlayerServerSettingsRequestEvent(Player player, Map<Integer, FormWindow> settings) {
        this.player = player;
        this.settings = settings;
    }

    public Map<Integer, FormWindow> getSettings() {
        return settings;
    }

    public void setSettings(Map<Integer, FormWindow> settings) {
        this.settings = settings;
    }

    public void setSettings(int id, FormWindow window) {
        this.settings.put(id, window);
    }
}
