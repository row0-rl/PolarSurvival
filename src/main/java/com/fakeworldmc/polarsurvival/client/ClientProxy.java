package com.fakeworldmc.polarsurvival.client;

import com.fakeworldmc.polarsurvival.client.gui.HeatRender;
import com.fakeworldmc.polarsurvival.common.CommonProxy;
import com.fakeworldmc.polarsurvival.init.ItemTinters;
import com.fakeworldmc.polarsurvival.init.Keys;
import com.fakeworldmc.polarsurvival.warmarea.WarmArea;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

    @Override
    public void preInit(FMLPreInitializationEvent event) {
        super.preInit(event);
        new ItemTinters();
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
        new HeatRender();
        new Keys();
        new WarmArea();

    }

    @Override
    public void postInit(FMLPostInitializationEvent event) {
        super.postInit(event);
    }

}