package kr.l1npengtul.l6ench;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.*;


public class LevelSix extends JavaPlugin{
    public LevelSix(){

    }

    @Override
    public void onEnable(){
        Bukkit.getServer().getPluginManager().registerEvents(new events(), this);
        //enchanted gapple

        ItemStack enchapple  = new ItemStack(Material.ENCHANTED_GOLDEN_APPLE);

        NamespacedKey key = new NamespacedKey(this, "ENCH_APPLE");
        ShapedRecipe recipe = new ShapedRecipe(key, enchapple);
        recipe.shape("ggg", "gag", "ggg");
        recipe.setIngredient('g', Material.GOLD_BLOCK);
        recipe.setIngredient('a', Material.APPLE);

        Bukkit.addRecipe(recipe);
        this.getLogger().info("Recipe Added!, Ench Gapple!");

        //Expert Seal

        ItemStack ExpertSeal  = new ItemStack(Material.ENCHANTED_BOOK);
        ItemMeta meta = ExpertSeal.getItemMeta();
        assert meta != null;
        meta.setDisplayName("Expert's Star");
        ArrayList<String> lore = new ArrayList<String>();
        lore.add("Special. Craft one at a time!");
        meta.setLore(lore);
        ExpertSeal.setItemMeta(meta);

        NamespacedKey key1 = new NamespacedKey(this, "EXPERT_SEAL");
        ShapedRecipe recipe1 = new ShapedRecipe(key1, ExpertSeal);
        recipe1.shape("dbd", "gsg", "dtd");
        recipe1.setIngredient('d', Material.DIAMOND_BLOCK);
        recipe1.setIngredient('b', Material.EXPERIENCE_BOTTLE);
        recipe1.setIngredient('g', Material.ENCHANTED_GOLDEN_APPLE);
        recipe1.setIngredient('s', Material.NETHER_STAR);
        recipe1.setIngredient('t', Material.ENCHANTING_TABLE);

        Bukkit.addRecipe(recipe1);

        //


        this.getLogger().info("Recipe Added!, Expert Seal!");

    }
    @Override
    public void onDisable(){
        this.getLogger().info("Level 5 again...");
    }
}

