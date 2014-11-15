package net.notanothercraft.mintcraft.item;

import com.google.common.collect.Maps;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.HashMap;
import java.util.List;

/**
 * Created by KJ4IPS on 11/14/2014.
 * A simple coin
 */
public class ItemCoin extends ItemCurrency{

    private HashMap<Integer,CoinType> coinTypes = Maps.newHashMap();

    public ItemCoin(){
        super();
        this.setUnlocalizedName("coin");
        this.setHasSubtypes(true);
        registerCoins();
    }

    private void registerCoins() {
        coinTypes.put(0,new CoinType("copper", 1, "mintcraft:coin"));
        coinTypes.put(1,new CoinType("iron", 1, "mintcraft:coiniron"));
    }
    
    @Override
    public Integer getWorth(ItemStack is){
        return coinTypes.get(is.getItemDamage()).getWorth();
    }

    @Override
    public String getUnlocalizedName(ItemStack is) {
        return "coin." + coinTypes.get(is.getItemDamage()).getTypename();
    }



    @Override
    public void getSubItems(Item coin, CreativeTabs tab, List types) {
        for(Integer key : coinTypes.keySet()){
            types.add(new ItemStack(coin,1, key));
        }
    }
}