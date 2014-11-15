package net.notanothercraft.mintcraft.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.notanothercraft.mintcraft.MintCreativeTab;


/**
 * Created by Azreth on 11/14/14.
 * Blocks For Bragging
 */
public class BlockCoinPile extends Block {
    public BlockCoinPile(){
        super(Material.iron);
        this.setBlockTextureName("mintcraft:coinblock");
    }// TODO finish metadata for the coin blocks
}
