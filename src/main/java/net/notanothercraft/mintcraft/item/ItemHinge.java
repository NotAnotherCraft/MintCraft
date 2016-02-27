package net.notanothercraft.mintcraft.item;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.notanothercraft.mintcraft.MintCraftMod;

/**
 * Created by Azreth on 11/15/14.
 * part for lockboxes and safes
 */
public class ItemHinge extends Item {
    public ItemHinge(){
        this.setUnlocalizedName("hinge");
        this.setTextureName("mintcraft:hinge");
        this.setMaxStackSize(16);
    }

    public void registerRecipies(){
        GameRegistry.addShapedRecipe(new ItemStack(this, 1, 0),
                "pi",
                "i ",
                'p', new ItemStack(MintCraftMod.instance.itemPin, 1, 0),
                'i', new ItemStack(Items.iron_ingot, 1, 0));
    }
}
