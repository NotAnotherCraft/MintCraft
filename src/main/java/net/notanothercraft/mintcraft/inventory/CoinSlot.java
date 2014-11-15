package net.notanothercraft.mintcraft.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.notanothercraft.mintcraft.MintCraftMod;

/**
 * Created by KJ4IPS on 11/14/2014.
 */
public class CoinSlot extends Slot {
    public CoinSlot(IInventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean isItemValid(ItemStack itemStack) {
        return itemStack.getItem().equals(MintCraftMod.instance.itemCoin);
    }
}
