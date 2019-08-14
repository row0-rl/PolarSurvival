package com.fakeworldmc.polarsurvival.warmarea;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;

public enum HeatSource {

    AIR(Blocks.AIR, 0, 0),
    LAVA(Blocks.LAVA, 8, 15),
    LIT_FURNACE(Blocks.LIT_FURNACE, 4, 3),
    FIRE(Blocks.FIRE, 6, 2),
    BEACON(Blocks.BEACON, 16, 31);

    public Block block;
    public int level;
    public int radius;

    HeatSource(Block blockIn, int levelIn, int radiusIn) {
        this.block = blockIn;
        this.level = levelIn;
        this.radius = radiusIn;
    }

}
