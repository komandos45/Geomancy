package net.temp.geomancy.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class Items {

	
	//Item declarations
	public static ItemBase itemTemplate = new ItemBase("item_template").setCreativeTab(CreativeTabs.MATERIALS);
	
	
	//Item registrations
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				itemTemplate
				);
	}
	
	//Model registrations
	public static void registerModels() {
		itemTemplate.registerItemModel();
	}

}
