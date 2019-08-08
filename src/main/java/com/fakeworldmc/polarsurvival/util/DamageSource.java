package com.fakeworldmc.polarsurvival.util;

public class DamageSource {
    public static final net.minecraft.util.DamageSource FREEZE =
            (new net.minecraft.util.DamageSource("freeze"))
                    .setDifficultyScaled().setDamageBypassesArmor().setDamageIsAbsolute();

}
