package net.notanothercraft.mintcraft.proxy;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.notanothercraft.mintcraft.render.renderer.RendererCardboardBox;
import net.notanothercraft.mintcraft.tileentity.TileCardboardBox;

/**
 * Created by KJ4IPS on 11/16/2014.
 */
public class MintcraftClientProxy extends MintcraftCommonProxy {
    @Override
    public void registerTERender() {
        super.registerTERender();
        ClientRegistry.bindTileEntitySpecialRenderer(TileCardboardBox.class, new RendererCardboardBox());
    }
}
