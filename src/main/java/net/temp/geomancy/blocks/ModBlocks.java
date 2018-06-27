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
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				geoStone,crystal
				
		);
	}

	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				geoStone.createItemBlock(),
				crystal.createItemBlock()
		); 

	}

	public static void registerModels() {
		geoStone.registerItemModel(Item.getItemFromBlock(geoStone));
		crystal.registerItemModel(Item.getItemFromBlock(crystal));
	}

}