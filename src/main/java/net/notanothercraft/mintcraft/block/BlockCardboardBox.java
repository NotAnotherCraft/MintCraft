package net.notanothercraft.mintcraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.notanothercraft.mintcraft.MintCraftMod;
import net.notanothercraft.mintcraft.util.GuiTypes;
import net.notanothercraft.mintcraft.tileentity.TileCardboardBox;

/**
 * Created by Azreth on 11/15/14.
 */
public class BlockCardboardBox extends BlockContainer {

    private IIcon[] textures;
    private static final String[] textureNames = new String[]{"bottem", "front", "top", "leftrigh"};

    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        textures = new IIcon[4];
        for(int i =0; i<textureNames.length;i++){
            textures[i] = iconRegister.registerIcon("mintcraft:cardboardbox_"+textureNames[i]);
        }

    }

    @Override
    public IIcon getIcon(int side, int meta) {
        switch(side){
            case 0:
                return textures[0];
            case 1:
                return textures[2];
            case 2:
            case 3:
                return textures[1];
            default:
                return textures[3];
        }
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
        return new TileCardboardBox();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int metadata, float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if(tileEntity == null || player.isSneaking()) return false;
        if(!world.isRemote) player.openGui(MintCraftMod.instance, GuiTypes.CARDBOARD_BOX, world, x, y, z);
        return true;
    }

    public BlockCardboardBox(){
        super(Material.carpet);
        this.setBlockName("cardboardbox");


    }

    public void registerRecipies(){
        GameRegistry.addShapedRecipe(new ItemStack(Item.getItemFromBlock(this), 1, 0),
                "gcg",
                "cbc",
                "gcg",
                'g', new ItemStack(MintCraftMod.instance.itemGlue, 1, 0),
                'c', new ItemStack(MintCraftMod.instance.itemCardBoard, 1, 0),
                'b', new ItemStack(MintCraftMod.instance.itemCoinBag, 1, 0));
    }
}

