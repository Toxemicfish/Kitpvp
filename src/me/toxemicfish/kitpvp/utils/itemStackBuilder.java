package me.toxemicfish.kitpvp.utils;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class itemStackBuilder {

    private final ItemStack ITEM_STACK;

    public itemStackBuilder(Material mat) {
        this.ITEM_STACK = new ItemStack(mat);
    }

    public itemStackBuilder(ItemStack item) {
        this.ITEM_STACK = item;
    }

    public itemStackBuilder withAmount(int amount) {
        ITEM_STACK.setAmount(amount);
        return this;
    }

    public itemStackBuilder withName(String name) {
        final ItemMeta meta = ITEM_STACK.getItemMeta();
        meta.setDisplayName(chatManager.color(name));
        ITEM_STACK.setItemMeta(meta);
        return this;
    }

    public itemStackBuilder withLore(String name) {
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

    public itemStackBuilder withDurability(int durability) {
        ITEM_STACK.setDurability((short) durability);
        return this;
    }

    public itemStackBuilder withData(int data) {
        ITEM_STACK.setDurability((short) data);
        return this;
    }

    public itemStackBuilder withEnchantment(Enchantment enchantment, final int level) {
        ITEM_STACK.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public itemStackBuilder withEnchantment(Enchantment enchantment) {
        ITEM_STACK.addUnsafeEnchantment(enchantment, 1);
        return this;
    }

    public itemStackBuilder withType(Material material) {
        ITEM_STACK.setType(material);
        return this;
    }

    public itemStackBuilder clearLore() {
        final ItemMeta meta = ITEM_STACK.getItemMeta();
        meta.setLore(new ArrayList<String>());
        ITEM_STACK.setItemMeta(meta);
        return this;
    }

    public itemStackBuilder clearEnchantments() {
        for (Enchantment enchantment : ITEM_STACK.getEnchantments().keySet()) {
            ITEM_STACK.removeEnchantment(enchantment);
        }
        return this;
    }

    public itemStackBuilder withColor(Color color) {
        Material type = ITEM_STACK.getType();
        if (type == Material.LEATHER_BOOTS || type == Material.LEATHER_CHESTPLATE || type == Material.LEATHER_HELMET || type == Material.LEATHER_LEGGINGS) {
            LeatherArmorMeta meta = (LeatherArmorMeta) ITEM_STACK.getItemMeta();
            meta.setColor(color);
            ITEM_STACK.setItemMeta(meta);
            return this;
        } else {
            throw new IllegalArgumentException("withColor is only applicable for leather armor!");
        }
    }

    public itemStackBuilder hideEnchantment() {
        final ItemMeta meta = ITEM_STACK.getItemMeta();
        meta.hasItemFlag(ItemFlag.HIDE_ENCHANTS);
        ITEM_STACK.setItemMeta(meta);
        return this;
    }

    public itemStackBuilder hideAttributes() {
        final ItemMeta meta = ITEM_STACK.getItemMeta();
        meta.hasItemFlag(ItemFlag.HIDE_ATTRIBUTES);
        ITEM_STACK.setItemMeta(meta);
        return this;
    }

    public ItemStack build() {
        return ITEM_STACK;
    }
}
