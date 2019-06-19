package net.dottsg.hardcoreban.listeners;

import net.dottsg.hardcoreban.util.PlayerUtil;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;

public class RightClickListener implements Listener{

    @EventHandler
    public void onClick(PlayerInteractEvent e)
    {
        Player p = e.getPlayer();
        if ((e.getItem() == null) || (e.getItem().getType() != Material.PAPER) || (!e.getItem().getItemMeta().isUnbreakable())) return;

        if(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()<=15)
        {
            PlayerUtil.restoreHealth(p, 5);
            ItemStack item = e.getItem();
            item.setAmount(item.getAmount()-1);
            System.out.println(item.toString() + ": " + item.getAmount());
            if(e.getHand()== EquipmentSlot.HAND)
            {
                if(item.getAmount()<=0)
                {
                    p.getInventory().setItemInMainHand(null);
                }else{
                    p.getInventory().setItemInMainHand(item);
                }

            }else{
                if(item.getAmount()<=0)
                {
                    p.getInventory().setItemInOffHand(null);
                }else{
                    p.getInventory().setItemInOffHand(item);
                }

            }
        }
    }
}
