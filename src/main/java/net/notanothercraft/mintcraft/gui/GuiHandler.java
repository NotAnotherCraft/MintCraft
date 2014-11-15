package net.notanothercraft.mintcraft.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.notanothercraft.mintcraft.MintCraftMod;
import net.notanothercraft.mintcraft.inventory.BagContainer;
import net.notanothercraft.mintcraft.inventory.BagContents;

/**
 * Created by KJ4IPS on 11/15/2014.
 */
public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == 0) { //coin bag
            ItemStack stack = player.getCurrentEquippedItem();
            BagContents contents = BagContents.loadFromNBTCompound(stack.getTagCompound());
            return new BagContainer(player.inventory, contents, stack);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if(ID == 0) { //coin bag
            ItemStack stack = player.getCurrentEquippedItem();
            BagContents contents = BagContents.loadFromNBTCompound(stack.getTagCompound());
            return new CoinBagGUI(player.inventory, contents, stack);
        }
        return null;
    }
}
