package com.fakeworldmc.polarsurvival.init;

import com.fakeworldmc.polarsurvival.client.render.color.WoolenSuitTinter;
import com.fakeworldmc.polarsurvival.item.*;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

@Mod.EventBusSubscriber
public class Items {

    public static final ItemWoolenHat WOOLEN_HAT = new ItemWoolenHat();
    public static final ItemSweater SWEATER = new ItemSweater();
    public static final ItemWoolenPants WOOLEN_PANTS = new ItemWoolenPants();
    public static final ItemSnowBoots SNOW_BOOTS = new ItemSnowBoots();
    public static final ItemBackpackFurnace BACKPACK_FURNACE = new ItemBackpackFurnace();

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {

        event.getRegistry().registerAll(
                WOOLEN_HAT.setRegistryName("polar_survival:woolen_hat"),
                SWEATER.setRegistryName("polar_survival:sweater"),
                WOOLEN_PANTS.setRegistryName("polar_survival:woolen_pants"),
                SNOW_BOOTS.setRegistryName("polar_survival:snow_boots"));

        event.getRegistry().register(BACKPACK_FURNACE.setRegistryName("polar_survival:backpack_furnace"));
    }

}
