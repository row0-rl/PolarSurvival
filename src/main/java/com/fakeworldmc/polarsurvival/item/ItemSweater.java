package com.fakeworldmc.polarsurvival.item;

import com.fakeworldmc.polarsurvival.init.ItemModifier;
import com.google.common.collect.Multimap;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;

public class ItemSweater extends ItemWoolenSuit {

    public ItemSweater() {
        super(EntityEquipmentSlot.CHEST);
        this.setTranslationKey("sweater");
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot, ItemStack stack) {

        Multimap<String, AttributeModifier> multimap = super.getAttributeModifiers(slot, stack);

        if (slot == EntityEquipmentSlot.CHEST) {
            double amount = ItemModifier.getAttributeWarmthAmount(0.48, stack);
            multimap.put(ItemModifier.WARMTH.getName(), new AttributeModifier("Armor modifier", amount, 2));
        }
        return multimap;
    }

}
