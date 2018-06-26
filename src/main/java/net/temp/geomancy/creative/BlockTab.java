package net.temp.geomancy.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.temp.geomancy.GeomancyMod;
import net.temp.geomancy.blocks.ModBlocks;

public class BlockTab extends CreativeTabs {

	public BlockTab() {
		super(GeomancyMod.modId+1);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ModBlocks.geoStone);
	}

}
