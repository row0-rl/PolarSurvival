package com.fakeworldmc.polarsurvival.warmarea;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;

public enum HeatSource {

    LAVA(Blocks.LAVA, 8, 7),
    LIT_FURNACE(Blocks.LIT_FURNACE, 4, 3),
    //FIRE(Blocks.FIRE, 6, 2),
    //BEACON(Blocks.BEACON, 16, 31),
    AIR(Blocks.AIR, 0, 0);

    public Block block;
    public int level;
    public int radius;

    HeatSource(Block block, int level, int radius) {
        this.block = block;
        this.level = level;
        this.radius = radius;
    }

}
