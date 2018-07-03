package net.temp.geomancy.proxy;

import java.beans.EventHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.temp.geomancy.items.ItemBase;
import net.temp.geomancy.mana.CapabilityHandler;
import net.temp.geomancy.mana.GeoMana;
import net.temp.geomancy.mana.GeoManaStorage;
import net.temp.geomancy.mana.IGeoMana;


public abstract class CommonProxy {


  public void preInit()
  {
	  CapabilityManager.INSTANCE.register(IGeoMana.class, new GeoManaStorage(), GeoMana.class);

      MinecraftForge.EVENT_BUS.register(new CapabilityHandler());
      MinecraftForge.EVENT_BUS.register(new EventHandler(null, null, null, null));
  
  }


  public void init()
  {
	
      
  }

  public void postInit()
  {
	
  }

  abstract public boolean playerIsInCreativeMode(EntityPlayer player);


  abstract public boolean isDedicatedServer();

  public void registerItemRenderer(Item item, int i, String name) {
	
  }
}