package com.fakeworldmc.polarsurvival.client.gui;

import com.fakeworldmc.polarsurvival.PolarSurvival;
import com.fakeworldmc.polarsurvival.warmarea.WarmArea;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class HeatRender {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(PolarSurvival.MODID +
                    ":textures/gui/heat.png");

    public HeatRender() {
        MinecraftForge.EVENT_BUS.register(HeatRender.class);
    }

    @SubscribeEvent
    public static void onRender(RenderGameOverlayEvent event) {

        if (event.getType() != RenderGameOverlayEvent.ElementType.AIR) return;

        EntityPlayer player = (EntityPlayer)Minecraft.getMinecraft().getRenderViewEntity();

        if (player != null && player.isInsideOfMaterial(Material.WATER)) {
            draw(event.getResolution(), WarmArea.heat.getHeatLevel(), true);
            Minecraft.getMinecraft().renderEngine.bindTexture(Gui.ICONS);
            return;
        }

        draw(event.getResolution(), WarmArea.heat.getHeatLevel(), false);
        Minecraft.getMinecraft().renderEngine.bindTexture(Gui.ICONS);

    }

    private static void draw(ScaledResolution scaledResolution, int level, boolean isInsideOfWater) {

        int yAmount = isInsideOfWater ? 60 : 51;

        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getMinecraft().getTextureManager().bindTexture(TEXTURE);
        GlStateManager.enableBlend();

        int i = 0;
        int width = scaledResolution.getScaledWidth() / 2;
        int height = scaledResolution.getScaledHeight();

        for (; i < level / 2; i++) {
            Minecraft.getMinecraft().ingameGUI.drawTexturedModalRect(width + 9 + 8 * i, height - yAmount, 0, 0, 9, 10);
        }

        if (level % 2 == 1) {
            Minecraft.getMinecraft().ingameGUI.drawTexturedModalRect(width + 9 + 8 * i, height - yAmount, 9, 0, 9, 10);
        }

    }

}
