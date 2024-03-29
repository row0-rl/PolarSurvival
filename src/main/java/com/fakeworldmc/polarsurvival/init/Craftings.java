package com.fakeworldmc.polarsurvival.init;

import com.fakeworldmc.polarsurvival.PolarSurvival;
import com.fakeworldmc.polarsurvival.item.crafting.*;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class Craftings {

    @SubscribeEvent
    public static void onCraftingReg(RegistryEvent.Register<IRecipe> event) {
        event.getRegistry().registerAll(new RecipeWoolenHat().setRegistryName("polar_survival:woolen_hat_recipe"),
                new RecipeSweater().setRegistryName("polar_survival:sweater_recipe"),
                new RecipeWoolenPants().setRegistryName("polar_survival:woolen_pants_recipe"),
                new RecipeSnowBoots().setRegistryName("polar_survival:snow_boots_recipe"));
    }

}
