package net.notanothercraft.mintcraft;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * Created by KJ4IPS on 11/14/2014.
 * A snazzy creative tab
 */
public class MintCreativeTab extends CreativeTabs{
    public MintCreativeTab() {
        super("mintCraft");
    }

    @Override
    public Item getTabIconItem() {
        return Items.gold_ingot;
    }
}
