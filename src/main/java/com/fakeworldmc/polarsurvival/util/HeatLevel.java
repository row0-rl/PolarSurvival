package com.fakeworldmc.polarsurvival.util;

import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = "polar_survival")
public class HeatLevel {
    public HeatLevel() {
        MinecraftForge.EVENT_BUS.register(this);
    }


    private static int HeatLevel = 0;
    private int prevHeatLevel;


    public void addStats(int amount) {
        this.HeatLevel += amount;
    }

    public int getHeatLevel() {
        return this.HeatLevel;
    }

    @SubscribeEvent
    public void onUpdate(AttackEntityEvent event) {
        EntityPlayer player = event.getEntityPlayer();
        EnumDifficulty enumdifficulty = player.world.getDifficulty();

        player.attackEntityFrom(DamageSource.FREEZE, 1.0F);
        if (HeatLevel <= 0) {
            player.attackEntityFrom(DamageSource.FREEZE, 1.0F);
        }
        /*if (this.foodExhaustionLevel > 4.0F)
        {
            this.foodExhaustionLevel -= 4.0F;

            if (this.foodSaturationLevel > 0.0F)
            {
                this.foodSaturationLevel = Math.max(this.foodSaturationLevel - 1.0F, 0.0F);
            }
            else if (enumdifficulty != EnumDifficulty.PEACEFUL)
            {
                this.HeatLevel = Math.max(this.HeatLevel - 1, 0);
            }
        }



        boolean flag = player.world.getGameRules().getBoolean("naturalRegeneration");

        if (flag && this.foodSaturationLevel > 0.0F && player.shouldHeal() && this.HeatLevel >= 20)
        {
            ++this.foodTimer;

            if (this.foodTimer >= 10)
            {
                float f = Math.min(this.foodSaturationLevel, 6.0F);
                player.heal(f / 6.0F);
                this.addExhaustion(f);
                this.foodTimer = 0;
            }
        }
        else if (flag && this.HeatLevel >= 18 && player.shouldHeal())
        {
            ++this.foodTimer;

            if (this.foodTimer >= 80)
            {
                player.heal(1.0F);
                this.addExhaustion(6.0F);
                this.foodTimer = 0;
            }
        }
        else if (this.HeatLevel <= 0)
        {
            ++this.foodTimer;

            if (this.foodTimer >= 80)
            {
                if (player.getHealth() > 10.0F || enumdifficulty == EnumDifficulty.HARD || player.getHealth() > 1.0F && enumdifficulty == EnumDifficulty.NORMAL)
                {
                    player.attackEntityFrom(DamageSource.FREEZE, 1.0F);
                }

                this.foodTimer = 0;
            }
        }
        else
        {
            this.foodTimer = 0;
        }

         */
    }

}
