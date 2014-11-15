package net.notanothercraft.mintcraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.notanothercraft.mintcraft.inventory.BagContainer;
import net.notanothercraft.mintcraft.inventory.BagContents;
import org.lwjgl.opengl.GL11;

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
        ResourceLocation texture = new ResourceLocation("mintcraft:guis/coinbaggui.png");
        mc.renderEngine.getTexture(texture);
        GL11.glColor4f(1F, 1F, 1F, 1F);
        mc.renderEngine.bindTexture(texture);
        int x = (width - xSize) >> 1 ;
        int y = (height - ySize) >> 1 ;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
