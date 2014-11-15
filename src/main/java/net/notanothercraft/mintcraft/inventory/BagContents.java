package net.notanothercraft.mintcraft.inventory;

import com.google.common.collect.Maps;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

import java.util.HashMap;

/**
 * Created by KJ4IPS on 11/14/2014.
 *
 */
public class BagContents{

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

    public void setInventorySlotContents(int slot, ItemStack stack){
        items[slot] = stack;
    }

    public ItemStack getStackInSlot(int slot) {
        return items[slot];
    }

    public ItemStack getItemStackInSlotOnClosing(int slot){
        ItemStack stack = getStackInSlot(slot);
        if(stack != null) {
            setInventorySlotContents(slot, null);
        }
        return stack;
    }

    public Integer getSizeInventory() {
        return inventorySize;
    }
}
