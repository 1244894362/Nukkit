package cn.nukkit.server.network.minecraft.packet;

import cn.nukkit.server.network.NetworkPacketHandler;
import cn.nukkit.server.network.minecraft.MinecraftPacket;
import io.netty.buffer.ByteBuf;

public class CraftingDataPacket implements MinecraftPacket {
    @Override
    public void encode(ByteBuf buffer) {
        //TODO: Rewrite this.
    }

    @Override
    public void decode(ByteBuf buffer) {

    }

    @Override
    public void handle(NetworkPacketHandler handler) {

    }
}
