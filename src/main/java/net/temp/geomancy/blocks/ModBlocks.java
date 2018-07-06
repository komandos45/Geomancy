package net.temp.geomancy.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;
import net.temp.geomancy.counter.BlockCounter;
import net.temp.geomancy.items.ModItems;

public class ModBlocks {

	//Block declaration
	public static BlockBase geoStone = new BlockBase(Material.ROCK, "geo_stone");
	public static BlockCrystal crystal = new BlockCrystal();
	public static BlockOre oreBlueGem = new BlockOre("ore_blue_gem", ModItems.blueGem, 2, 3);
	public static BlockOre oreBlackGem = new BlockOre("ore_black_gem", ModItems.blackGem, 2, 3);
	public static BlockOre oreYellowGem = new BlockOre("ore_yellow_gem", ModItems.yellowGem, 2, 3);
	public static BlockOre oreRedGem = new BlockOre("ore_red_gem", ModItems.redGem, 2, 3);
	public static BlockOre oreGreenGem = new BlockOre("ore_green_gem", ModItems.greenGem, 2, 3);
	public static BlockCounter counter = new BlockCounter();
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				geoStone,crystal,oreBlueGem,oreGreenGem,oreYellowGem,oreRedGem,oreBlackGem
				,counter
		);
	}

	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				geoStone.createItemBlock(),
				crystal.createItemBlock(),
				oreBlueGem.createItemBlock(),
				oreBlackGem.createItemBlock(),
				oreRedGem.createItemBlock(),
				oreYellowGem.createItemBlock(),
				oreGreenGem.createItemBlock(),
				counter.createItemBlock()
		); 

	}

	public static void registerModels() {
		geoStone.registerItemModel(Item.getItemFromBlock(geoStone));
		crystal.registerItemModel(Item.getItemFromBlock(crystal));
		oreBlueGem.registerItemModel(Item.getItemFromBlock(oreBlueGem));
		oreRedGem.registerItemModel(Item.getItemFromBlock(oreRedGem));
		oreBlackGem.registerItemModel(Item.getItemFromBlock(oreBlackGem));
		oreYellowGem.registerItemModel(Item.getItemFromBlock(oreYellowGem));
		oreGreenGem.registerItemModel(Item.getItemFromBlock(oreGreenGem));
		counter.registerItemModel(Item.getItemFromBlock(counter));
	}

}