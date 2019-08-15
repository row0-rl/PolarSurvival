package com.fakeworldmc.polarsurvival.warmarea;

import com.fakeworldmc.polarsurvival.PolarSurvival;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber(modid = PolarSurvival.MODID)
public class WarmArea {

    private static int reduceTimer = 0;
    private static int addTimer = 0;
    private static int attackTimer = 0;
    private static int heatLevel = 8;

    public static final DamageSource FREEZE =
            new DamageSource("freeze").setDifficultyScaled()
                    .setDamageBypassesArmor().setDamageIsAbsolute();

    @SubscribeEvent
    public static void checkIsPlayerInWarmArea(TickEvent.PlayerTickEvent event) {

        HeatSource source = isPlayerInWarmArea(event.player);
        Heat heat = new Heat(event.player).setHeatLevel(heatLevel);

        if (source.level < heat.getHeatLevel()) {
            reduceTimer++;
            addTimer = 0;
            if (reduceTimer >= heat.getSpeed()) {
                reduceTimer = 0;
                heat.reduce();

            }
            if (heat.getHeatLevel() > 0) {
                attackTimer = 0;
            }
            else {
                attackTimer++;
                if (attackTimer >= 20) {
                    attackTimer = 0;
                    event.player.attackEntityFrom(FREEZE, 1);
                }
            }
        }
        else {
            addTimer++;
            reduceTimer = 0;
            attackTimer = 0;
            if (addTimer >= 100) {
                addTimer = 0;
                heat.add();
            }
        }

        heatLevel = heat.getHeatLevel();
    }

    public static HeatSource isPlayerInWarmArea(EntityPlayer playerIn) {

        World world = playerIn.getEntityWorld();
        BlockPos center = playerIn.getPosition();
        HeatSource hottestSource = HeatSource.AIR;

        for (HeatSource source: HeatSource.values()) {
            if (source == HeatSource.AIR) {continue;}

            int length = source.radius * 2 + 1;

            BlockPos x = center.add(-source.radius, 0, 0);
            for (int i = 0; i < length; i++, x = x.add(1, 0, 0)) {

                BlockPos y = x.add(0, -source.radius, 0);
                for (int j = 0; j < length; j++, y = y.add(0, 1, 0)) {

                    BlockPos z = y.add(0, 0, -source.radius);
                    for (int k = 0; k < length; k++, z = z.add(0, 0, 1)) {
                        if (world.getBlockState(z).getBlock() == source.block) {
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
