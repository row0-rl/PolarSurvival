package com.fakeworldmc.polarsurvival.client;

import com.fakeworldmc.polarsurvival.PolarSurvival;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = PolarSurvival.MODID)
public class HeatRender {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(PolarSurvival.MODID +
                    ":textures/gui/heat.png");

    @SubscribeEvent
    public static void onRender(RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            return;
        }
        Minecraft.getMinecraft().renderEngine.bindTexture(Gui.ICONS);
    }

    private void draw(int level) {

    }



}
