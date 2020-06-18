package kr.l1npengtul.l6ench;

import org.bukkit.event.Listener;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.*;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.*;


public class events implements Listener {
    @EventHandler
    public void onItemRightClickEvent(PlayerInteractEvent e){
        try {
            if (e.getItem() != null && e.getHand() != null) {
                if (e.getHand() == EquipmentSlot.HAND) {
                    ItemStack mainHandItem = e.getItem();
                    ItemMeta itemMeta = mainHandItem.getItemMeta();
                    List<String> lore = itemMeta.getLore();
                    if (lore.toString().equalsIgnoreCase("[Special]") && (mainHandItem.getType() == Material.ENCHANTED_BOOK)) {
                        ItemStack otherHandItem = e.getPlayer().getInventory().getItemInOffHand();
                        Map<Enchantment, Integer> bookEnchantments = itemMeta.getEnchants();
                        otherHandItem.addUnsafeEnchantments(bookEnchantments);
                        ArrayList<String> lore_1 = new ArrayList<String>();
                        lore_1.add("Broken!");
                        itemMeta.setLore(lore_1);
                        mainHandItem.setType(Material.DIRT);
                        mainHandItem.setItemMeta(itemMeta);
                    }
                }
            }
        }
        catch (NullPointerException nptr){
            assert true;
        }
    }

    @EventHandler
    public void ItemCraftedEvent(CraftItemEvent event) {
        ItemStack craftedItem = event.getCurrentItem();
        if (Objects.requireNonNull(craftedItem).getType() == Material.ENCHANTED_BOOK && Objects.requireNonNull(Objects.requireNonNull(craftedItem.getItemMeta()).getLore()).contains("Special. Craft one at a time!")) {
            boolean enchanted = false;
            Random rand = new Random();
            ItemStack l6book = new ItemStack(Material.ENCHANTED_BOOK);
            ItemMeta meta = l6book.getItemMeta();
            assert meta != null;
            meta.setDisplayName("Expert's Book");
            ArrayList<String> lore = new ArrayList<String>();
            lore.add("Special");
            meta.setLore(lore);
            l6book.setItemMeta(meta);

            while (!enchanted) {
                int numberRandom = rand.nextInt(5);
                try {
                    if (numberRandom == 0) {
                        l6book.addUnsafeEnchantment(Enchantment.DIG_SPEED, 6);
                        enchanted = true;
                    }
                    if (numberRandom == 1) {
                        l6book.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 6);
                        enchanted = true;
                    }
                    if (numberRandom == 2) {
                        l6book.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 6);
                        enchanted = true;
                    }
                    if (numberRandom == 3) {
                        l6book.addUnsafeEnchantment(Enchantment.DURABILITY, 4);
                        enchanted = true;
                    }
                    if (numberRandom == 4) {
                        l6book.addUnsafeEnchantment(Enchantment.THORNS, 4);
                        enchanted = true;
                    }
                    if (numberRandom == 5) {
                        l6book.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 5);
                        enchanted = true;
                    }
                } catch (IllegalArgumentException e) {
                    Bukkit.getServer().getLogger().info("Illegal Argument Exception");
                }

                event.setCurrentItem(l6book);
            }
        }
    }
}


