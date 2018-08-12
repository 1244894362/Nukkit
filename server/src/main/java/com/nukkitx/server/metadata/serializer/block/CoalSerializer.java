package com.nukkitx.server.metadata.serializer.block;

import com.nukkitx.api.item.ItemInstance;
import com.nukkitx.api.item.ItemType;
import com.nukkitx.api.metadata.Metadata;
import com.nukkitx.api.metadata.item.Coal;
import com.nukkitx.server.metadata.serializer.Serializer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static com.nukkitx.api.metadata.item.Coal.CHARCOAL;
import static com.nukkitx.api.metadata.item.Coal.REGULAR;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CoalSerializer implements Serializer {

    public static final Serializer INSTANCE = new CoalSerializer();

    @Override
    public short readMetadata(ItemInstance item) {
        Coal coal = item.ensureMetadata(Coal.class);
        return (short) coal.ordinal();
    }

    @Override
    public Metadata writeMetadata(ItemType type, short metadata) {
        return metadata != 0 ? CHARCOAL : REGULAR;
    }
}
