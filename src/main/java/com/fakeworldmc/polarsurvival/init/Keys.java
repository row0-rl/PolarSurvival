package com.fakeworldmc.polarsurvival.init;

import com.fakeworldmc.polarsurvival.network.MessageOpenGui;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.client.settings.KeyModifier;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

public class Keys {

    public static KeyBinding openBackpackFurnace= new KeyBinding("key.polarSurvival.openBackpackFurnaceGui",
            KeyConflictContext.IN_GAME, KeyModifier.NONE, Keyboard.KEY_Z, "key.categories.inventory");

    public Keys() {
        ClientRegistry.registerKeyBinding(Keys.openBackpackFurnace);
        MinecraftForge.EVENT_BUS.register(Keys.class);
    }

    @SubscribeEvent
    public static void onKeyPressed(InputEvent.KeyInputEvent event) {
        if (openBackpackFurnace.isPressed()) {
            Network.instance.sendToServer(new MessageOpenGui());
        }
    }

}
