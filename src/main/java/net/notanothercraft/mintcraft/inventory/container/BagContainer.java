package net.notanothercraft.mintcraft.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.notanothercraft.mintcraft.MintCraftMod;
import net.notanothercraft.mintcraft.inventory.BagContents;
import net.notanothercraft.mintcraft.inventory.slot.CoinSlot;
import net.notanothercraft.mintcraft.inventory.slot.LockedSlot;
import net.notanothercraft.mintcraft.util.InventoryUtil;

/**
 * Created by KJ4IPS on 11/15/2014.
 */
public class BagContainer extends Container {

    protected BagContents contents;
    protected InventoryPlayer playerInv;
    protected ItemStack bag;

    private static final int[][] slotPositions = new int[][]{
        {27,15},
        {63,15},
        {99,15},
        {134,15},
        {27,43},
        {63,43},
        {99,43},
        {134,43}

    };

    public BagContainer(InventoryPlayer playerInv, BagContents contents, ItemStack bag){
        this.contents = contents;
        this.playerInv = playerInv;
        this.bag = bag;
        bindBagInv(contents);
        bindPlayerInv(playerInv, 9, 81,4);
    }

    protected void bindBagInv(BagContents contents){
        for(int i = 0; i < contents.getSizeInventory(); i++){
            addSlotToContainer(new CoinSlot(contents,i,slotPositions[i][0],slotPositions[i][1]));
        }
    }

    protected void bindPlayerInv(InventoryPlayer playerInv,int drawX, int drawY, int hotbarOffset){
        //main three inventory rows
        for(int i = 0; i < 3 ; i++){
            for(int j = 0; j < 9; j++){
                bindPlayerSlot(playerInv, j+i*9+9, drawX+j*18, drawY+i*18, MintCraftMod.instance.itemCoinBag);
            }
        }
        //hotbar
        for(int i = 0; i < 9; i++){
            bindPlayerSlot(playerInv, i, drawX + i * 18, drawY + 3*18 + hotbarOffset, MintCraftMod.instance.itemCoinBag);
        }
    }

    protected void bindPlayerSlot(InventoryPlayer inv, int index, int drawX, int drawY, Item itemToLock){
        if(inv.getStackInSlot(index) != null &&
                inv.getStackInSlot(index).getItem() != null &&
                inv.getStackInSlot(index).getItem().equals(itemToLock)){
            addSlotToContainer(new LockedSlot(inv, index, drawX, drawY));
        }else{
            addSlotToContainer(new Slot(inv, index, drawX, drawY));
        }
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }

    @Override
    public void onContainerClosed(EntityPlayer player) {
        if(!player.worldObj.isRemote) {
            player.getCurrentEquippedItem().setTagCompound(contents.saveToNBTCompound());
        }
        super.onContainerClosed(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot){
        return InventoryUtil.handleShiftClick(slot, player, inventorySlots);
    }

}
