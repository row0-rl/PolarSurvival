package com.fakeworldmc.polarsurvival.client.render.color;

import com.fakeworldmc.polarsurvival.item.ItemWoolenSuit;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
public class WoolenSuitTinter implements IItemColor {

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

    @Override
    public int colorMultiplier(ItemStack stack, int tintIndex) {
        return tintIndex > 0 ? -1 : ((ItemWoolenSuit)stack.getItem()).getColor(stack);
    }

}


