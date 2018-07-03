package net.temp.geomancy.mana;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.temp.geomancy.GeomancyMod;
import net.temp.geomancy.mana.GeoEventHandler;
import net.minecraftforge.event.entity.EntityEvent;

public class CapabilityHandler {

	public static final ResourceLocation MANA_CAP = new ResourceLocation(GeomancyMod.modId, "mana");

	private void EventHandler()
	{

	}
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> entityEvent)
	{
        if (!(entityEvent.getObject() instanceof EntityPlayer)) return;

        entityEvent.addCapability(MANA_CAP, new GeoManaProvider());
    }
}