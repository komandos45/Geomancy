package net.temp.geomancy.world;

import net.minecraft.block.Block;
import net.temp.geomancy.blocks.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.temp.geomancy.blocks.ModBlocks;

import java.util.Random;

import akka.japi.Predicate;

public class ModWorldGeneration implements IWorldGenerator {
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.getDimension() == 0) { // the overworld
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}
	
	
	
	
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
	generateOre(ModBlocks.geoStone.getDefaultState(), world, BlockMatcher.forBlock(Blocks.STONE) , random, chunkX * 16, chunkZ * 16, 12, 60, 60 + random.nextInt(40), 2);
	generateOre(ModBlocks.oreBlueGem.getDefaultState(), world, BlockMatcher.forBlock(net.temp.geomancy.blocks.ModBlocks.geoStone) , random, chunkX * 16, chunkZ * 16, 12, 60, 4 + random.nextInt(4), 4);
	generateOre(ModBlocks.oreBlackGem.getDefaultState(), world, BlockMatcher.forBlock(net.temp.geomancy.blocks.ModBlocks.geoStone) , random, chunkX * 16, chunkZ * 16, 12, 60, 4 + random.nextInt(4), 4);
	generateOre(ModBlocks.oreRedGem.getDefaultState(), world, BlockMatcher.forBlock(net.temp.geomancy.blocks.ModBlocks.geoStone) , random, chunkX * 16, chunkZ * 16, 12, 60, 4 + random.nextInt(4), 4);
	generateOre(ModBlocks.oreYellowGem.getDefaultState(), world, BlockMatcher.forBlock(net.temp.geomancy.blocks.ModBlocks.geoStone) , random, chunkX * 16, chunkZ * 16, 12, 60, 4 + random.nextInt(4), 4);
	generateOre(ModBlocks.oreGreenGem.getDefaultState(), world, BlockMatcher.forBlock(net.temp.geomancy.blocks.ModBlocks.geoStone) , random, chunkX * 16, chunkZ * 16, 12, 60, 4 + random.nextInt(4), 4);

	
	
	
	
	
	}
	
	private void generateOre(IBlockState ore, World world, BlockMatcher blockMatcher, Random random, int x, int z, int minY, int maxY, int size, int chances) {
		int deltaY = maxY - minY;
	
		for (int i = 0; i < chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(16), minY + random.nextInt(deltaY), z + random.nextInt(16));
	
			WorldGenMinable generator = new WorldGenMinable(ore, size);
			generator.generate(world, random, pos);
		}
	}
}