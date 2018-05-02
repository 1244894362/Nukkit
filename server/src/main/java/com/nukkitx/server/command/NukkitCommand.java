package com.nukkitx.server.command;

import com.google.common.base.Preconditions;
import com.nukkitx.api.command.Command;
import com.nukkitx.api.command.CommandData;
import com.nukkitx.api.command.CommandExecutor;
import com.nukkitx.api.command.sender.CommandSender;
import com.nukkitx.api.message.TextFormat;
import com.nukkitx.api.message.TranslationMessage;

import java.util.Optional;

public class NukkitCommand implements Command {
    private final String name;
    private final CommandExecutor executor;
    protected final CommandData data;

    public NukkitCommand(String name, CommandExecutor executor, CommandData data) {
        this.name = Preconditions.checkNotNull(name, "name");
        this.executor = Preconditions.checkNotNull(executor, "executor");
        this.data = Preconditions.checkNotNull(data, "data");
    }

    NukkitCommand(String name, CommandData data) {
        executor = null;
        this.name = Preconditions.checkNotNull(name, "name");
        this.data = Preconditions.checkNotNull(data, "data");
    }

    @Override
    public CommandExecutor getExecutor() {
        return executor;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public CommandData getData() {
        return data;
    }

    public boolean testPermission(CommandSender target) {
        if (this.testPermissionSilent(target)) {
            return true;
        }

        Optional<String> permissionMessage = data.getPermissionMessage();
        if (!permissionMessage.isPresent()) {
            target.sendMessage(new TranslationMessage(TextFormat.RED + "%commands.generic.unknown", name));
        } else {
            data.getPermission().ifPresent(permission -> target.sendMessage(permissionMessage.get().replace("<permission>", permission)));
        }

        return false;
    }

    public boolean testPermissionSilent(CommandSender target) {
        if (!data.getPermission().isPresent()) return true;

        String[] permissions = data.getPermission().get().split(";");
        for (String permission : permissions) {
            if (target.hasPermission(permission)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean onCommand(CommandSender sender, String label, String[] args) {
        return executor.onCommand(sender, label, args);
    }
}
