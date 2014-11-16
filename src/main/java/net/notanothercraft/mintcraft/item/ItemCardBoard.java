package net.notanothercraft.mintcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.notanothercraft.mintcraft.MintCraftMod;

/**
 * Created by Azreth on 11/15/14.
 */
public class ItemCardBoard extends Item {
    public ItemCardBoard(){
        this.setUnlocalizedName("cardboard");
        this.setTextureName("mintcraft:cardboard");
        this.setMaxStackSize(32);
    }

    public void registerRecipies(){
        GameRegistry.addShapedRecipe(new ItemStack(this, 4, 0),
                "p p",
                "pgp",
                "p p",
                'p', new ItemStack(Items.paper, 1, 0),
                'g', new ItemStack(MintCraftMod.instance.itemGlue, 1, 0));
    }
}

