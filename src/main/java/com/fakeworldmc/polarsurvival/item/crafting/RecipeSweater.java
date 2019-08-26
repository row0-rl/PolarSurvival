package com.fakeworldmc.polarsurvival.item.crafting;


import com.fakeworldmc.polarsurvival.init.Items;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RecipeSweater extends RecipeWoolenSuit {

    private final int[] INGREDIENT_POSITION = {0, 2, 3, 4, 5, 6, 7, 8};
    private final int[] EMPTY_POSITION = {1};

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {

        for (int i: INGREDIENT_POSITION) {
            if (inv.getStackInSlot(i).getItem() != Item.getItemFromBlock(Blocks.WOOL)) {
                return false;
            }
        }

        for (int i: EMPTY_POSITION) {
            if (inv.getStackInSlot(i).getItem() != net.minecraft.init.Items.AIR) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return super.getCraftingResult(inv, Items.SWEATER);
    }

}
