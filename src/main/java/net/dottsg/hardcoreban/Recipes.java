package net.dottsg.hardcoreban;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Recipes
{
    public static void createRecipies(JavaPlugin plugin)
    {
        ItemStack item = new ItemStack(Material.PAPER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "Life Coupon");
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        NamespacedKey key = new NamespacedKey(plugin, "life_crystal");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape("GGG", "GEG", "DDD");
        recipe.setIngredient('G', Material.GOLD_INGOT);
        recipe.setIngredient('E', Material.END_CRYSTAL);
        recipe.setIngredient('D', Material.DIAMOND);
        Bukkit.addRecipe(recipe);
    }
}
