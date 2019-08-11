package com.fakeworldmc.polarsurvival.item;

import com.fakeworldmc.polarsurvival.common.ItemModifier;
import com.google.common.collect.Multimap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class ItemSnowBoots extends ItemWoolenSuit {

    public ItemSnowBoots() {
        super(EntityEquipmentSlot.FEET);
        this.setTranslationKey("snowBoots");
        this.setCreativeTab(CreativeTabs.COMBAT);
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

        Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

        if (slot == EntityEquipmentSlot.FEET) {
            Double amount = ItemModifier.getAttributeWarmthAmount(0.24, stack);
            multimap.put(ItemModifier.WARMTH.getName(), new AttributeModifier(ItemModifier.WARMTH_MODIFIER,
                    "Tool Modifier", amount, 1));
        }
        return multimap;
    }
}
