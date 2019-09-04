package com.fakeworldmc.polarsurvival.init;

import com.fakeworldmc.polarsurvival.PolarSurvival;
import com.fakeworldmc.polarsurvival.network.MessageHeatLevel;
import com.fakeworldmc.polarsurvival.network.MessageOpenGui;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class Network {

    public static SimpleNetworkWrapper instance = NetworkRegistry.INSTANCE.newSimpleChannel(PolarSurvival.MODID);

    private static int id = 0;

    public Network() {
        instance.registerMessage(MessageOpenGui.Handler.class, MessageOpenGui.class, id++, Side.SERVER);
        instance.registerMessage(MessageHeatLevel.Handler.class, MessageHeatLevel.class, id++, Side.CLIENT);
    }

}
