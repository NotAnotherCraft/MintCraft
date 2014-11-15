package net.notanothercraft.mintcraft.item;

import net.minecraft.item.Item;

/**
 * Created by Azreth on 11/14/14.
 */
public class ItemCoinGold extends ItemCoin {
    public ItemCoinGold(){
        super();
        this.setWorth(15);
        this.setUnlocalizedName("coingold");
        this.setTextureName("mintcraft:coin");
    }
}
