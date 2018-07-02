package net.temp.geomancy.mana;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.temp.geomancy.GeomancyMod;

public class CapabilityHandler {

	public static final ResourceLocation MANA_CAP = new ResourceLocation(GeomancyMod.modId, "mana");

	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent.Entity event)
	{
	if (!(event.getEntity() instanceof EntityPlayer)) return;

	event.addCapability(MANA_CAP, new GeoManaProvider()); 
}
