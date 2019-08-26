package com.fakeworldmc.polarsurvival.warmarea;

import com.fakeworldmc.polarsurvival.init.ItemModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;

public class Heat {

    private int heatLevel;
    /** The decreasing speed of the player's heat level, depends on the player's armors. */
    private int speed;
    private EntityPlayer player;

    static final double BASE_SPEED = 1.0D;

    Heat(EntityPlayer player, int heatLevel) {
        this.player = player;
        setHeatLevel(heatLevel);
    }

    void add() {
        if (heatLevel >= 20) {
            heatLevel = 20;
            return;
        }
        heatLevel++;
    }

    void drop() {
        if (heatLevel <= 0) {
            heatLevel = 0;
            return;
        }
        heatLevel--;
    }

    Heat setHeatLevel(int heatLevel) {
        if (heatLevel > 20) {
            heatLevel = 20;
        }
        this.heatLevel = heatLevel;
        return this;
    }

    int getHeatLevel() {
        return heatLevel;
    }

    int getSpeed() {

        int difficulty = player.getEntityWorld().getDifficulty().getId();
        speed = difficulty == 0 ? -1 : (int)(60 * 20 * 4 * BASE_SPEED / difficulty);
        try {
            player.getEntityAttribute(ItemModifier.WARMTH).removeAllModifiers();
            for (EntityEquipmentSlot slot: EntityEquipmentSlot.values()) {
                player.getAttributeMap().applyAttributeModifiers(player.getItemStackFromSlot(slot).getAttributeModifiers(slot));
                /*Multimap<String, AttributeModifier> attributeModifiers = player.getItemStackFromSlot(slot).getAttributeModifiers(slot);
                for (String key: attributeModifiers.keys()) {
                    if (key == ItemModifier.WARMTH.getName()) {
                        System.out.println(slot.getName());
                        for (AttributeModifier attributeModifier: attributeModifiers.get(key)) {
                            player.getEntityAttribute(ItemModifier.WARMTH).applyModifier(attributeModifier);
                            System.out.println(player.getEntityAttribute(ItemModifier.WARMTH).getAttributeValue());
                        }

                    }
                }
                 */
            }

            speed *= player.getEntityAttribute(ItemModifier.WARMTH).getAttributeValue();
            System.out.println(player.getEntityAttribute(ItemModifier.WARMTH).getAttributeValue());
        } catch (Exception ignored) {}

        return speed;
    }

}
