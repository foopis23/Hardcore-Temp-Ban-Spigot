package net.dottsg.hardcoreban;

import net.dottsg.hardcoreban.commands.*;
import net.dottsg.hardcoreban.listeners.DeathListener;
import net.dottsg.hardcoreban.listeners.RespawnListener;
import net.dottsg.hardcoreban.listeners.RightClickListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class HardcoreBan extends JavaPlugin
{
    @Override
    public void onEnable() {
        // Plugin startup login
        System.out.println("[HardcoreBan]: Starting up");
        System.out.println("[HardcoreBan]: Creating Recipes");
        Recipes.createRecipies(this);
        System.out.println("[HardcoreBan]: Registering Events");
        BanAPI banAPI = new BanAPI();
        getServer().getPluginManager().registerEvents(new DeathListener(),this);
        getServer().getPluginManager().registerEvents(new RightClickListener(), this);
        getServer().getPluginManager().registerEvents(new RespawnListener(this, banAPI), this);
        System.out.println("[HardcoreBan]: Registering Commands");
        this.getCommand("restore").setExecutor(new CommandRestore());
        this.getCommand("fullrestore").setExecutor(new CommandFullRestore());
        this.getCommand("removeban").setExecutor(new CommandRemoveBan(banAPI));
        this.getCommand("removehealth").setExecutor(new CommandRemoveHealth());
        this.getCommand("givecoupon").setExecutor(new CommandGiveCoupon());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[HardcoreBan]: Shutting Down");
    }
}