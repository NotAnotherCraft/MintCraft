package net.notanothercraft.mintcraft.block.itemblock;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.notanothercraft.mintcraft.item.CoinType;

/**
 * Created by KJ4IPS on 11/15/2014.
 */
public class ItemBlockCoinPile extends ItemBlock {

    public ItemBlockCoinPile(Block block) {
        super(block);
        this.setHasSubtypes(true);
    }

    @Override
    public IIcon getIconFromDamage(int dmg) {
        return this.field_150939_a.getIcon(2, dmg);
    }

    @Override
    public int getMetadata(int meta) {
        return meta;
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return "coinpile." + CoinType.getCoinType(is.getItemDamage()).getTypename();
    }
}
