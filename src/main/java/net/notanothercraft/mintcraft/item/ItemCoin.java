package net.notanothercraft.mintcraft.item;

/**
 * Created by KJ4IPS on 11/14/2014.
 * A simple coin
 */
public class ItemCoin extends ItemCurrency{
    public ItemCoin(){
        super();
        this.setWorth(1);
        this.setUnlocalizedName("Coin");// Added By azreth
        this.setTextureName("Coin");//TODO push Texture
    }
}