package net.notanothercraft.mintcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.notanothercraft.mintcraft.item.*;

@Mod(modid = "mintCraft", name = "MintCraft", version = "0.0.1")
public class MintCraftMod {

    @Mod.Instance
    public MintCraftMod instance;

    public CreativeTabs mintCreativeTab;
    public ItemCoin itemCoin;
    public ItemCoinIron itemCoinIron;
    public ItemCoinGold itemCoinGold;
    public ItemCoinDiamond itemCoinDiamond;
    public ItemCoinEmerald itemCoinEmerald;
    public ItemCoinEnder itemCoinEnder;
    public ItemCoinBag itemCoinBag;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent e){
        mintCreativeTab = new MintCreativeTab();
        itemCoin = new ItemCoin();
        itemCoinIron = new ItemCoinIron();
        itemCoinGold = new ItemCoinGold();
        itemCoinDiamond = new ItemCoinDiamond();
        itemCoinEmerald = new ItemCoinEmerald();
        itemCoinEnder = new ItemCoinEnder();
        itemCoinBag = new ItemCoinBag();
        itemCoin.setCreativeTab(mintCreativeTab);
        itemCoinIron.setCreativeTab(mintCreativeTab);
        itemCoinGold.setCreativeTab(mintCreativeTab);
        itemCoinDiamond.setCreativeTab(mintCreativeTab);
        itemCoinEmerald.setCreativeTab(mintCreativeTab);
        itemCoinEnder.setCreativeTab(mintCreativeTab);
        itemCoinBag.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemCoin, "coin");
        GameRegistry.registerItem(itemCoinIron,"ironcoin");
        GameRegistry.registerItem(itemCoinGold,"goldcoin");
        GameRegistry.registerItem(itemCoinDiamond, "diamondcoin");
        GameRegistry.registerItem(itemCoinEmerald, "emeraldcoin");
        GameRegistry.registerItem(itemCoinEnder, "endercoin");
        GameRegistry.registerItem(itemCoinBag,"coinbag");
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent e){

    }

}
