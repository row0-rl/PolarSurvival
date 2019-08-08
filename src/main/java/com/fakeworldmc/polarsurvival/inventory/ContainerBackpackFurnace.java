package com.fakeworldmc.polarsurvival.inventory;

import com.fakeworldmc.polarsurvival.init.Items;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBackpackFurnace extends Container {

    private SlotItemHandler fuelSlot = new SlotItemHandler(new ItemStackHandler(1), 0, 80, 34) {
        @Override
        public boolean isItemValid(ItemStack stack) {
            return stack != null && TileEntityFurnace.isItemFuel(stack) && super.isItemValid(stack);
        }
    };

    public ContainerBackpackFurnace(InventoryPlayer playerInventory) {

        super();

        this.addSlotToContainer(fuelSlot);

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 66 + i * 18));
            }
        }

        for (int k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 124));
        }

    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return playerIn.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == Items.BACKPACK_FURNACE;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {

        Slot slot = inventorySlots.get(index);

        if (slot == null || !slot.getHasStack()) {
            return ItemStack.EMPTY;
        }

        ItemStack newStack = slot.getStack(), oldStack = newStack.copy();

        boolean isMerged = false;

        if (index == 0) {
            isMerged = mergeItemStack(newStack, 1, 37, true);
        }
        else if (index < 28) {
            isMerged = !fuelSlot.getHasStack() && mergeItemStack(newStack, 0, 0, false)
                    || mergeItemStack(newStack, 28, 37, false);
        }
        else if (index < 37) {
            isMerged = !fuelSlot.getHasStack() && mergeItemStack(newStack, 0, 0, false)
                    || mergeItemStack(newStack, 1, 28, false);
        }

        if (!isMerged) {
            return ItemStack.EMPTY;
        }

        if (newStack.getCount() == 0) {
            slot.putStack(ItemStack.EMPTY);
        }
        else {
            slot.onSlotChanged();
        }

        //slot.onPickupFromSlot(playerIn, newStack);

        return oldStack;
    }

}
