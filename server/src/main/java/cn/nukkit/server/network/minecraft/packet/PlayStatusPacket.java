package cn.nukkit.server.network.minecraft.packet;

import cn.nukkit.server.network.NetworkPacketHandler;
import cn.nukkit.server.network.minecraft.MinecraftPacket;
import io.netty.buffer.ByteBuf;
import lombok.Data;

@Data
public class PlayStatusPacket implements MinecraftPacket {
    private Status status;

    @Override
    public void encode(ByteBuf buffer) {
        buffer.writeInt(status.ordinal());
    }

    @Override
    public void decode(ByteBuf buffer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void handle(NetworkPacketHandler handler) {
        // Only client bound
    }

    public enum Status {
        LOGIN_SUCCESS,
        FAILED_CLIENT,
        FAILED_SERVER,
        PLAYER_SPAWN,
        FAILED_INVALID_TENANT,
        FAILED_VANILLA_EDU,
        FAILED_EDU_VANILLA
    }
}
