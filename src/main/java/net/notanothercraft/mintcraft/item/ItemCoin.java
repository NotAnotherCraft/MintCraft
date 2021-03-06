package net.notanothercraft.mintcraft.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.notanothercraft.mintcraft.util.CoinType;

import java.util.List;

/**
 * Created by KJ4IPS on 11/14/2014.
 * A simple coin
 */
public class ItemCoin extends ItemCurrency{



    private IIcon[] textures;

    public ItemCoin(){
        super();
        this.setUnlocalizedName("coin");
        this.setHasSubtypes(true);
    }


    
    @Override
    public Integer getWorth(ItemStack is){
        return CoinType.getCoinType(is.getItemDamage()).getWorth();
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return "coin." + CoinType.getCoinType(is.getItemDamage()).getTypename();
    }

    @Override
    public void registerIcons(IIconRegister iconRegister) {
        textures = new IIcon[16];
        for(Integer key : CoinType.getCoinTypes().keySet()){
            textures[key] = iconRegister.registerIcon(CoinType.getCoinType(key).getItemtexture());
        }
    }

    @Override
    public IIcon getIconFromDamage(int dmg) {
        return textures[dmg];
    }

    @Override
    public void getSubItems(Item coin, CreativeTabs tab, List types) {
        for(Integer key : CoinType.getCoinTypes().keySet()){
            types.add(new ItemStack(coin,1, key));
        }
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List entries, boolean flag) {
        Item itemtype = itemStack.getItem();
        int amount = itemStack.stackSize;
        if(itemtype instanceof IValuable){
            IValuable valuedItem = (IValuable) itemtype;
            int valueeach = valuedItem.getWorth(itemStack);
            entries.add(
                    String.format("Worth %dc",valueeach * amount)
            );
            if(amount > 1){
                entries.add(
                        String.format("(%dc each)",valueeach)
                );
            }
        }
    }
}