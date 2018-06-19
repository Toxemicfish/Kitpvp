package me.toxemicfish.kitpvp.utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class potionStackBuilder {

    private final ItemStack ITEM_STACK;
    private final Potion POTION;

    public potionStackBuilder(PotionType type) {
        this.POTION = new Potion(type);
        ITEM_STACK = new ItemStack(Material.POTION);
    }

    public potionStackBuilder(ItemStack item, Potion potion) {
        this.ITEM_STACK = item;
        POTION = potion;
    }

    public potionStackBuilder withAmount(int amount) {
        ITEM_STACK.setAmount(amount);
        return this;
    }

    public potionStackBuilder withName(String name) {
        final ItemMeta meta = ITEM_STACK.getItemMeta();
        meta.setDisplayName(chatManager.color(name));
        ITEM_STACK.setItemMeta(meta);
        return this;
    }

    public potionStackBuilder withLore(String name) {
        final ItemMeta meta = ITEM_STACK.getItemMeta();
        List<String> lore = meta.getLore();
        if (lore == null) {
            lore = new ArrayList<>();
        }
        lore.add(chatManager.color(name));
        meta.setLore(lore);
        ITEM_STACK.setItemMeta(meta);
        return this;
    }

    public potionStackBuilder withDurability(int durability) {
        ITEM_STACK.setDurability((short) durability);
        return this;
    }

    public potionStackBuilder withData(int data) {
        ITEM_STACK.setDurability((short) data);
        return this;
    }

    public potionStackBuilder withType(Material material) {
        ITEM_STACK.setType(material);
        return this;
    }

    public potionStackBuilder clearLore() {
        final ItemMeta meta = ITEM_STACK.getItemMeta();
        meta.setLore(new ArrayList<String>());
        ITEM_STACK.setItemMeta(meta);
        return this;
    }

    public potionStackBuilder isSpalsh() {
        POTION.setSplash(true);
        return this;
    }

    public potionStackBuilder isExtendedDuration() {
        POTION.setHasExtendedDuration(true);
        return this;
    }

    public potionStackBuilder setLevel(int level) {
        POTION.setLevel(level);
        return this;
    }

    public ItemStack build() {
        POTION.apply(ITEM_STACK);
        return ITEM_STACK;
    }
}
