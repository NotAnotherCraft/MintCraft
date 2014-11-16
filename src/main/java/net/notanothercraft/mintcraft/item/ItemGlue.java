package net.notanothercraft.mintcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Azreth on 11/15/14.
 * A crafting componet for Cardboard
 */
public class ItemGlue extends Item {
    public ItemGlue(){
        this.setUnlocalizedName("glue");
        this.setTextureName("mintcraft:glue");
        this.setMaxStackSize(16);

    }

    public void registerRecipies(){
        GameRegistry.addShapelessRecipe(new ItemStack(this, 1, 0),
                 new ItemStack(Items.glass_bottle, 1, 0),
                 new ItemStack(Items.slime_ball,1, 0));
    }
}
