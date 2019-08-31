package com.fakeworldmc.polarsurvival.world;

import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

import java.util.Random;

public class WorldGeneratorCoalOre extends WorldGenerator {

    private final WorldGenerator coalOreGenerator = new WorldGenMinable(Blocks.COAL_ORE.getDefaultState(), 20);

    @Override
    public boolean generate(World world, Random rand, BlockPos pos) {

        if (TerrainGen.generateOre(world, rand, this, pos, OreGenEvent.GenerateMinable.EventType.CUSTOM)) {

            int posX = pos.getX() + rand.nextInt(16);
            int posY = 4 + rand.nextInt(256);
            int posZ = pos.getZ() + rand.nextInt(16);
            BlockPos blockpos = new BlockPos(posX, posY, posZ);

            coalOreGenerator.generate(world, rand, blockpos);

        }

        return true;

    }
}
