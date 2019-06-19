package net.dottsg.hardcoreban.commands;

import net.dottsg.hardcoreban.util.PlayerUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;

public class CommandFullRestore implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length > 0 && args[0] != null) {
            if (getServer().getPlayer(args[0]) != null) {
                Player p = getServer().getPlayer(args[0]);
                PlayerUtil.fullRestore(p);
            } else {
                sender.sendMessage(ChatColor.RED + "Could Not Find That Player: " + args[0]);
                return false;
            }
        } else {
            if (sender instanceof Player) {
                Player p = (Player) sender;
                PlayerUtil.fullRestore(p);
            } else {
                sender.sendMessage(ChatColor.RED + "You need to select a player to restore!");
                return false;
            }
        }
        // If the player (or console) uses our command correct, we can return true
        return true;
    }
}
