package com.nukkitx.api.plugin;

import com.google.common.base.Preconditions;

import javax.annotation.Nullable;

public enum PluginLoadOrder {
    STARTUP,
    POSTWORLD,
    POSTNETWORK;

    @Nullable
    public static PluginLoadOrder parse(String order) {
        Preconditions.checkNotNull(order, "order");
        for (PluginLoadOrder value: values()) {
            if (order.equalsIgnoreCase(value.name())) {
                return value;
            }
        }
        return null;
    }
}
