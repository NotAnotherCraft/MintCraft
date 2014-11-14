package net.notanothercraft.mintcraft.item;

import net.minecraft.item.Item;

/**
 * Created by KJ4IPS on 11/14/2014.
 * An item that has currency
 */
public class ItemCurrency extends Item {

    private Integer worth;

    public ItemCurrency(){
        super();
        this.worth = 0;
    }

    public Integer getWorth() {
        return worth;
    }

    public void setWorth(Integer worth) {
        this.worth = worth;
    }
}
