package com.fakeworldmc.polarsurvival.warmarea;

import com.fakeworldmc.polarsurvival.init.ItemModifier;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;

import java.util.Collection;
import java.util.Set;

public class Heat {

    private int heatLevel;
    /** The decreasing speed of the player's heat level, depends on the player's armors. */
    private int speed;
    private EntityPlayer player;
    private final int HIGHEST_HEAT_LEVEL = 20;

    /**
     * How many ticks is equal to a second.
     * It should be 20, but I don't know why sometimes it's not.
     */
    public static final int TICKS_PER_SECOND = 39;
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
        if (heatLevel >= HIGHEST_HEAT_LEVEL) {
            heatLevel = HIGHEST_HEAT_LEVEL;
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
        if (heatLevel > HIGHEST_HEAT_LEVEL) {
            heatLevel = HIGHEST_HEAT_LEVEL;
        }
        this.heatLevel = heatLevel;
        return this;
    }

    public int getHeatLevel() {
        return heatLevel;
    }

    public int getSpeed() {

        if (player == null) throw new java.lang.NullPointerException();

        int difficulty = player.getEntityWorld().getDifficulty().getId();
        speed = difficulty == 0 ? -1 : (int)(60 * TICKS_PER_SECOND * BASE_SPEED / difficulty);
        speed *= player.getEntityAttribute(ItemModifier.WARMTH).getAttributeValue();

        return speed;

    }

    public Heat applyWarmthModifiers() {

        //try {
            //player.getEntityAttribute(ItemModifier.WARMTH).removeAllModifiers();
            IAttributeInstance attribute = player.getEntityAttribute(ItemModifier.WARMTH);
            Collection<AttributeModifier> collection = attribute.getModifiers();
            for (AttributeModifier attributemodifier : Lists.newArrayList(collection)) {
                attribute.removeModifier(attributemodifier);
            }

            for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
                //player.getAttributeMap().applyAttributeModifiers(player.getItemStackFromSlot(slot).getAttributeModifiers(slot));
                Multimap<String, AttributeModifier> attributeModifiers = player.getItemStackFromSlot(slot).getAttributeModifiers(slot);
                for (String key : attributeModifiers.keys()) {
                    if (key.equals(ItemModifier.WARMTH.getName())) {
                        for (AttributeModifier attributeModifier : attributeModifiers.get(key)) {
                            player.getEntityAttribute(ItemModifier.WARMTH).applyModifier(attributeModifier);
                            //System.out.println(player.getEntityAttribute(ItemModifier.WARMTH).getAttributeValue());
                        }

                    }
                }

            }

        //} catch (NullPointerException | IllegalArgumentException ignored) {}

        return this;
    }

}
