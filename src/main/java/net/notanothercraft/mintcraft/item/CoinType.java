package net.notanothercraft.mintcraft.item;

import com.google.common.collect.Maps;

import java.util.HashMap;

/**
 * Created by KJ4IPS on 11/14/2014.
 */
public class CoinType {
    private Integer worth;
    private String typename;
    private String itemtexture;
    private String blocktexture;

    private static HashMap<Integer,CoinType> coinTypes = Maps.newHashMap();

    public CoinType(String typename, Integer worth, String itemtexture, String blocktexture) {
        this.typename = typename;
        this.worth = worth;
        this.itemtexture = itemtexture;
        this.blocktexture = blocktexture;
    }

    public static void registerCoins() {
        registerCoinType(0, new CoinType("copper", 5, "mintcraft:coin","mintcraft:coinblock"));
        registerCoinType(1, new CoinType("iron", 10, "mintcraft:coiniron","mintcraft:ironcoinblock"));
        registerCoinType(2, new CoinType("gold", 15, "mintcraft:goldcoin","mintcraft:goldcoinblock"));
        registerCoinType(3, new CoinType("diamond", 20, "mintcraft:diamondcoin","mintcraft:diamondcoinblock"));
        registerCoinType(4, new CoinType("emerald", 25, "mintcraft:emeraldcoin","mintcraft:emerldcoinblock"));
        registerCoinType(5, new CoinType("ender", 30, "mintcraft:endercoin","mintcraft:endercoinblock"));
    }

    public Integer getWorth() {
        return worth;
    }

    public String getTypename() {
        return typename;
    }

    public String getItemtexture() {
        return itemtexture;
    }

    public static HashMap<Integer, CoinType> getCoinTypes() {
        return coinTypes;
    }

    public static CoinType getCoinType(Integer i){
        return coinTypes.get(i);
    }

    public static void registerCoinType(Integer i, CoinType c){
        coinTypes.put(i,c);
    }

    public String getBlocktexture() {
        return blocktexture;
    }
}
