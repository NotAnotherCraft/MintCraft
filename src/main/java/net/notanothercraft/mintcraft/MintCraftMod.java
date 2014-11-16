package net.notanothercraft.mintcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.notanothercraft.mintcraft.block.BlockCardboardBox;
import net.notanothercraft.mintcraft.block.BlockCoinPile;
import net.notanothercraft.mintcraft.block.itemblock.ItemBlockCoinPile;
import net.notanothercraft.mintcraft.gui.GuiHandler;
import net.notanothercraft.mintcraft.item.*;
import org.apache.logging.log4j.Logger;

@Mod(modid = "mintCraft", name = "MintCraft", version = "0.0.1")
public class MintCraftMod {

    @Mod.Instance
    public static MintCraftMod instance;

    private Logger logger;

    public CreativeTabs mintCreativeTab;
    public ItemCoin itemCoin;
    public ItemCoinBag itemCoinBag;
    public ItemGlue itemGlue;
    public ItemCardBoard itemCardBoard;
    public BlockCoinPile blockCoinPile;
    public BlockCardboardBox blockCardboardBox;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent e){

        logger = e.getModLog();

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());

        CoinType.registerCoins();
        mintCreativeTab = new MintCreativeTab();

        itemCoin = new ItemCoin();
        itemCoin.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemCoin, "coin");

        itemCoinBag = new ItemCoinBag();
        itemCoinBag.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemCoinBag, "coinbag");
        itemCoinBag.registerRecipies();

        itemGlue = new ItemGlue();
        itemGlue.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemGlue, "glue");
        itemGlue.registerRecipies();

        itemCardBoard = new ItemCardBoard();
        itemCardBoard.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemCardBoard, "cardboard");
        itemCardBoard.registerRecipies();

        blockCardboardBox = new BlockCardboardBox();
        blockCardboardBox.setCreativeTab(mintCreativeTab);
        GameRegistry.registerBlock(blockCardboardBox,"cardboardbox");
        blockCardboardBox.registerRecipies();

        blockCoinPile = new BlockCoinPile();
        blockCoinPile.setCreativeTab(mintCreativeTab);
        GameRegistry.registerBlock(blockCoinPile,ItemBlockCoinPile.class, "coinpile");
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent e){

    }

    public Logger getLogger() {
        return logger;
    }
}
