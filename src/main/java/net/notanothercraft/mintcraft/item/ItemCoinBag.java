package net.notanothercraft.mintcraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;

/**
 * Created by Azreth on 11/14/14.
 * A bag for your coin
 */
public class ItemCoinBag extends Item {

    private static final int SLOTS = 8;

    public ItemCoinBag(){
        super();
        this.setUnlocalizedName("coinbag");
        this.setTextureName("mintcraft:coinbag");
    }

    @Override
    public void onCreated(ItemStack itemstack, World world, EntityPlayer player) {
        itemstack.stackTagCompound = new NBTTagCompound();
        //Inventory
        NBTTagList invslots = new NBTTagList();
        for(int i = 0; i < 8; i++){
            invslots.appendTag(new NBTTagCompound());
        }
    }
}
