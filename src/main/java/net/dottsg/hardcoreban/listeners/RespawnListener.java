package net.dottsg.hardcoreban.listeners;

import net.dottsg.hardcoreban.BanAPI;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.plugin.Plugin;

public class RespawnListener implements Listener
{
    private Plugin plugin;
    private BanAPI banAPI;

    public RespawnListener(Plugin plugin, BanAPI banAPI)
    {
        this.plugin = plugin;
        this.banAPI = banAPI;
    }

    @EventHandler
    public void onClick(PlayerRespawnEvent e)
    {
        Player player = e.getPlayer();

        if(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()<=1) {
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
            banAPI.addBan(player.getName(), plugin.getServer().getConsoleSender(), "4:h", "Your Max Health is Zero! 4 Hour Temporary Ban is now in place!");
            player.kickPlayer("Your Max Health is Zero! 4 Hour Temporary Ban is now in place!");
        }
    }
}