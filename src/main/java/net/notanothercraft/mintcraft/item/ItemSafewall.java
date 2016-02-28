package net.notanothercraft.mintcraft.item;

import net.minecraft.item.Item;

/**
 * Created by Azreth on 2/27/2016.
 * An Iron wall for building a safe
 */
public class ItemSafewall extends Item {
    public ItemSafewall(){
        this.setUnlocalizedName("safewall");
        this.setTextureName("mintcraft:cardboard");
        this.setMaxStackSize(4);
    }
}
