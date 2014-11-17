package net.notanothercraft.mintcraft.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.notanothercraft.mintcraft.inventory.container.ContainerCardboardBox;
import net.notanothercraft.mintcraft.tileentity.TileCardboardBox;
import org.lwjgl.opengl.GL11;

/**
 * Created by KJ4IPS on 11/16/2014.
 */
public class GUICardboardBox extends GuiContainer {


    public GUICardboardBox(InventoryPlayer inventoryPlayer, TileCardboardBox tile) {
        super(new ContainerCardboardBox(inventoryPlayer,tile));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
        ResourceLocation texture = new ResourceLocation("mintcraft:guis/cardboardboxgui.png");
        mc.renderEngine.getTexture(texture);
        GL11.glColor4f(1F, 1F, 1F, 1F);
        mc.renderEngine.bindTexture(texture);
        int x = (width - xSize) >> 1 ;
        int y = (height - ySize) >> 1 ;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}
