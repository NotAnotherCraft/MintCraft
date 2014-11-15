package net.notanothercraft.mintcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.notanothercraft.mintcraft.MintCreativeTab;
import net.notanothercraft.mintcraft.item.CoinType;
import net.notanothercraft.mintcraft.item.IValuable;

import java.util.List;


/**
 * Created by Azreth on 11/14/14.
 * Blocks For Bragging
 */
public class BlockCoinPile extends Block implements IValuable {

    private IIcon[] textures;

    public BlockCoinPile(){
        super(Material.iron);
        this.setBlockTextureName("mintcraft:coinblock");
    }

    @Override
    public Integer getWorth(ItemStack is) {
        return null;

    }


    @Override
    public void registerBlockIcons(IIconRegister iconRegister) {
        textures = new IIcon[16];
        for(Integer key : CoinType.getCoinTypes().keySet()){
            textures[key] = iconRegister.registerIcon(CoinType.getCoinType(key).getBlocktexture());
        }
    }

    @Override
    public void getSubBlocks(Item coinblock, CreativeTabs tab, List types) {
        for (Integer key : CoinType.getCoinTypes().keySet()) {
            types.add(new ItemStack(coinblock, 1, key));
        }
    }
    @Override
    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        return textures[world.getBlockMetadata(x,y,z)];
    }

    }