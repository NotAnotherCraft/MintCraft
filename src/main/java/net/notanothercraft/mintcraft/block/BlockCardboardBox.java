package net.notanothercraft.mintcraft.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.notanothercraft.mintcraft.MintCraftMod;

/**
 * Created by Azreth on 11/15/14.
 */
public class BlockCardboardBox extends Block {

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
                return textures[2];
            case 1:
                return textures[1];
            case 5:
                return textures[0];
            default:
                return textures[3];
        }
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

