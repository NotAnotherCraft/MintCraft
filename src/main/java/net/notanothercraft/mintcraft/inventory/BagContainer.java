package net.notanothercraft.mintcraft.inventory;

import com.google.common.collect.Lists;
import com.sun.javafx.geom.Vec2d;
import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.notanothercraft.mintcraft.MintCraftMod;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        Slot clickedSlot = this.getSlot(slot);
        ItemStack clickedStack = clickedSlot.getStack();
        IInventory sourceInventory = clickedSlot.inventory;
        if(clickedStack == null) return null;
        Iterator slotIterator = inventorySlots.iterator();
        while(slotIterator.hasNext() && clickedSlot.getHasStack() && clickedSlot.getStack().stackSize > 0){ //Search for slots with the same item
            Slot activeSlot = (Slot) slotIterator.next();
            if(        !sourceInventory.equals(activeSlot.inventory)
                    && activeSlot.getHasStack()
                    && stacksEquivelent(activeSlot.getStack(), clickedStack)
                    && activeSlot.canTakeStack(player)
                    && activeSlot.isItemValid(clickedStack)){
                //Mix in
                int numberToMove = Math.min(
                        clickedStack.stackSize,
                        activeSlot.getSlotStackLimit() - activeSlot.getStack().stackSize
                );
                ItemStack workingStack;
                workingStack = activeSlot.getStack().copy();
                workingStack.stackSize += numberToMove;
                activeSlot.putStack(workingStack.copy());
                workingStack = clickedSlot.getStack().copy();
                workingStack.stackSize -= numberToMove;
                clickedSlot.putStack(workingStack.stackSize > 0 ? workingStack.copy() : null);
                clickedStack = clickedSlot.getStack();
            }
        }
        slotIterator = null;
        slotIterator = inventorySlots.iterator();
        while(slotIterator.hasNext() && clickedSlot.getHasStack() && clickedStack.stackSize > 0) { //Search for slots with no item
            Slot activeSlot = (Slot) slotIterator.next();
            if(        !sourceInventory.equals(activeSlot.inventory)
                    && !activeSlot.getHasStack()
                    && activeSlot.canTakeStack(player)
                    && activeSlot.isItemValid(clickedStack)){
                //Move In
                int numberToMove = Math.min(
                        clickedStack.stackSize,
                        activeSlot.getSlotStackLimit()
                );
                ItemStack workingStack;
                workingStack = clickedStack.copy();
                workingStack.stackSize = numberToMove;
                activeSlot.putStack(workingStack.copy());
                workingStack = clickedStack.copy();
                workingStack.stackSize -= numberToMove;
                clickedSlot.putStack(workingStack.stackSize > 0 ? workingStack.copy() : null);
                clickedStack = clickedSlot.getStack();
            }
        }
        return null;
    }

    /**
     * Stacks are considered equivelant if their NBT, Item, and Meta are the same
     *
     * @param a One itemstack
     * @param b another itemstack
     * @return true if the stacks are equivelant
     */
    private boolean stacksEquivelent(ItemStack a, ItemStack b){
        if(!a.getItem().equals(b.getItem())) return false;
        if(a.getItemDamage() != b.getItemDamage()) return false;
        if(a.hasTagCompound() != b.hasTagCompound()) return false;
        if(a.hasTagCompound()){
            if (a.getTagCompound().equals(b.getTagCompound())) return false;
        }
        return true;
    }
}
