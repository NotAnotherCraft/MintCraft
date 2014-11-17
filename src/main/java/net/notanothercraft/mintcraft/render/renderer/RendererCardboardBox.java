package net.notanothercraft.mintcraft.render.renderer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.notanothercraft.mintcraft.render.model.ModelCardboardBox;
import org.lwjgl.opengl.GL11;

/**
 * Created by KJ4IPS on 11/16/2014.
 */
public class RendererCardboardBox extends TileEntitySpecialRenderer {

    private final ModelBase model = new ModelCardboardBox();

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float) (x + 0.5F), (float) (y + 1.5F), (float) (z + 0.5F));

        ResourceLocation texture = new ResourceLocation("mintcraft:textures/blocks/cardboardbox_test.png");
        Minecraft.getMinecraft().renderEngine.bindTexture(texture);

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glRotatef(180F, 0F, 0F, 1F);
        GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_SRC_COLOR);
        GL11.glEnable(GL11.GL_BLEND);
        this.model.render(null, 0F, 0F, 0F, 0F, 0F, 0.0625F);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glPopMatrix();
    }
}
