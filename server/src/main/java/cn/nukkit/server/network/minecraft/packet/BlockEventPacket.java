package cn.nukkit.server.network.minecraft.packet;

import cn.nukkit.server.network.NetworkPacketHandler;
import cn.nukkit.server.network.minecraft.MinecraftPacket;
import com.flowpowered.math.vector.Vector3i;
import io.netty.buffer.ByteBuf;
import lombok.Data;

import static cn.nukkit.server.nbt.util.VarInt.writeSignedInt;
import static cn.nukkit.server.network.minecraft.MinecraftUtil.writeBlockPosition;

@Data
public class BlockEventPacket implements MinecraftPacket {
    private Vector3i blockPosition;
    private Type eventType;
    private int eventData;

    @Override
    public void encode(ByteBuf buffer) {
        writeBlockPosition(buffer, blockPosition);
        writeSignedInt(buffer, eventType.ordinal());
        writeSignedInt(buffer, eventData);
    }

    @Override
    public void decode(ByteBuf buffer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void handle(NetworkPacketHandler handler) {
        // This packet isn't handled
    }

    public enum Type {
        NONE,
        CHEST
    }
}
