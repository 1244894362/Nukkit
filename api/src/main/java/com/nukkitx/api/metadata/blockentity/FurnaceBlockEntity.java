package com.nukkitx.api.metadata.blockentity;

import com.nukkitx.api.inventory.Inventory;
import com.nukkitx.api.inventory.InventoryHolder;
import com.nukkitx.api.item.ItemInstance;

import javax.annotation.Nullable;

public interface FurnaceBlockEntity extends BlockEntity, InventoryHolder {

    boolean isFuel(@Nullable ItemInstance item);

    int getBurnDuration(@Nullable ItemInstance item);

    boolean isIngredient(@Nullable ItemInstance item);

    @Override
    Inventory getInventory();
}
