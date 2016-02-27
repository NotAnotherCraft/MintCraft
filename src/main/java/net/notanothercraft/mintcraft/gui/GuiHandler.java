package net.notanothercraft.mintcraft.gui;

import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.notanothercraft.mintcraft.inventory.container.ContainerCardboardBox;
import net.notanothercraft.mintcraft.inventory.container.ContainerCoinBag;
import net.notanothercraft.mintcraft.inventory.BagContents;
import net.notanothercraft.mintcraft.tileentity.TileCardboardBox;
import net.notanothercraft.mintcraft.util.GuiTypes;

/**
 * Created by KJ4IPS on 11/15/2014.
 * A gui packet handler
 */
public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID) {
            case GuiTypes.COIN_BAG:
                ItemStack stack = player.getCurrentEquippedItem();
                BagContents contents = BagContents.loadFromNBTCompound(stack.getTagCompound());
                return new ContainerCoinBag(player.inventory, contents, stack);
            case GuiTypes.CARDBOARD_BOX:
                return new ContainerCardboardBox(player.inventory, (TileCardboardBox) world.getTileEntity(x,y,z));
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        switch(ID){
            case GuiTypes.COIN_BAG:
                ItemStack stack = player.getCurrentEquippedItem();
                BagContents contents = BagContents.loadFromNBTCompound(stack.getTagCompound());
                return new CoinBagGUI(player.inventory, contents, stack);
            case GuiTypes.CARDBOARD_BOX:
                return new GUICardboardBox(player.inventory, (TileCardboardBox) world.getTileEntity(x,y,z));
            default:
                return null;
        }
    }
}
