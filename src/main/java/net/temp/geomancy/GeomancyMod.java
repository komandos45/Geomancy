package net.temp.geomancy;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.temp.geomancy.items.Items;
import net.temp.geomancy.proxy.CommonProxy;


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
			Items.register(event.getRegistry());
		}
		@SubscribeEvent
		public static void registerItems(ModelRegistryEvent event) {
			Items.registerModels();
		}

	}
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		System.out.println(name + " is loading!");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {

	}

}