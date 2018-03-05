package cn.nukkit.api.event.level;

import cn.nukkit.api.event.Cancellable;
import cn.nukkit.api.level.Level;

public class WeatherChangeEvent extends WeatherEvent implements Cancellable {
    private final boolean to;
    private boolean cancelled;

    public WeatherChangeEvent(Level level, boolean to) {
        super(level);
        this.to = to;
    }

    /**
     * Gets the state of weather that the world is being set to
     *
     * @return true if the weather is being set to raining, false otherwise
     */
    public boolean toWeatherState() {
        return to;
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
