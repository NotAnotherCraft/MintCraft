package net.notanothercraft.mintcraft.inventory.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.notanothercraft.mintcraft.inventory.slot.SlotCoin;
import net.notanothercraft.mintcraft.tileentity.TileCardboardBox;
import net.notanothercraft.mintcraft.util.InventoryUtil;

/**
 * Created by KJ4IPS on 11/16/2014.
 *
 */
public class ContainerCardboardBox extends Container {

    protected TileCardboardBox tile;
    protected InventoryPlayer playerInv;

    private static final int[][] slotPositions = new int[][]{
            {45,26},
            {63,26},
            {81,26},
            {99,26},
            {117,26},
            {45,44},
            {63,44},
            {81,44},
            {99,44},
            {117,44}
    };

    public ContainerCardboardBox(InventoryPlayer playerInv, TileCardboardBox tile){
        this.playerInv = playerInv;
        this.tile = tile;
        bindBoxSlots();
        InventoryUtil.bindPlayerInv(this.inventorySlots, this.inventoryItemStacks,playerInv, 9,81,4);
    }

    private void bindBoxSlots(){
        for(int i = 0; i < slotPositions.length; i++){
            addSlotToContainer(new SlotCoin(tile,i,slotPositions[i][0],slotPositions[i][1]));
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        return InventoryUtil.handleShiftClick(slot, player, inventorySlots);
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        //return tile.isUseableByPlayer(player);
        return true;
    }
}
