package net.notanothercraft.mintcraft.item;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.notanothercraft.mintcraft.MintCraftMod;

import java.util.List;
import java.util.UUID;

/**
 * Created by KJ4IPS on 11/16/2014.
 */
public class ItemKey extends Item implements IUnlocker {

    public ItemKey() {
        super();
        this.setMaxStackSize(4);
        this.setUnlocalizedName("gkey");
        this.setTextureName("mintcraft:goldenkey");
    }

    public void registerRecipies(){
        GameRegistry.addShapedRecipe(new ItemStack(this),
                "i ",
                "p ",
                "pn",
                'i',new ItemStack(Items.gold_ingot),
                'p',new ItemStack(MintCraftMod.instance.itemPin),
                'n',new ItemStack(Items.gold_nugget));
    }

    @Override
    public String getSecret(ItemStack is) {
        return (is.hasTagCompound() && is.getTagCompound().hasKey("bitting")) ? is.getTagCompound().getString("bitting") : null;
    }

    @Override
    public void onCreated(ItemStack stack, World world, EntityPlayer player) {
        super.onCreated(stack, world, player);
        String secret = UUID.randomUUID().toString();
        NBTTagCompound tag = new NBTTagCompound();
        tag.setString("bitting", secret);
        stack.setTagCompound(tag);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List entries, boolean someBoolean) {
        super.addInformation(stack, player, entries, someBoolean);
        if(Minecraft.getMinecraft().gameSettings.advancedItemTooltips){
            entries.add("Bitting: " + (getSecret(stack) != null ? getSecret(stack) : "NONE"));
        }
    }
}
