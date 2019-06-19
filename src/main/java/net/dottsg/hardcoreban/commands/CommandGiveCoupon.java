package net.dottsg.hardcoreban.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.bukkit.Bukkit.getServer;

public class CommandGiveCoupon implements CommandExecutor
{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Life Coupon");
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        Player p;

        if (args.length>1)
        {
            if (getServer().getPlayer(args[1]) != null)
            {
                p = getServer().getPlayer(args[1]);
                try
                {
                    int amount = Integer.parseInt(args[0]);
                    item.setAmount(amount);
                }catch(NumberFormatException | NullPointerException nfe)
                {
                    sender.sendMessage(ChatColor.RED + "Invalid Argument!");
                    return false;
                }
            }else{
                sender.sendMessage(ChatColor.RED + "Could Not Find Player: "+args[1]);
                return false;
            }
        }else if (args.length>0)
        {
            try
            {
                int amount = Integer.parseInt(args[0]);
                item.setAmount(amount);
                if(sender instanceof Player)
                {
                    p = (Player) sender;
                }else{
                    sender.sendMessage(ChatColor.RED + "No Player Selected!");
                    return false;
                }
            }catch(NumberFormatException | NullPointerException nfe)
            {
                if (getServer().getPlayer(args[0]) != null) {
                    p = getServer().getPlayer(args[0]);
                }else{
                    sender.sendMessage(ChatColor.RED + "Invalid Argument!");
                    return false;
                }
            }
        }else{
            if(sender instanceof Player)
            {
                p = (Player) sender;
            }else{
                sender.sendMessage(ChatColor.RED + "No Player Selected!");
                return false;
            }
        }

        p.getInventory().addItem(item);

        return true;
    }
}
