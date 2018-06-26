package net.temp.geomancy.creative;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.temp.geomancy.GeomancyMod;
import net.temp.geomancy.items.Items;

public class ItemTab extends CreativeTabs {

	public ItemTab() {
		super(GeomancyMod.modId);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Items.blackGem);
	}

}
