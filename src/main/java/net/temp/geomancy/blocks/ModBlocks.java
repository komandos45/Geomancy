package net.temp.geomancy.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {

	//Block declaration
	public static BlockOre geoStone = new BlockOre("geo_stone");
	public static BlockCrystal crystal = new BlockCrystal();
	public static BlockOre oreBlueGem = new BlockOre("ore_blue_gem");
	public static BlockOre oreBlackGem = new BlockOre("ore_black_gem");
	public static BlockOre oreYellowGem = new BlockOre("ore_yellow_gem");
	public static BlockOre oreRedGem = new BlockOre("ore_red_gem");
	public static BlockOre oreGreenGem = new BlockOre("ore_green_gem");
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				geoStone,crystal,oreBlueGem,oreGreenGem,oreYellowGem,oreRedGem,oreBlackGem
				
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
				oreGreenGem.createItemBlock()
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
	}

}