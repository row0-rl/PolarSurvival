package com.fakeworldmc.polarsurvival.common;

import com.fakeworldmc.polarsurvival.init.Keys;
import com.fakeworldmc.polarsurvival.inventory.GuiHandler;
import com.fakeworldmc.polarsurvival.init.Network;
import com.fakeworldmc.polarsurvival.warmarea.WarmArea;
import com.fakeworldmc.polarsurvival.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent event) {

    }

    public void init(FMLInitializationEvent event) {
        new World();
        new GuiHandler();
        new Network();
        new WarmArea();

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}
