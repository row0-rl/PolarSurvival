package com.fakeworldmc.polarsurvival.common;

import com.fakeworldmc.polarsurvival.init.Keys;
import com.fakeworldmc.polarsurvival.init.Guis;
import com.fakeworldmc.polarsurvival.init.Network;
import com.fakeworldmc.polarsurvival.util.HeatLevel;
import com.fakeworldmc.polarsurvival.init.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) {
    }

    public void init(FMLInitializationEvent event) {
        new World();
        new HeatLevel();
        new Guis();
        new Keys();
        new Network();
    }

    public void postInit(FMLPostInitializationEvent event)
    {
        //new HeatLevel();
    }
}
