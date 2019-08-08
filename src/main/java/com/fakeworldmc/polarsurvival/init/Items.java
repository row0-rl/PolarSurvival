package com.fakeworldmc.polarsurvival.init;

import com.fakeworldmc.polarsurvival.client.render.color.WoolenSuitTinter;
import com.fakeworldmc.polarsurvival.item.*;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

@Mod.EventBusSubscriber(modid = "polar_survival")
public class Items {
    public static final ItemWoolenHat WOOLEN_HAT = new ItemWoolenHat();
    public static final ItemSweater SWEATER = new ItemSweater();
    public static final ItemWoolenPants WOOLEN_PANTS = new ItemWoolenPants();
    public static final ItemSnowBoots SNOW_BOOTS = new ItemSnowBoots();
    public static final ItemBackpackFurnace BACKPACK_FURNACE = new ItemBackpackFurnace();

    public static final WoolenSuitTinter WOOLEN_SUIT_TINTER = new WoolenSuitTinter();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        event.getRegistry().register(WOOLEN_HAT.setRegistryName("polar_survival:woolen_hat"));
        event.getRegistry().register(SWEATER.setRegistryName("polar_survival:sweater"));
        event.getRegistry().register(WOOLEN_PANTS.setRegistryName("polar_survival:woolen_pants"));
        event.getRegistry().register(SNOW_BOOTS.setRegistryName("polar_survival:snow_boots"));

        event.getRegistry().register(BACKPACK_FURNACE.setRegistryName("polar_survival:backpack_furnace"));
    }

    @SubscribeEvent
    public static void itemColors(ColorHandlerEvent.Item event) {
        event.getItemColors().registerItemColorHandler(WOOLEN_SUIT_TINTER, WOOLEN_HAT, SWEATER, WOOLEN_PANTS, SNOW_BOOTS);
        //event.getItemColors().registerItemColorHandler((stack, tintIndex) -> tintIndex > 0 ? -1 : ((ItemArmor)stack.getItem()).getColor(stack), SWEATER);
    }
}
