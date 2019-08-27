package com.fakeworldmc.polarsurvival.client;

import com.fakeworldmc.polarsurvival.client.gui.HeatRender;
import com.fakeworldmc.polarsurvival.common.CommonProxy;
import com.fakeworldmc.polarsurvival.init.ItemTinters;
import com.fakeworldmc.polarsurvival.init.Keys;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        new HeatRender();
        new ItemTinters();
        new Keys();
    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

}