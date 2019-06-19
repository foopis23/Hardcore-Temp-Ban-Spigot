package net.dottsg.hardcoreban.listeners;

import net.dottsg.hardcoreban.util.PlayerUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathListener implements Listener
{
    @EventHandler
    public void onDeath(PlayerDeathEvent e)
    {
        Player player = e.getEntity();
        PlayerUtil.removeHealth(player,5);
    }
}