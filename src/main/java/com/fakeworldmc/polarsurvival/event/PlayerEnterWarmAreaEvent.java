package com.fakeworldmc.polarsurvival.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PlayerEnterWarmAreaEvent extends PlayerEvent {
    public PlayerEnterWarmAreaEvent(EntityPlayer player) {
        super(player);
    }
}
