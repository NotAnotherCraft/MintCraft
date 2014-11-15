package net.notanothercraft.mintcraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by KJ4IPS on 11/15/2014.
 */
public class BagContainer extends Container {

    protected BagContents contents;
    protected InventoryPlayer playerInv;

    public BagContainer(InventoryPlayer playerInv, BagContents contents){
        this.contents = contents;
        this.playerInv = playerInv;
        bindPlayerInv(playerInv);
    }

    protected void bindPlayerInv(InventoryPlayer playerInv){
        //main three inventory rows
        for(int i = 0; i < 3 ; i++){
            for(int j = 0; j < 9; j++){
                addSlotToContainer(new Slot(playerInv, j+i*9+9, 8+j*18, 84+i*18));
            }
        }
        //hotbar
        for(int i = 0; i < 9; i++){
            addSlotToContainer(new Slot(playerInv, i, 8+i*18,142));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot){
        return null;
    }
}
