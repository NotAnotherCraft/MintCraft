package net.notanothercraft.mintcraft.item;

/**
 * Created by KJ4IPS on 11/14/2014.
 */
public class CoinType {
    private Integer worth;
    private String typename;
    private String texture;

    public CoinType(String typename, Integer worth, String texture) {
        this.typename = typename;
        this.worth = worth;
        this.texture = texture;
    }

    public Integer getWorth() {
        return worth;
    }

    public String getTypename() {
        return typename;
    }

    public String getTexture() {
        return texture;
    }
}
