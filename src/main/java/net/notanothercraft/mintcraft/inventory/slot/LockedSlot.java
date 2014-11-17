package net.notanothercraft.mintcraft.inventory.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

/**
 * Created by KJ4IPS on 11/15/2014.
 */
public class LockedSlot extends Slot {
    public LockedSlot(IInventory inventory, int index, int drawX, int drawY) {
        super(inventory, index, drawX, drawY);
    }

    @Override
    public boolean canTakeStack(EntityPlayer player) {
        return false;
    }
}
