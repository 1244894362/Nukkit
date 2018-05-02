package com.nukkitx.server.network.minecraft.packet;

import com.nukkitx.server.network.minecraft.MinecraftPacket;
import com.nukkitx.server.network.minecraft.NetworkPacketHandler;
import io.netty.buffer.ByteBuf;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import static com.nukkitx.nbt.util.VarInt.readUnsignedInt;
import static com.nukkitx.server.network.minecraft.MinecraftUtil.readString;

@Data
public class PurchaseReceiptPacket implements MinecraftPacket {
    private final List<String> receipts = new ArrayList<>();

    @Override
    public void encode(ByteBuf buffer) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void decode(ByteBuf buffer) {
        int receiptCount = readUnsignedInt(buffer);

        for (int i = 0; i < receiptCount; i++) {
            receipts.add(readString(buffer));
        }
    }

    @Override
    public void handle(NetworkPacketHandler handler) {
        handler.handle(this);
    }
}
