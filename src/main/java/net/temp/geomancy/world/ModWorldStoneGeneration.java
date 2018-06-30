package net.temp.geomancy.world;

import net.minecraft.block.Block;
import net.temp.geomancy.GeomancyMod;
import net.temp.geomancy.blocks.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.temp.geomancy.blocks.ModBlocks;

import java.util.Random;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import akka.japi.Predicate;

public class ModWorldStoneGeneration implements IWorldGenerator {
	
	
	public static final Logger logger = LogManager.getLogger(GeomancyMod.modId);
	public String debugMsg;
	

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
		if (world.provider.getDimension() == 0) { // the overworld
			generateOverworld(random, chunkX, chunkZ, world, chunkGenerator, chunkProvider);
		}
	}
	
	
	
	
	private void generateOverworld(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
	generateOre(ModBlocks.geoStone.getDefaultState(), world, BlockMatcher.forBlock(Blocks.STONE) , random, chunkX * 16, chunkZ * 16, 12, 60, 40 + random.nextInt(30), 2);	
	
	}
	
	private void generateCrystal(BlockPos basePos, IBlockState crystal, World world, int baseGen, int varGen, Random random){
		double oreCount = baseGen + random.nextInt(varGen);
		int generated = 0;
		int w, d;
		double ang;
		BlockPos pos;
		
		d=(int) (2*Math.ceil(Math.pow(oreCount, 1/3)));
		for (int i=0;i<d;i++){
			w = (int) Math.ceil(d*0.5*Math.cos(i/d*Math.PI));
			for (int j=0;j<2*w;j++){
				for (int k=0;k<2*w;k++) {
					if (d/2<Math.pow(Math.pow((j-w),2)+Math.pow((k-w),2),0.5)){
						pos = new BlockPos(basePos.getX()+i,basePos.getY()+j-w,basePos.getZ()+k-w);
						if(world.getBlockState(pos).getBlock()==ModBlocks.geoStone || world.getBlockState(pos).getBlock()==Blocks.AIR || world.getBlockState(pos).getBlock() == Blocks.STONE){
							world.setBlockState(pos, crystal);
							generated++;
							//logger.debug("x: "+pos.getX()+" ,y: "+pos.getY()+" ,z: "+pos.getZ());
							if (generated==oreCount){
								return;
							}
							
						}
					}
				}
			}
		}
		return;
		
		
	}
	
	private void generateOre(IBlockState ore, World world, BlockMatcher blockMatcher, Random random, int x, int z, int minY, int maxY, int size, int chances) {
		int deltaY = maxY - minY;
		for (int i = 0; i < chances; i++) {
			BlockPos pos = new BlockPos(x + random.nextInt(5) + 6, minY + random.nextInt(deltaY), z + random.nextInt(5) + 6);
			WorldGenMinable generator = new WorldGenMinable(ore, size);
			
			/*
			debugMsg = "x: "+ pos.getX() + " ,y: " + pos.getY() + " ,z: " + pos.getZ();
			logger.debug(debugMsg);
			 */
			
			generator.generate(world, random, pos);
			/*
			switch (random.nextInt(5)){
				case 0:
					generateCrystal(pos, ModBlocks.oreBlackGem.getDefaultState(), world, 10, 3, random);
				case 1:
					generateCrystal(pos, ModBlocks.oreBlueGem.getDefaultState(), world, 10, 3, random);
				case 2:
					generateCrystal(pos, ModBlocks.oreYellowGem.getDefaultState(), world, 10, 3, random);
				case 3:
					generateCrystal(pos, ModBlocks.oreRedGem.getDefaultState(), world, 10, 3, random);
				case 4:
					generateCrystal(pos, ModBlocks.oreGreenGem.getDefaultState(), world, 10, 3, random);
			}
			*/
			
		}
	}
}