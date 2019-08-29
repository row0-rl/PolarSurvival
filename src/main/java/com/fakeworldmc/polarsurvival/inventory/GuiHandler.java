package com.fakeworldmc.polarsurvival.inventory;

import com.fakeworldmc.polarsurvival.PolarSurvival;
import com.fakeworldmc.polarsurvival.client.gui.GuiBackpackFurnace;
import com.fakeworldmc.polarsurvival.inventory.ContainerBackpackFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler {

    public static final int GUI_BACKPACK_FURNACE = 0;

    public GuiHandler() {
        NetworkRegistry.INSTANCE.registerGuiHandler(PolarSurvival.instance, this);
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {

        switch (id) {
            case GUI_BACKPACK_FURNACE:
                return new ContainerBackpackFurnace(player.inventory, player);
            default:
                return null;
        }

    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer playerIn, World worldIn, int x, int y, int z) {

        switch (id) {
            case GUI_BACKPACK_FURNACE:
                return new GuiBackpackFurnace(playerIn.inventory, playerIn);
            default:
                return null;
        }

    }

}