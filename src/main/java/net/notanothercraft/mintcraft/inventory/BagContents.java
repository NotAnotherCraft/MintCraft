package net.notanothercraft.mintcraft.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import net.notanothercraft.mintcraft.MintCraftMod;

/**
 * Created by KJ4IPS on 11/14/2014.
 *
 */
public class BagContents implements IInventory{

    private int inventorySize;
    private ItemStack[] items;


    public BagContents(int size) {
        this.inventorySize = size;
        this.items = new ItemStack[size];
    }

    public static BagContents loadFromNBTCompound(NBTTagCompound tag){
        BagContents bagContents = new BagContents(tag.getInteger("inventorySize"));
        NBTTagList itemsList = tag.getTagList("items", Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i < itemsList.tagCount(); i++){
            NBTTagCompound theItemNBT = itemsList.getCompoundTagAt(i);
            ItemStack theItemStack= ItemStack.loadItemStackFromNBT(theItemNBT);
            bagContents.items[theItemNBT.getInteger("slot")] = theItemStack;
        }
        return bagContents;
    }

    public NBTTagCompound saveToNBTCompound(){
        NBTTagCompound tag = new NBTTagCompound();
        tag.setInteger("inventorySize", inventorySize);
        NBTTagList itemsList = new NBTTagList();
        for(int i = 0; i < this.inventorySize ; i++){
            if(items[i] != null) {
                ItemStack value = items[i];
                NBTTagCompound theItem = value.writeToNBT(new NBTTagCompound());
                theItem.setInteger("slot", i);
                itemsList.appendTag(theItem);
            }
        }
        tag.setTag("items", itemsList);
        return tag;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack){
        items[slot] = stack;
    }

    @Override
    public String getInventoryName() {
        return null;
    }

    @Override
    public boolean hasCustomInventoryName() {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void markDirty() {
        //Not needed for items!
    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
        return true;
    }

    @Override
    public void openInventory() {

    }

    @Override
    public void closeInventory() {

    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return stack.getItem().equals(MintCraftMod.instance.itemCoin);
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return items[slot];
    }

    @Override
    public ItemStack decrStackSize(int slot, int amount) {
        ItemStack stack = getStackInSlot(slot);
        if(stack != null){
            if(stack.stackSize <= amount) { //Take all of them
                setInventorySlotContents(slot,null);
            }else{ //some left overt
                stack = stack.splitStack(amount);
                if(stack.stackSize < 1){
                    setInventorySlotContents(slot, null);
                }
            }
        }
        return stack;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int slot){
        ItemStack stack = getStackInSlot(slot);
        if(stack != null) {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }

    @Override
    public int getSizeInventory() {
        return inventorySize;
    }
}
