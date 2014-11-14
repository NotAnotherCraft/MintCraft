package net.notanothercraft.mintcraft;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.notanothercraft.mintcraft.item.ItemCoin;

@Mod(modid = "MintCraft")
public class MintCraftMod {

    @Mod.Instance
    MintCraftMod instance;

    public CreativeTabs mintCreativeTab;
    public ItemCoin itemCoin;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent e){
        mintCreativeTab = new MintCreativeTab();
        itemCoin = new ItemCoin();
        GameRegistry.registerItem(itemCoin,"coin");
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent e){

    }

}
