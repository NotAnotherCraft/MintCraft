package net.notanothercraft.mintcraft.item;

import net.minecraft.item.ItemStack;

/**
 * Created by KJ4IPS on 11/14/2014.
 * An interface for things with monetary worth
 */
public interface IValuable {
    public Integer getWorth(ItemStack is);
}
