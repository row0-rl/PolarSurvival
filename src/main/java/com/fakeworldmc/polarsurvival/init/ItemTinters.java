package com.fakeworldmc.polarsurvival.init;

import com.fakeworldmc.polarsurvival.client.render.color.WoolenSuitTinter;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemTinters {

    public static final WoolenSuitTinter WOOLEN_SUIT_TINTER = new WoolenSuitTinter();

    public ItemTinters() {
        MinecraftForge.EVENT_BUS.register(ItemTinters.class);
    }

    @SubscribeEvent
    public static void registerItemColors(ColorHandlerEvent.Item event) {
        event.getItemColors().registerItemColorHandler(WOOLEN_SUIT_TINTER, Items.WOOLEN_HAT, Items.SWEATER, Items.WOOLEN_PANTS, Items.SNOW_BOOTS);
    }

}
