package com.fakeworldmc.polarsurvival.item.crafting;


import com.fakeworldmc.polarsurvival.item.ItemWoolenSuit;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.NonNullList;

import java.util.HashMap;
import java.util.Map;

public abstract class RecipeWoolenSuit extends net.minecraftforge.registries.IForgeRegistryEntry.Impl<IRecipe> implements IRecipe {

    public static Map<Integer, Integer> colors = new HashMap<Integer, Integer>(){{
        put(0, 0xFFFFFF);
        put(1, 0xFFAA28);
        put(2, 0xDC64C8);
        put(3, 0x5AC8FF);
        put(4, 0xFFFF00);
        put(5, 0x96FF00);
        put(6, 0xFFAFE6);
        put(7, 0x787878);
        put(8, 0xC8C8C8);
        put(9, 0x28A0AF);
        put(10, 0xB464EB);
        put(11, 0x1464DC);
        put(12, 0x824600);
        put(13, 0x649600);
        put(14, 0xD22D2D);
        put(15, 0x232323);
    }};

    ItemStack getCraftingResult(InventoryCrafting inv, ItemWoolenSuit item) {

        int metadata = getWoolMetadata(inv);

        if (metadata == -1) { return ItemStack.EMPTY; }

        ItemStack result = new ItemStack(item);
        ((ItemWoolenSuit)result.getItem()).setColor(result, colors.get(metadata));
        return result;

    }

    @Override
    public ItemStack getRecipeOutput() { return ItemStack.EMPTY; }

    @Override
    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting inv) {

        NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(inv.getSizeInventory(), ItemStack.EMPTY);

        for (int i = 0; i < nonnulllist.size(); ++i) {
            ItemStack itemstack = inv.getStackInSlot(i);
            nonnulllist.set(i, net.minecraftforge.common.ForgeHooks.getContainerItem(itemstack));
        }

        return nonnulllist;
    }

    //TODO
    @Override
    public boolean isDynamic() {
        return true;
    }

    @Override
    public boolean canFit(int width, int height) {
        return width * height >= 9;
    }

    /**
     * Check if the metadatas of the wool are the same, and return the metadata.
     * @param inv
     * @return Return -1 if the metadatas are not the same. Return the metadata if they are the same.
     */
    private int getWoolMetadata(InventoryCrafting inv) {

        int metadata = -1;

        /**
         * Get the first wool's metadata.
         */
        for (int i = 0; i < inv.getSizeInventory(); ++i) {
            ItemStack itemstack = inv.getStackInSlot(i);

            if (itemstack.getItem() == Item.getItemFromBlock(Blocks.WOOL)) {
                metadata = itemstack.getMetadata();
            }
        }

        for (int i = 0; i < inv.getSizeInventory(); ++i) {
            ItemStack itemstack = inv.getStackInSlot(i);

            if (itemstack.getItem() == Item.getItemFromBlock(Blocks.WOOL) &&
                    itemstack.getMetadata() != metadata) {
                return -1;
            }
        }

        return metadata;
    }
 }
