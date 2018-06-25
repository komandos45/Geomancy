package net.temp.geomancy.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.temp.geomancy.items.ItemBase;


public abstract class CommonProxy {


  public void preInit()
  {
	  
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