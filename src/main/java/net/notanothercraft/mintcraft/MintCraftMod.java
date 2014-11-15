package net.notanothercraft.mintcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.notanothercraft.mintcraft.block.BlockCoinPile;
import net.notanothercraft.mintcraft.item.*;

import static net.minecraft.block.material.Material.air;

@Mod(modid = "mintCraft", name = "MintCraft", version = "0.0.1")
public class MintCraftMod {

    @Mod.Instance
    public static MintCraftMod instance;

    public CreativeTabs mintCreativeTab;
    public ItemCoin itemCoin;
    public ItemCoinBag itemCoinBag;
    public BlockCoinPile blockCoinPile;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent e){
        CoinType.registerCoins();
        mintCreativeTab = new MintCreativeTab();

        itemCoin = new ItemCoin();
        itemCoin.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemCoin, "coin");

        itemCoinBag = new ItemCoinBag();
        itemCoinBag.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemCoinBag, "coinbag");

        blockCoinPile = new BlockCoinPile();
        blockCoinPile.setCreativeTab(mintCreativeTab);
        GameRegistry.registerBlock(blockCoinPile, "coinpile");
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent e){

    }

}
