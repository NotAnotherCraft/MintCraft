package net.notanothercraft.mintcraft.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by KJ4IPS on 11/14/2014.
 * An item that has currency
 */
public abstract class ItemCurrency extends Item implements IValuable{

    private Integer worth;

    public ItemCurrency(){
        super();
        this.worth = 0;
    }

    public Integer getWorth(ItemStack is) {
        return worth;
    }

    public void setWorth(Integer worth) {
        this.worth = worth;
    }
}
