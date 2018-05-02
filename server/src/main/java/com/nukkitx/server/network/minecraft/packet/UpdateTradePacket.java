package com.nukkitx.server.network.minecraft.packet;

import com.nukkitx.nbt.NBTEncodingType;
import com.nukkitx.nbt.stream.NBTOutputStream;
import com.nukkitx.nbt.tag.Tag;
import com.nukkitx.server.network.minecraft.MinecraftPacket;
import com.nukkitx.server.network.minecraft.NetworkPacketHandler;
import com.nukkitx.server.network.util.LittleEndianByteBufOutputStream;
import io.netty.buffer.ByteBuf;
import lombok.Data;

import java.io.IOException;

import static com.nukkitx.nbt.util.VarInt.writeSignedInt;
import static com.nukkitx.server.network.minecraft.MinecraftUtil.writeString;
import static com.nukkitx.server.network.minecraft.MinecraftUtil.writeUniqueEntityId;

@Data
public class UpdateTradePacket implements MinecraftPacket {
    private byte windowId;
    private byte windowType;
    private int unknown0; // Couldn't find anything on this one.
    private int unknown1; // Something to do with AI and randomness?
    private boolean willing;
    private long traderUniqueEntityId;
    private long playerUniqueEntityId;
    private String displayName;
    private Tag<?> offers;

    @Override
    public void encode(ByteBuf buffer) {
        buffer.writeByte(windowId);
        buffer.writeByte(windowType);
        writeSignedInt(buffer, unknown0);
        writeSignedInt(buffer, unknown1);
        buffer.writeBoolean(willing);
        writeUniqueEntityId(buffer, traderUniqueEntityId);
        writeUniqueEntityId(buffer, playerUniqueEntityId);
        writeString(buffer, displayName);
        try (NBTOutputStream writer = new NBTOutputStream(new LittleEndianByteBufOutputStream(buffer), NBTEncodingType.BEDROCK)) {
            writer.write(offers);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void decode(ByteBuf buffer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void handle(NetworkPacketHandler handler) {
        // Only client bound.
    }
}
