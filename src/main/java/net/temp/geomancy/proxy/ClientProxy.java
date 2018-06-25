package net.temp.geomancy.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.temp.geomancy.GeomancyMod;

public class ClientProxy extends CommonProxy
{

  public void preInit()
  {
    super.preInit();
   
  }

  public void init()
  {
    super.init();
   
  }

  public void postInit()
  {
    super.postInit();
    
  }

  @Override
  public void registerItemRenderer(Item item, int meta, String id) {
  	ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(GeomancyMod.modId + ":" + id, "inventory"));
  }
  
  @Override
  public boolean playerIsInCreativeMode(EntityPlayer player) {
    if (player instanceof EntityPlayerMP) {
      EntityPlayerMP entityPlayerMP = (EntityPlayerMP)player;
      return entityPlayerMP.interactionManager.isCreative();
    } else if (player instanceof EntityPlayerSP) {
      return Minecraft.getMinecraft().playerController.isInCreativeMode();
    }
    return false;
  }

  @Override
  public boolean isDedicatedServer() {return false;}

}