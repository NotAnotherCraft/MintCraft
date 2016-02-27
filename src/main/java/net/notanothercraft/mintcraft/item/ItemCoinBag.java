package net.notanothercraft.mintcraft.item;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.notanothercraft.mintcraft.MintCraftMod;
import net.notanothercraft.mintcraft.util.GuiTypes;
import net.notanothercraft.mintcraft.inventory.BagContents;

import java.util.List;

/**
 * Created by Azreth on 11/14/14.
 * A bag for your coin
 */
public class ItemCoinBag extends Item implements IValuable{

    private static final int SLOTS = 8;

    public ItemCoinBag(){
        super();
        this.setUnlocalizedName("coinbag");
        this.setTextureName("mintcraft:coinbag");
        this.setMaxStackSize(1);
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
                player.inventory.markDirty();
            }
        }
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
        onItemRightClick(stack,world,player);
        return true;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if(player.isSneaking()) return stack;
        if (!stack.hasTagCompound() || !stack.getTagCompound().hasKey("inventorySize", Constants.NBT.TAG_INT)){ //both sides for initial init
            player.getCurrentEquippedItem().setTagCompound((new BagContents(8)).saveToNBTCompound());
            player.inventory.markDirty();
        }
        if(!world.isRemote) { //Start inv from server
            player.openGui(MintCraftMod.instance, GuiTypes.COIN_BAG, world, 0, 0, 0);
        }
        return stack;
    }

    @Override
    public Integer getWorth(ItemStack is) {
        if(is.hasTagCompound() && is.getTagCompound().hasKey("items",Constants.NBT.TAG_LIST)){
            Integer value = 0;
            NBTTagList itemsnbt = (NBTTagList) is.getTagCompound().getTag("items");
            for(int i = 0; i < itemsnbt.tagCount() ; i++){
                ItemStack stack = ItemStack.loadItemStackFromNBT(itemsnbt.getCompoundTagAt(i));
                if(stack.getItem() instanceof IValuable){
                    value += ((IValuable) stack.getItem()).getWorth(stack) * stack.stackSize;
                }
            }
            return value;
        }
        return 0;
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List items, boolean flag) {
        items.add(String.format("Contains %dc",getWorth(stack)));
    }
}
