package cn.nukkit.server.inventory;

import cn.nukkit.api.inventory.Inventory;
import cn.nukkit.api.item.ItemInstance;
import cn.nukkit.server.network.minecraft.session.PlayerSession;

import javax.annotation.Nullable;
import javax.annotation.ParametersAreNonnullByDefault;

/**
 * An object that can view a specific inventory.
 */
@ParametersAreNonnullByDefault
public interface InventoryObserver {

    /**
     * Called when a single slot is changed within the observed inventory.
     *
     * @param slot      slot in question
     * @param oldItem   old item in slot
     * @param newItem   new item in slot
     * @param inventory inventory being observed
     * @param session   session which caused the change
     */
    void onInventorySlotChange(int slot, @Nullable ItemInstance oldItem, @Nullable ItemInstance newItem, Inventory inventory, @Nullable PlayerSession session);

    /**
     * Called when the entire contents of the inventory is changed within the observed inventory.
     *
     * @param contents  new contents of the inventory
     * @param inventory inventory being observed
     */
    void onInventoryContentsChange(ItemInstance[] contents, Inventory inventory);
}
