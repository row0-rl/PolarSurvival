package com.fakeworldmc.polarsurvival.warmarea;

import com.fakeworldmc.polarsurvival.PolarSurvival;
import com.fakeworldmc.polarsurvival.init.ItemModifier;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber(modid = PolarSurvival.MODID)
public class WarmArea {

    private static int addTimer = 0,
            reduceTimer = 0,
            attackTimer = 0;
    private static int heatLevel = 8;

    protected static final DamageSource FREEZE =
            new DamageSource("freeze").setDifficultyScaled()
                    .setDamageBypassesArmor().setDamageIsAbsolute();

    @SubscribeEvent
    public static void checkIsPlayerInWarmArea(TickEvent.PlayerTickEvent event) {

        if (event.player.capabilities.isCreativeMode) return;

        HeatSource source = isPlayerInWarmArea(event.player);
        Heat heat = new Heat(event.player, heatLevel);
        if (heat.getSpeed() == -1) return;
        System.out.println("HeatLevel: "+heatLevel);

        /** Add the heat level. */
        if (source.level > heat.getHeatLevel()) {
            addTimer++;
            reduceTimer = 0;
            attackTimer = 0;
            System.out.println("AddTimer: "+addTimer);
            if (addTimer >= 100 * 4) {
                addTimer = 0;
                heat.add();
            }
        }

        /** Reduce the heat level. */
        else if (source.level < heat.getHeatLevel()) {
            addTimer = 0;
            reduceTimer++;
            attackTimer = 0;
            System.out.println("ReduceTimer: "+reduceTimer);
            if (reduceTimer >= heat.getSpeed()) {
                reduceTimer = 0;
                heat.drop();
            }
        }

        /** Freeze the player. */
        else if (heat.getHeatLevel() == 0) {
            addTimer = 0;
            reduceTimer = 0;
            attackTimer++;
            if (attackTimer >= 20 * 4) {
                attackTimer = 0;
                event.player.attackEntityFrom(FREEZE, 1);
            }
        }

        else {
            addTimer = 0;
            reduceTimer = 0;
            attackTimer = 0;
        }

        heatLevel = heat.getHeatLevel();
    }

    @SubscribeEvent
    public static void registerAttributes(EntityJoinWorldEvent event) {
        if (!(event.getEntity() instanceof EntityPlayer)) return;
        ((EntityPlayer)(event.getEntity())).getAttributeMap()
                .registerAttribute(ItemModifier.WARMTH).setBaseValue(Heat.BASE_SPEED);
    }

    private static HeatSource isPlayerInWarmArea(EntityPlayer playerIn) {

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
