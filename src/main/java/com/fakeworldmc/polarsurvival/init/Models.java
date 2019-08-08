package com.fakeworldmc.polarsurvival.init;

import com.fakeworldmc.polarsurvival.init.Items;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(value = Side.CLIENT, modid = "polar_survival")
public final class Models {
    @SubscribeEvent
    public static void onModelReg(ModelRegistryEvent event) {

            ModelLoader.setCustomModelResourceLocation(Items.WOOLEN_HAT, 0,
                    new ModelResourceLocation(Items.WOOLEN_HAT.getRegistryName(), "inventory"));

            ModelLoader.setCustomModelResourceLocation(Items.SWEATER, 0,
                    new ModelResourceLocation(Items.SWEATER.getRegistryName(), "inventory"));

            ModelLoader.setCustomModelResourceLocation(Items.WOOLEN_PANTS, 0,
                    new ModelResourceLocation(Items.WOOLEN_PANTS.getRegistryName(), "inventory"));

            ModelLoader.setCustomModelResourceLocation(Items.SNOW_BOOTS, 0,
                    new ModelResourceLocation(Items.SNOW_BOOTS.getRegistryName(), "inventory"));

            ModelLoader.setCustomModelResourceLocation(Items.BACKPACK_FURNACE, 0,
                    new ModelResourceLocation(Items.BACKPACK_FURNACE.getRegistryName(), "inventory"));



    }
}

