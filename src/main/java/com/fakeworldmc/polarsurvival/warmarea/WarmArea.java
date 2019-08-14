package com.fakeworldmc.polarsurvival.warmarea;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class WarmArea {

    public static final net.minecraft.util.DamageSource FREEZE =
            (new net.minecraft.util.DamageSource("freeze"))
                    .setDifficultyScaled().setDamageBypassesArmor().setDamageIsAbsolute();

    public static HeatSource isPlayerInWarmArea(EntityPlayer playerIn) {

        World world = playerIn.getEntityWorld();
        BlockPos center = playerIn.getPosition();
        HeatSource hottestSource = HeatSource.AIR;

        for (HeatSource source: HeatSource.values()) {
            int length = source.radius * 2 + 1;

            BlockPos x = center.add(-source.radius, 0, 0);
            for (int i = 0; i < length; i++, x.add(1, 0, 0)) {

                BlockPos y = x.add(0, -source.radius, 0);
                for (int j = 0; j < length; j++, y.add(0, 1, 0)) {

                    BlockPos z = y.add(0, 0, -source.radius);
                    for (int k = 0; k < length; k++, z.add(0, 0, 1)) {
                        if (world.getBlockState(z).getBlock() != Blocks.AIR &&
                                world.getBlockState(z).getBlock() == source.block) {
                            if (source.level > hottestSource.level) {
                                hottestSource = source;
                            }
                        }
                    }
                }
            }

        }

        return hottestSource;
    }

}
