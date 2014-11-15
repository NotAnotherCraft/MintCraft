package net.notanothercraft.mintcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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

    public void registerRecipies(){
        GameRegistry.addShapedRecipe(new ItemStack(this, 1, 0),
                "sls",
                "lcl",
                "lll",
                's', new ItemStack(Items.string, 1, 0),
                'l', new ItemStack(Items.leather, 1, 0),
                'c', new ItemStack(Item.getItemFromBlock(Blocks.chest), 1, 0));
    }


    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        if(!world.isRemote) { //NBT manupulation on the server!
            if (!stack.hasTagCompound() || !stack.getTagCompound().hasKey("inventorySize", Constants.NBT.TAG_INT)){
                player.getCurrentEquippedItem().setTagCompound((new BagContents(8)).saveToNBTCompound());
                MintCraftMod.instance.getLogger().info("Initializing empty bag for " + player.getDisplayName());
                player.inventory.markDirty();
            }
        }
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        if(player.isSneaking()) return false;
        if(!world.isRemote) { //NBT manupulation on the server!
            if (!stack.hasTagCompound() || !stack.getTagCompound().hasKey("inventorySize", Constants.NBT.TAG_INT)){
                player.getCurrentEquippedItem().setTagCompound((new BagContents(8)).saveToNBTCompound());
                MintCraftMod.instance.getLogger().info("Initializing empty bag for " + player.getDisplayName());
                player.inventory.markDirty();
            }
            player.openGui(MintCraftMod.instance, 0, world, x, y, z);
        }
        return true;
    }



}
