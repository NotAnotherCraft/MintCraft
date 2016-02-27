package net.notanothercraft.mintcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
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
import net.notanothercraft.mintcraft.proxy.MintcraftCommonProxy;
import net.notanothercraft.mintcraft.tileentity.TileCardboardBox;
import net.notanothercraft.mintcraft.util.CoinType;
import org.apache.logging.log4j.Logger;

@Mod(modid = "mintCraft", name = "MintCraft", version = "0.0.1")
public class MintCraftMod {

    @Mod.Instance
    public static MintCraftMod instance;

    private Logger logger;

    @SidedProxy(clientSide = "net.notanothercraft.mintcraft.proxy.MintcraftClientProxy", serverSide = "net.notanothercraft.mintcraft.proxy.MintcraftCommonProxy")
    public static MintcraftCommonProxy proxy;

    public CreativeTabs mintCreativeTab;
    public ItemCoin itemCoin;
    public ItemCoinBag itemCoinBag;
    public ItemGlue itemGlue;
    public ItemPin itemPin;
    public ItemHinge itemHinge;
    public ItemHandle itemHandle;
    public ItemKey itemKey;
    public ItemCardBoard itemCardBoard;
    public ItemSafewall itemSafewall;
    public BlockCoinPile blockCoinPile;
    public BlockCardboardBox blockCardboardBox;



    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent e){

        logger = e.getModLog();

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
        proxy.registerTERender();

        CoinType.registerCoins();
        mintCreativeTab = new MintCreativeTab();

        itemCoin = new ItemCoin();
        itemCoin.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemCoin, "coin");

        itemCoinBag = new ItemCoinBag();
        itemCoinBag.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemCoinBag, "coinbag");

        itemGlue = new ItemGlue();
        itemGlue.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemGlue, "glue");

        itemCardBoard = new ItemCardBoard();
        itemCardBoard.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemCardBoard, "cardboard");

        itemPin = new ItemPin();
        itemPin.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemPin, "pin");

        itemHinge = new ItemHinge();
        itemHinge.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemHinge, "hinge");

        itemHandle = new ItemHandle();
        itemHandle.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemHandle, "handle");

        itemSafewall = new ItemSafewall();
        itemSafewall.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemSafewall, "safewall");

        blockCardboardBox = new BlockCardboardBox();
        blockCardboardBox.setCreativeTab(mintCreativeTab);
        GameRegistry.registerBlock(blockCardboardBox,"cardboardbox");
        GameRegistry.registerTileEntity(TileCardboardBox.class, "cardboardbox");

        blockCoinPile = new BlockCoinPile();
        blockCoinPile.setCreativeTab(mintCreativeTab);
        GameRegistry.registerBlock(blockCoinPile,ItemBlockCoinPile.class, "coinpile");

        itemKey = new ItemKey();
        itemKey.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemKey,"key");

        itemCoinBag.registerRecipies();
        itemGlue.registerRecipies();
        itemCardBoard.registerRecipies();
        itemPin.registerRecipies();
        itemHinge.registerRecipies();
        itemHandle.registerRecipies();
        itemSafewall.registerRecipes();
        blockCardboardBox.registerRecipies();
        itemKey.registerRecipies();
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent e){

    }

    public Logger getLogger() {
        return logger;
    }
}
