package com.fakeworldmc.polarsurvival.item.crafting;


import com.fakeworldmc.polarsurvival.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RecipeWoolenHat extends RecipeWoolenSuit {

    private final int[] INGREDIENT_POSITION_1 = {0, 1, 2, 3, 5};
    private final int[] EMPTY_POSITION_1 = {4, 6, 7, 8};

    private final int[] INGREDIENT_POSITION_2 = {3, 4, 5, 6, 8};
    private final int[] EMPTY_POSITION_2 = {0, 1, 2, 7};

    @Override
    public boolean matches(InventoryCrafting inv, World worldIn) {
        return matchesPattern1(inv) || matchesPattern2(inv);
    }

    private boolean matchesPattern1(InventoryCrafting inv) {

        for (int i : INGREDIENT_POSITION_1) {
            if (inv.getStackInSlot(i).getItem() != Item.getItemFromBlock(Blocks.WOOL)) {
                return false;
            }
        }

        for (int i : EMPTY_POSITION_1) {
            if (inv.getStackInSlot(i).getItem() != net.minecraft.init.Items.AIR) {
                    return false;
            }
        }

        return true;
    }

    private boolean matchesPattern2(InventoryCrafting inv) {

        for (int i : INGREDIENT_POSITION_2) {
            if (inv.getStackInSlot(i).getItem() != Item.getItemFromBlock(Blocks.WOOL)) {
                return false;
            }
        }

        for (int i : EMPTY_POSITION_2) {
            if (inv.getStackInSlot(i).getItem() != net.minecraft.init.Items.AIR) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getCraftingResult(InventoryCrafting inv) {
        return super.getCraftingResult(inv, Items.WOOLEN_HAT);
    }

}
