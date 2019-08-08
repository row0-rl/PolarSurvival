package com.fakeworldmc.polarsurvival.init;

import com.fakeworldmc.polarsurvival.PolarSurvival;
import com.fakeworldmc.polarsurvival.client.gui.GuiBackpackFurnace;
import com.fakeworldmc.polarsurvival.client.gui.GuiDemo;
import com.fakeworldmc.polarsurvival.inventory.ContainerBackpackFurnace;
import com.fakeworldmc.polarsurvival.inventory.ContainerDemo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class Guis implements IGuiHandler
{
    public static final int GUI_BACKPACK_FURNACE = 0;
    public static final int GUI_DEMO = 1;

    public Guis() {
        NetworkRegistry.INSTANCE.registerGuiHandler(PolarSurvival.instance, this);
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        switch (ID) {
            case GUI_BACKPACK_FURNACE:
                return new ContainerBackpackFurnace(player.inventory);
            case GUI_DEMO:
                return new ContainerDemo(player.inventory);
            default:
                return null;
        }
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        switch (ID) {
            case GUI_BACKPACK_FURNACE:
                return new GuiBackpackFurnace(player.inventory);
            case GUI_DEMO:
                return new GuiDemo(player.inventory);
            default:
                return null;
        }
    }
}