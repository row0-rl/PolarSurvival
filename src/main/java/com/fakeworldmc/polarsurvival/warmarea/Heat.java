package com.fakeworldmc.polarsurvival.warmarea;

import com.fakeworldmc.polarsurvival.common.ItemModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.EnumDifficulty;

public class Heat {

    private int heatLevel;
    /** The decreasing speed of the player's heat level, depends on the player's armors. */
    private int speed;
    private EntityPlayer player;

    public Heat(EntityPlayer player) {
        this.player = player;
    }

    public void add() {
        if (heatLevel >= 20) {
            heatLevel = 20;
            return;
        }
        heatLevel++;
    }
//is 'reduce' right??
    public void reduce() {
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
        speed = difficulty == 0 ? -1 : 60 * 20 / difficulty;
        speed += speed * player.getAttributeMap().getAttributeInstance(ItemModifier.WARMTH)
                .getAttributeValue() / 100;
        return speed;
    }
}
