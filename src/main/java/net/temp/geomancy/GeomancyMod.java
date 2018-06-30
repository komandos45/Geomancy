package net.temp.geomancy;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.temp.geomancy.blocks.ModBlocks;
import net.temp.geomancy.creative.BlockTab;
import net.temp.geomancy.creative.ItemTab;
import net.temp.geomancy.items.ModItems;
import net.temp.geomancy.proxy.CommonProxy;
import net.temp.geomancy.world.ModWorldOreGeneration;
import net.temp.geomancy.world.ModWorldStoneGeneration;


@Mod(modid = GeomancyMod.modId, name = GeomancyMod.name, version = GeomancyMod.version, acceptedMinecraftVersions = "[1.12.2]")
public class GeomancyMod {

	public static final String modId = "geomancy";
	public static final String name = "Geomancy";
	public static final String version = "0.0.1";

	@Mod.Instance(modId)
	public static GeomancyMod instance;
	
	@SidedProxy(serverSide = "net.temp.geomancy.proxy.CommonProxy", clientSide = "net.temp.geomancy.proxy.ClientProxy")
	public static CommonProxy proxy;
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		@SubscribeEvent
		public static void registerItems(RegistryEvent.Register<Item> event) {
			ModItems.register(event.getRegistry());
			ModBlocks.registerItemBlocks(event.getRegistry());
		}
		@SubscribeEvent
		public static void registerItems(ModelRegistryEvent event) {
			ModItems.registerModels();
			ModBlocks.registerModels();
		}
		
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) {
			ModBlocks.register(event.getRegistry());
		}

	}
	
	public static final ItemTab itemCreativeTab = new ItemTab();
	public static final BlockTab blockCreativeTab = new BlockTab();
	
	
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(name + " is loading!");
		GameRegistry.registerWorldGenerator(new ModWorldStoneGeneration(), 3);
		//GameRegistry.registerWorldGenerator(new ModWorldOreGeneration(), 4);
	
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

}