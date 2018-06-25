package net.temp.geomancy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = GeomancyMod.modId, name = GeomancyMod.name, version = GeomancyMod.version, acceptedMinecraftVersions = "[1.12.2]")
public class GeomancyMod {

	public static final String modId = "geomancy";
	public static final String name = "Geomancy";
	public static final String version = "0.0.1";

	@Mod.Instance(modId)
	public static GeomancyMod instance;

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