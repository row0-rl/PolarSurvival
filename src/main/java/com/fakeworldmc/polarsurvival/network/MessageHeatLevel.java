package com.fakeworldmc.polarsurvival.network;

import com.fakeworldmc.polarsurvival.client.gui.HeatRender;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageHeatLevel implements IMessage {

    private static int heatLevel;

    public MessageHeatLevel() {}

    public MessageHeatLevel(int heatLevelIn) {
        heatLevel = heatLevelIn;
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        heatLevel = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf) {
        buf.writeInt(heatLevel);
    }

    public static class Handler implements IMessageHandler<MessageHeatLevel, IMessage> {

        @Override
        public IMessage onMessage(MessageHeatLevel message, MessageContext context) {

            if (context.side.isClient()) {
                HeatRender.heatLevel = heatLevel;
            }
            return null;
        }

    }

}
