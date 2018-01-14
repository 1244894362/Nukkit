package cn.nukkit.server.metadata.serializer;

import cn.nukkit.api.block.BlockState;
import cn.nukkit.api.block.entity.BlockEntity;
import cn.nukkit.api.item.ItemStack;
import cn.nukkit.api.item.ItemType;
import cn.nukkit.api.metadata.Metadata;
import cn.nukkit.server.nbt.tag.CompoundTag;
import gnu.trove.map.hash.TIntObjectHashMap;
import lombok.experimental.UtilityClass;

@UtilityClass
public class MetadataSerializer {
    private static final TIntObjectHashMap<Serializer> SERIALIZERS = new TIntObjectHashMap<>();

    public static Metadata deserializeMetadata(ItemType type, short metadata) {
        Serializer serializer = SERIALIZERS.get(type.getId());
        if (serializer == null) {
            return null;
        }

        return serializer.writeMetadata(type, metadata);
    }

    public static BlockEntity deserializeNBT(ItemType type, CompoundTag tag) {
        Serializer serializer = SERIALIZERS.get(type.getId());
        if (serializer == null) {
            return null;
        }

        return serializer.writeNBT(type, tag);
    }

    public static short serializeMetadata(BlockState block) {
        Serializer dataSerializer = SERIALIZERS.get(block.getBlockType().getId());
        if (dataSerializer == null) {
            return 0;
        }

        return dataSerializer.readMetadata(block);
    }

    public static short serializeMetadata(ItemStack itemStack) {
        Serializer dataSerializer = SERIALIZERS.get(itemStack.getItemType().getId());
        if (dataSerializer == null) {
            return 0;
        }

        return dataSerializer.readMetadata(itemStack);
    }

    public static CompoundTag serializeNBT(BlockState block) {
        Serializer dataSerializer = SERIALIZERS.get(block.getBlockType().getId());
        if (dataSerializer == null) {
            return null;
        }

        return dataSerializer.readNBT(block);
    }

}
