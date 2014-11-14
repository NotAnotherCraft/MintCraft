package net.notanothercraft.mintcraft.item;

/**
 * Created by KJ4IPS on 11/14/2014.
 * A simple coin
 */
public class ItemCoin extends ItemCurrency{
    public ItemCoin(){
        super();
        this.setWorth(1);
        this.setUnlocalizedName("coin");// Added By azreth
        this.setTextureName("coin");//TODO push Texture
    }
}
