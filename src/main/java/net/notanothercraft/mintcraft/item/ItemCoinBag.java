package net.notanothercraft.mintcraft.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.notanothercraft.mintcraft.MintCraftMod;
import net.notanothercraft.mintcraft.inventory.BagContents;

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
    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if(player.isSneaking()) return false;
        if(!stack.hasTagCompound()) stack.setTagCompound((new BagContents(8)).saveToNBTCompound());
        BagContents bagContents = BagContents.loadFromNBTCompound(stack.getTagCompound());
        player.openGui(MintCraftMod.instance, 0, world, x, y, z);
        return true;
    }
}
