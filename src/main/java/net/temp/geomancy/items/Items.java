package net.temp.geomancy.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class Items {

	//Item declarations
	public static ItemBase template = new ItemBase("template").setCreativeTab(CreativeTabs.MATERIALS);
	//Item registrations
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				template
				);
	}
	
	//Model registrations
	public static void registerModels() {
		template.registerItemModel();
	}

}
