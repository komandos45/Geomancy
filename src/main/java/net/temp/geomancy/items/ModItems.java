package net.temp.geomancy.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {

	
	//Item declarations
	public static ItemBase blackGem = new ItemBase("black_gem");
	public static ItemBase blueGem = new ItemBase("blue_gem");
	public static ItemBase greenGem = new ItemBase("green_gem");
	public static ItemBase prismStone = new ItemBase("prism_stone");
	public static ItemBase redGem = new ItemBase("red_gem");
	public static ItemBase yellowGem = new ItemBase("yellow_gem");
	
	
	//Item registrations
	public static void register(IForgeRegistry<Item> registry) {
		registry.registerAll(
				blackGem,
				blueGem,
				greenGem,
				prismStone,
				redGem,
				yellowGem
				);
	}
	
	//Model registrations
	public static void registerModels() {
		blackGem.registerItemModel();
		blueGem.registerItemModel();
		greenGem.registerItemModel();
		prismStone.registerItemModel();
		redGem.registerItemModel();
		yellowGem.registerItemModel();
	}

}
