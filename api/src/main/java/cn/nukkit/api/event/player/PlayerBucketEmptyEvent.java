package cn.nukkit.api.event.player;

import cn.nukkit.api.Player;
import cn.nukkit.api.block.Block;
import cn.nukkit.api.item.ItemInstance;
import cn.nukkit.api.util.data.BlockFace;

public class PlayerBucketEmptyEvent extends PlayerBucketEvent {

    public PlayerBucketEmptyEvent(Player who, Block blockClicked, BlockFace blockFace, ItemInstance bucket, ItemInstance itemInHand) {
        super(who, blockClicked, blockFace, bucket, itemInHand);
    }
}
