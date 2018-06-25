package net.temp.geomancy.blocks;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.registries.IForgeRegistry;

public class Blocks {

	//Block declaration
	public static BlockOre blockTemplate = new BlockOre("block_template").setCreativeTab(CreativeTabs.MATERIALS);
	
	public static void register(IForgeRegistry<Block> registry) {
		registry.registerAll(
				blockTemplate
		);
	}

	public static void registerItemBlocks(IForgeRegistry<Item> registry) {
		registry.registerAll(
				blockTemplate.createItemBlock()
		);

	}

	public static void registerModels() {
		blockTemplate.registerItemModel(Item.getItemFromBlock(blockTemplate));

	}

}