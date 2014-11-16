package net.notanothercraft.mintcraft.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Azreth on 11/15/14.
 *An item for Hinges and Locks
  */
public class ItemPin extends Item {
    public ItemPin(){
        this.setUnlocalizedName("pin");
        this.setTextureName("mintcraft:pin");
        this.setMaxStackSize(16);

    }

    public void registerRecipies(){
        GameRegistry.addShapelessRecipe(new ItemStack(this, 1, 0),
                new ItemStack(Items.iron_ingot, 1, 0),
                new ItemStack(Items.iron_ingot, 1, 0));
    }

}
