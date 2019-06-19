package net.dottsg.hardcoreban.commands;

import net.dottsg.hardcoreban.BanAPI;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandRemoveBan implements CommandExecutor
{
    BanAPI banAPI;

    public CommandRemoveBan(BanAPI banAPI)
    {
        this.banAPI = banAPI;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if (args.length > 0 && args[0] != null) {
            banAPI.unban(args[0]);
        } else {
            sender.sendMessage(ChatColor.RED + "You need to select a player!");
            return false;
        }

        return true;
    }
}
