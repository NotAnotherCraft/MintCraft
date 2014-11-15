package net.notanothercraft.mintcraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.notanothercraft.mintcraft.inventory.BagContainer;
import net.notanothercraft.mintcraft.inventory.BagContents;

/**
 * Created by KJ4IPS on 11/15/2014.
 */
public class CoinBagGUI extends GuiContainer {

    private BagContents contents;

    public CoinBagGUI(InventoryPlayer playerInv, BagContents contents, ItemStack slot) {
        super(new BagContainer(playerInv, contents, slot));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {

    }
}
