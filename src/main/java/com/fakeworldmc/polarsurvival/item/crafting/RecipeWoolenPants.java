package com.fakeworldmc.polarsurvival.item.crafting;


import com.fakeworldmc.polarsurvival.init.Items;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class RecipeWoolenPants extends RecipeWoolenSuit {
    private final int[] INGREDIENT_POSITION = {0, 1, 2, 3, 5, 6, 8};
    private final int[] EMPTY_POSITION = {4, 7};

    public boolean matches(InventoryCrafting inv, World worldIn) {

        for (int i: INGREDIENT_POSITION) {
            if (inv.getStackInSlot(i).getItem() != Item.getItemFromBlock(Blocks.WOOL)) { return false; }
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
        return super.getCraftingResult(inv, Items.WOOLEN_PANTS);
    }

 }
