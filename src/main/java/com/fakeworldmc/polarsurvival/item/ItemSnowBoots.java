package com.fakeworldmc.polarsurvival.item;

import com.fakeworldmc.polarsurvival.attribute.Attribute;
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
            Double amount = Attribute.getAttributeWarmthAmount(0.24, stack);
            multimap.put(Attribute.WARMTH.getName(), new AttributeModifier(Attribute.WARMTH_MODIFIER,
                    "Tool Modifier", amount, 1));
        }
        return multimap;
    }
}
