package net.notanothercraft.mintcraft.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.notanothercraft.mintcraft.MintCraftMod;

import java.util.Iterator;
import java.util.List;

/**
 * Created by KJ4IPS on 11/16/2014.
 * A class to hold various utilites for inventories
 */
public class InventoryUtil {

    private static Slot addSlotToContainer(Slot slot, List inventorySlots, List inventoryItemStacks){
        slot.slotNumber = inventorySlots.size();
        inventorySlots.add(slot);
        inventoryItemStacks.add((Object) null);
        return slot;
    }

    public static void bindPlayerInv(List inventorySlots, List inventoryItemStacks, InventoryPlayer playerInv,int drawX, int drawY, int hotbarOffset){
        //main three inventory rows
        for(int i = 0; i < 3 ; i++){
            for(int j = 0; j < 9; j++){
                addSlotToContainer(new Slot(playerInv, j+i*9+9, drawX+j*18, drawY+i*18),inventorySlots,inventoryItemStacks);
            }
        }
        //hotbar
        for(int i = 0; i < 9; i++){
            addSlotToContainer(new Slot(playerInv, i, drawX+i*18, drawY+3*18 + hotbarOffset), inventorySlots, inventoryItemStacks);
        }
    }


    public static ItemStack handleShiftClick(int slotIndex, EntityPlayer player, List<Slot> inventorySlots) {
        Slot clickedSlot = inventorySlots.get(slotIndex);
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
    private static boolean stacksEquivelent(ItemStack a, ItemStack b){
        if(!a.getItem().equals(b.getItem())) return false;
        if(a.getItemDamage() != b.getItemDamage()) return false;
        if(a.hasTagCompound() != b.hasTagCompound()) return false;
        if(a.hasTagCompound()){
            if (a.getTagCompound().equals(b.getTagCompound())) return false;
        }
        return true;
    }
}
