package net.notanothercraft.mintcraft.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants;
import net.notanothercraft.mintcraft.item.ItemCoin;

/**
 * Created by KJ4IPS on 11/16/2014.
 * The TE for the cardboard box
 */
public class TileCardboardBox extends TileEntity implements ISidedInventory, IInventory {

    private static final int INVENTORY_SIZE = 10;
    private ItemStack[] inventory;
    private Object /*ILockset*/ lockset;

    public TileCardboardBox(){
        inventory = new ItemStack[INVENTORY_SIZE];
        lockset = null;
    }

    @Override
    public boolean canUpdate() { //Does not tick
        return false;
    }

    @Override
    public int getSizeInventory() {
        return inventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory[slot];
    }

    /**
     * When some containers are closed they call this on each slot, then drop whatever it returns as an EntityItem -
     * like when you close a workbench GUI.
     *
     * @param slot the slot to operate on
     */
    @Override
    public ItemStack getStackInSlotOnClosing(int slot) {
        return null; //do nothing!
    }

    /**
     * Removes from an inventory slot (first arg) up to a specified number (second arg) of items and returns them in a
     * new stack.
     *
     * @param slot the slot to decriment
     * @param amount the number of items to remove
     */
    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack newStack, inventoryStack;
        inventoryStack = getStackInSlot(slot).copy();
        newStack = null;
        if(inventoryStack != null){
            newStack = inventoryStack.splitStack(amount);
            if(inventoryStack.stackSize <= amount) inventoryStack = null;
        }
        setInventorySlotContents(slot,inventoryStack);
        return newStack;
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     *
     * @param slot the slot to modify
     * @param stack the stack to place in said slot
     */
    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        inventory[slot] = stack;
    }

    /**
     * Returns the name of the inventory
     */
    @Override
    public String getInventoryName() {
        return "net.notanothercraft.mintcraft.cardboardbox";
    }

    /**
     * Returns if the inventory is named
     */
    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    /**
     * Returns the maximum stack size for a inventory slot.
     */
    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    /**
     * Do not make give this method the name canInteractWith because it clashes with Container
     *
     * @param player the player to check
     */
    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return false;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     *
     * @param slot the slot to check
     * @param stack the stack to evaluate
     */
    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return stack.getItem() instanceof ItemCoin;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        NBTTagList inventoryNBT = tag.getTagList("items", Constants.NBT.TAG_COMPOUND);
        for(byte i = 0; i < inventoryNBT.tagCount(); i++){
            NBTTagCompound itemNBT = inventoryNBT.getCompoundTagAt(i);
            byte slot = itemNBT.getByte("slot");
            if(slot >= 0 && slot < inventory.length){
                inventory[slot] = ItemStack.loadItemStackFromNBT(itemNBT);
            }
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        NBTTagList inventoryNBT = new NBTTagList();
        for(byte i = 0; i < inventory.length; i++){
            ItemStack stack = inventory[i];
            if(stack != null){
                NBTTagCompound itemNBT = new NBTTagCompound();
                itemNBT.setByte("slot", i);
                stack.writeToNBT(itemNBT);
                inventoryNBT.appendTag(itemNBT);
            }
        }
        tag.setTag("items", inventoryNBT);
    }

    /*
     * Access Rules:
     * Top: insert coins into all slots
     *
     */

    /**
     * Returns an array containing the indices of the slots that can be accessed by automation on the given side of this
     * block.
     *
     * @param side the side being checked
     */
    @Override
    public int[] getAccessibleSlotsFromSide(int side) {
        switch(side){
            case 1: //top
                return new int[] {0,1,2,3,4,5,6,7,8,9};
            default:
                return new int[0];
        }
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side. Args: Slot, item,
     * side
     *
     * @param slot the slot that is being accessed
     * @param stack the itemstack being inserted
     * @param side the side that the inventory is being accessed from
     */
    @Override
    public boolean canInsertItem(int slot, ItemStack stack, int side) {
        return side == 1 && isItemValidForSlot(slot,stack);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side. Args: Slot, item,
     * side
     *
     * @param slot slot to operate on
     * @param stack the itemstack being extracted
     * @param side the side that the extraction is happening from
     */
    @Override
    public boolean canExtractItem(int slot, ItemStack stack, int side) {
        return false;
    }


}
