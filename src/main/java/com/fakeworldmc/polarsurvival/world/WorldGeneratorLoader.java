package com.fakeworldmc.polarsurvival.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WorldGeneratorLoader {

    private static final WorldGenerator WORLD_GENERATOR_COAL_ORE = new WorldGeneratorCoalOre();

    private BlockPos position;

    public WorldGeneratorLoader() {
        MinecraftForge.ORE_GEN_BUS.register(this);
        MinecraftForge.TERRAIN_GEN_BUS.register(this);
    }

    @SubscribeEvent
    public void onOreGenPost(OreGenEvent.Post event) {
        if (!event.getPos().equals(this.position)) {
            this.position = event.getPos();
            WORLD_GENERATOR_COAL_ORE.generate(event.getWorld(), event.getRand(), event.getPos());
        }
    }

    @SubscribeEvent
    public void onDecorateBiome(DecorateBiomeEvent.Decorate event) {
        if (event.getType() == DecorateBiomeEvent.Decorate.EventType.LAKE_LAVA) {
            event.setResult(Event.Result.DENY);
        }
    }

}
