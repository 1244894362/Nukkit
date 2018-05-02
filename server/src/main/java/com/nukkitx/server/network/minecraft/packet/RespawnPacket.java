package com.nukkitx.server.network.minecraft.packet;

import com.flowpowered.math.vector.Vector3f;
import com.nukkitx.server.network.minecraft.MinecraftPacket;
import com.nukkitx.server.network.minecraft.NetworkPacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.Data;

import static com.nukkitx.server.network.minecraft.MinecraftUtil.writeVector3f;

@Data
public class RespawnPacket implements MinecraftPacket {
    private Vector3f position;

    @Override
    public void encode(ByteBuf buffer) {
        writeVector3f(buffer, position);
    }

    @Override
    public void decode(ByteBuf buffer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void handle(NetworkPacketHandler handler) {
        // Client bound only.
    }
}
