package com.fakeworldmc.polarsurvival.init;

import com.fakeworldmc.polarsurvival.PolarSurvival;
import com.fakeworldmc.polarsurvival.enchantment.EnchantmentWarmth;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber()
public class Enchantments {

    public static final EnchantmentWarmth ENCHANTMENT_WARMTH = new EnchantmentWarmth();

    @SubscribeEvent
    public static void onEnchantmentRegistration(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().registerAll(ENCHANTMENT_WARMTH.setName("warmth").setRegistryName("polar_survival:warmth_enchantment"));
    }
}
