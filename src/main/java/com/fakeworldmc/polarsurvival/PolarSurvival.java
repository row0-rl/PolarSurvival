package com.fakeworldmc.polarsurvival;

import com.fakeworldmc.polarsurvival.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = "polar_survival", name = "Polar Survival", version = "1.0")
public class PolarSurvival {

    @SidedProxy(serverSide = "com.fakeworldmc.polarsurvival.common.CommonProxy",
            clientSide = "com.fakeworldmc.polarsurvival.client.ClientProxy")
    public static CommonProxy proxy;

    public static final String MODID = "polar_survival";

    private static Logger logger;

    @Mod.Instance("polar_survival")
    public static PolarSurvival instance;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
