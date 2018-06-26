package net.temp.geomancy.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;

public class Blocks {

	//Block declaration
	public static BlockOre GeoStone = new BlockOre("Geo_Stone");
	
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				GeoStone
		);
	}

	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				GeoStone.createItemBlock()
		); 

	}

	public static void registerModels() {
		GeoStone.registerItemModel(Item.getItemFromBlock(GeoStone));

	}

}