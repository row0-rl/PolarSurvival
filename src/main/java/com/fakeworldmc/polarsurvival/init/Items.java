package com.fakeworldmc.polarsurvival.init;

import com.fakeworldmc.polarsurvival.client.render.color.WoolenSuitTinter;
import com.fakeworldmc.polarsurvival.item.*;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import java.util.UUID;

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
    }


    public static final UUID WARMTH_MODIFIER = UUID.fromString("4035afc0-e605-465b-8469-30516a8e33ac");

    public static final IAttribute WARMTH = new RangedAttribute((IAttribute)null, "polar_survival.warmth",
            0d, -1000d, 1000d).setDescription("Warmth").setShouldWatch(true);

    public static Double getAttributeWarmthAmount(Double baseAmount, ItemStack stack) {
        Double amount = baseAmount + 0.05 * EnchantmentHelper.getEnchantmentLevel(Enchantments.ENCHANTMENT_WARMTH, stack);
        return amount;
    }
}
