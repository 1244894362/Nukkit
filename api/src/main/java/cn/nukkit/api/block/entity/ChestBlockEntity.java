package cn.nukkit.api.block.entity;

import cn.nukkit.api.inventory.Inventory;
import cn.nukkit.api.inventory.InventoryHolder;

public interface ChestBlockEntity extends BlockEntity, InventoryHolder {

    boolean isTrapped();

    @Override
    Inventory getInventory();

    boolean isLargeChest();
}
