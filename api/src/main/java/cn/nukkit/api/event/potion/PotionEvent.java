package cn.nukkit.api.event.potion;

import cn.nukkit.api.entity.misc.Potion;
import cn.nukkit.api.event.Event;

public interface PotionEvent extends Event {

    Potion getPotion();

    void setPotion(Potion potion);

}
