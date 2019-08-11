package com.fakeworldmc.polarsurvival.network;

import com.fakeworldmc.polarsurvival.PolarSurvival;
import com.fakeworldmc.polarsurvival.init.Guis;
import com.fakeworldmc.polarsurvival.init.Items;
import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageEntityPlayer implements IMessage {

    @Override
    public void fromBytes(ByteBuf buf) {

    }

    @Override
    public void toBytes(ByteBuf buf) {

    }

    public static class Handler implements IMessageHandler<MessageEntityPlayer, IMessage> {

        @Override
        public IMessage onMessage(MessageEntityPlayer message, MessageContext context) {

            if (context.side.isServer()) {
                EntityPlayerMP player = context.getServerHandler().player;

                if (player != null) {
                    BlockPos pos = player.getPosition();
                    World world = player.world;
                    if (player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == Items.BACKPACK_FURNACE) {
                        player.openGui(PolarSurvival.instance, Guis.GUI_BACKPACK_FURNACE, world, pos.getX(), pos.getY(), pos.getZ());
                    }
                }
            }

            return null;
        }

    }

}
