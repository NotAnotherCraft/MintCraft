package net.notanothercraft.mintcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.notanothercraft.mintcraft.item.ItemCoin;
import net.notanothercraft.mintcraft.item.ItemCoinIron;

@Mod(modid = "mintCraft", name = "MintCraft", version = "0.0.1")
public class MintCraftMod {

    @Mod.Instance
    MintCraftMod instance;

    public CreativeTabs mintCreativeTab;
    public ItemCoin itemCoin;
    public ItemCoinIron itemCoinIron;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent e){
        mintCreativeTab = new MintCreativeTab();
        itemCoin = new ItemCoin();
        itemCoinIron = new ItemCoinIron();
        itemCoin.setCreativeTab(mintCreativeTab);
        itemCoinIron.setCreativeTab(mintCreativeTab);
        GameRegistry.registerItem(itemCoin,"coin");
        GameRegistry.registerItem(itemCoinIron,"iron coin");
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent e){

    }

}
