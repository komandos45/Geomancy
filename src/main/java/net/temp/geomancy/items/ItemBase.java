package net.temp.geomancy.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.temp.geomancy.GeomancyMod;;

public class ItemBase extends Item {

	protected String name;

	public ItemBase(String name) {
		this.name = name;
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(GeomancyMod.itemCreativeTab);
	}
	
	public void registerItemModel() {
		GeomancyMod.proxy.registerItemRenderer(this, 0, name);
	}
	
	@Override
	public ItemBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

}