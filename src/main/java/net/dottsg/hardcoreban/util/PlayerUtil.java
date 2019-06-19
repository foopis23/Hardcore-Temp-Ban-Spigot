package net.dottsg.hardcoreban.util;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PlayerUtil
{
    public static void restoreHealth(Player p, int amount)
    {
        if(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()<=20-amount) {
            p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(
                    p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue() + amount
            );
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 125, 1));
        }
    }

    public static void fullRestore(Player p)
    {
        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
        p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
    }

    public static void removeHealth(Player p, int amount)
    {
        p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(
                p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()-amount
        );

        if(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()<=0) {
            p.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(1);
        }
    }
}