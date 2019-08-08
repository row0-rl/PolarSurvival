package com.fakeworldmc.polarsurvival.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WarmthHudRender {

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        drawWarmth(20);
        Minecraft.getMinecraft().renderEngine.bindTexture(Gui.ICONS);
    }

    private void drawWarmth(int warmth) {

    }


}
