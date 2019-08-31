package com.fakeworldmc.polarsurvival.client.render.color;

import com.fakeworldmc.polarsurvival.item.ItemWoolenSuit;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class WoolenSuitTinter implements IItemColor {

    @Override
    public int colorMultiplier(ItemStack stack, int tintIndex) {
        return tintIndex > 0 ? -1 : ((ItemWoolenSuit)stack.getItem()).getColor(stack);
    }

}


