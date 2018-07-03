package net.temp.geomancy.mana;


import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;

public class EventHandler
{
    @SubscribeEvent
    public void onPlayerLogsIn(PlayerLoggedInEvent event)
    {
        EntityPlayer player = event.player;
        IGeoMana mana = player.getCapability(GeoManaProvider.MANA_CAP, null);

        String message = String.format("Hello there, you have §7%d§r mana left.", (int) mana.getGeoMana());
        player.sendMessage(new TextComponentString(message));
    }

    @SubscribeEvent
    public void onPlayerSleep(PlayerSleepInBedEvent event)
    {
        EntityPlayer player = event.getEntityPlayer();

        if (player.world.isRemote) return;

        IGeoMana mana = player.getCapability(GeoManaProvider.MANA_CAP, null);

        mana.fill(50);

        String message = String.format("You refreshed yourself in the bed. You received 50 mana, you have §7%d§r mana left.", (int) mana.getGeoMana());
        player.sendMessage(new TextComponentString(message));
    }

    @SubscribeEvent
    public void onPlayerFalls(LivingFallEvent event)
    {
        Entity entity = event.getEntity();

        if (entity.world.isRemote || !(entity instanceof EntityPlayerMP) || event.getDistance() < 3) return;

        EntityPlayer player = (EntityPlayer) entity;
        IGeoMana mana = player.getCapability(GeoManaProvider.MANA_CAP, null);

        float points = mana.getGeoMana();
        float cost = event.getDistance() * 3;

        if (points > cost)
        {
            mana.consume(cost);

            String message = String.format("You absorbed fall damage. It costed §7%d§r mana, you have §7%d§r mana left.", (int) cost, (int) mana.getGeoMana());
            player.sendMessage(new TextComponentString(message));

            event.setCanceled(true);
        }
    }

    /**
     * Copy data from dead player to the new player
     */
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event)
    {
        EntityPlayer player = event.getEntityPlayer();
        IGeoMana mana = player.getCapability(GeoManaProvider.MANA_CAP, null);
        IGeoMana oldMana = event.getOriginal().getCapability(GeoManaProvider.MANA_CAP, null);

        mana.set(oldMana.getGeoMana());
    }
}