package com.fakeworldmc.polarsurvival.warmarea;

import com.fakeworldmc.polarsurvival.init.ItemModifier;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;

import java.util.Collection;

public class Heat {

    private int heatLevel;
    /** The decreasing speed of the player's heat level, depends on the player's armors. */
    private int speed;
    private EntityPlayer player;

    /**
     * When something's burning in the backpack furnace, player's heat level will
     * increase by 1 per ADD_HEAT_LEVEL_SPEED_WHEN_BUTNING tick(s).
     */
    public static final int ADD_HEAT_LEVEL_SPEED_WHEN_BURNING = 100;
    public static final double BASE_SPEED = 1.0D;

    public Heat(EntityPlayer player, int heatLevel) {
        this.player = player;
        setHeatLevel(heatLevel);
    }

    public void add() {
        if (heatLevel >= 20) {
            heatLevel = 20;
            return;
        }
        heatLevel++;
    }

    public void drop() {
        if (heatLevel <= 0) {
            heatLevel = 0;
            return;
        }
        heatLevel--;
    }

    public Heat setHeatLevel(int heatLevel) {
        if (heatLevel > 20) {
            heatLevel = 20;
        }
        this.heatLevel = heatLevel;
        return this;
    }

    public int getHeatLevel() {
        return heatLevel;
    }

    public int getSpeed() {

        int difficulty = player.getEntityWorld().getDifficulty().getId();
        speed = difficulty == 0 ? -1 : (int)(60 * 20 * 4 * BASE_SPEED / difficulty);
        try {
            //TODO onArmorTick ISpecialArmor?
            //player.getEntityAttribute(ItemModifier.WARMTH).removeAllModifiers();
            IAttributeInstance attribute = player.getEntityAttribute(ItemModifier.WARMTH);
            Collection<AttributeModifier> collection = attribute.getModifiers();
            for (AttributeModifier attributemodifier: Lists.newArrayList(collection)) {
                attribute.removeModifier(attributemodifier);
            }

            for (EntityEquipmentSlot slot: EntityEquipmentSlot.values()) {
                player.getAttributeMap().applyAttributeModifiers(player.getItemStackFromSlot(slot).getAttributeModifiers(slot));
                /*Multimap<String, AttributeModifier> attributeModifiers = player.getItemStackFromSlot(slot).getAttributeModifiers(slot);
                for (String key: attributeModifiers.keys()) {
                    if (key == ItemModifier.WARMTH.getName()) {
                        //System.out.println(slot.getName());
                        for (AttributeModifier attributeModifier: attributeModifiers.get(key)) {
                            //player.getEntityAttribute(ItemModifier.WARMTH).applyModifier(attributeModifier);
                            player.getAttributeMap().getAttributeInstance(ItemModifier.WARMTH).applyModifier(attributeModifier);
                            //System.out.println(player.getEntityAttribute(ItemModifier.WARMTH).getAttributeValue());
                        }

                    }
                }

                 */

            }

            speed *= player.getEntityAttribute(ItemModifier.WARMTH).getAttributeValue();
            //System.out.println(player.getEntityAttribute(ItemModifier.WARMTH).getAttributeValue());
        } catch (NullPointerException | IllegalArgumentException ignored) {}

        return speed;
    }

}
