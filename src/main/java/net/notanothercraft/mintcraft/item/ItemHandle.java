package net.notanothercraft.mintcraft.item;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.notanothercraft.mintcraft.MintCraftMod;

/**
 * Created by Azreth on 11/16/14.
 */
public class ItemHandle extends Item {
    public ItemHandle(){
        this.setUnlocalizedName("handle");
        this.setTextureName("mintcraft:handle");
    }

    public void registerRecipies(){
        GameRegistry.addShapelessRecipe(new ItemStack(this, 1, 0),
         new ItemStack(Blocks.lever),
         new ItemStack(MintCraftMod.instance.itemPin));
    }
}
