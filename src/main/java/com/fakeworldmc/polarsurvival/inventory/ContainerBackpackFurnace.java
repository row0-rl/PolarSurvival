package com.fakeworldmc.polarsurvival.inventory;

import com.fakeworldmc.polarsurvival.item.ItemBackpackFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class ContainerBackpackFurnace extends Container {

    public SlotItemHandler fuelSlot;

    public ContainerBackpackFurnace(InventoryPlayer playerInventory, EntityPlayer player) {
        super();
        addSlots(playerInventory, player);
    }

    private void addSlots(InventoryPlayer playerInventory, EntityPlayer player) {

        fuelSlot = new SlotItemHandler(new ItemStackHandler(1),
                0, 80, 34) {

            {
                NBTTagCompound nbtTagCompound = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getTagCompound();
                if (nbtTagCompound != null) {
                    this.putStack(new ItemStack(nbtTagCompound));
                }
            }

            @Override
            public boolean isItemValid(ItemStack stack) {
                return stack != null && super.isItemValid(stack) && TileEntityFurnace.isItemFuel(stack);
            }
        };

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

    /**
     * This method doesn't actually work, whether the player has a
     * backpack furnace is checked when openGui() is called.
     */
    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof ItemBackpackFurnace;
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index) {

        final int
                FUEL = 0,
                INV_START = 1,
                INV_END = 27,
                TOOL_START = 28,
                TOOL_END = 36;

        Slot slot = inventorySlots.get(index);

        if (slot == null || !slot.getHasStack()) {
            return ItemStack.EMPTY;
        }

        ItemStack newStack = slot.getStack(), oldStack = newStack.copy();

        boolean isMerged = false;

        if (index == FUEL) {
            isMerged = mergeItemStack(newStack, INV_START, INV_END+1, true);
        }
        else if (index <= INV_END) {
            isMerged = !fuelSlot.getHasStack() && mergeItemStack(newStack, FUEL, FUEL+1, false)
                    || mergeItemStack(newStack, TOOL_START, TOOL_END+1, false);
        }
        else if (index <= TOOL_END) {
            isMerged = !fuelSlot.getHasStack() && mergeItemStack(newStack, FUEL, FUEL+1, false)
                    || mergeItemStack(newStack, INV_START, INV_END+1, false);
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
        slot.onTake(player, newStack);

        return oldStack;
    }

    @Override
    public void onContainerClosed(EntityPlayer player) {

        super.onContainerClosed(player);

        ItemStack stack = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        if (!(stack.getItem() instanceof ItemBackpackFurnace)) {
            return;
        }

        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        stack.setTagCompound(fuelSlot.getStack().writeToNBT(nbtTagCompound));
    }

    @Override
    public void detectAndSendChanges() {

        super.detectAndSendChanges();

    }

}
