package com.fakeworldmc.polarsurvival.attribute;

import com.fakeworldmc.polarsurvival.init.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.item.ItemStack;

import java.util.UUID;

public class Attribute {

    public static final UUID WARMTH_MODIFIER = UUID.fromString("4035afc0-e605-465b-8469-30516a8e33ac");

    public static final IAttribute WARMTH = new RangedAttribute((IAttribute)null, "polar_survival.warmth",
            0d, -10d, 10d).setDescription("Warmth").setShouldWatch(true);

    public static Double getAttributeWarmthAmount(Double baseAmount, ItemStack stack) {
        Double amount = baseAmount + 0.05 * EnchantmentHelper.getEnchantmentLevel(Enchantments.ENCHANTMENT_WARMTH, stack);
        return amount;
    }

}
