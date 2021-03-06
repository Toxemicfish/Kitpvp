package me.toxemicfish.kitpvp.kits;

import me.toxemicfish.kitpvp.Main;

import me.toxemicfish.kitpvp.utils.chatManager;
import me.toxemicfish.kitpvp.utils.itemStackBuilder;
import me.toxemicfish.kitpvp.utils.potionStackBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionType;

public class knight {

    private Main plugin;

    public knight(Main plugin) {
        this.plugin = plugin;
    }

    private String kitName = "Knight";

    private boolean isActive;
    private long cooldown;


    // Kit items name
    private String swordName = chatManager.color("&7[&eKnight&7] &6Sword");
    private String goldenAppleName = chatManager.color("&7[&eKnight&7] &6Golden Apple");
    private String enderPearlName = chatManager.color("&7[&eKnight&7] &6Ender Pearl");
    private String helmetName = chatManager.color("&7[&eKnight&7] &6Helmet");
    private String chestplateName = chatManager.color("&7[&eKnight&7] &6Chestplate");
    private String leggingsName = chatManager.color("&7[&eKnight&7] &6Leggings");
    private String bootsName = chatManager.color("&7[&eKnight&7] &6Boots");

    private String speedName = chatManager.color("&7[&eKnight&7] &6Speed 3");
    private String instHealName = chatManager.color("&7[&eKnight&7] &6Instant Heal");
    private String regenName = chatManager.color("&7[&eKnight&7] &6Regen");

    public void kit(Player player, String activeMessage) {

        Inventory inv = player.getInventory();
        inv.clear();
        player.getInventory().setHelmet(new itemStackBuilder(Material.IRON_HELMET).withName(helmetName).withLore("&7[&eKnight Kit&7]").withEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).withEnchantment(Enchantment.DURABILITY, 4).build());
        player.getInventory().setChestplate(new itemStackBuilder(Material.IRON_CHESTPLATE).withName(chestplateName).withLore("&7[&eKnight Kit&7]").withEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).withEnchantment(Enchantment.DURABILITY, 4).build());
        player.getInventory().setLeggings(new itemStackBuilder(Material.IRON_LEGGINGS).withName(leggingsName).withLore("&7[&eKnight Kit&7]").withEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).withEnchantment(Enchantment.DURABILITY, 4).build());
        player.getInventory().setBoots(new itemStackBuilder(Material.IRON_BOOTS).withName(bootsName).withLore("&7[&eKnight Kit&7]").withEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 2).withEnchantment(Enchantment.DURABILITY, 4).withEnchantment(Enchantment.PROTECTION_FALL, 4).build());

        inv.setItem(0, new itemStackBuilder(Material.DIAMOND_SWORD).withName(swordName).withLore("&7[&eKnight Kit&7]").withLore("&eDamage&7- null").withLore("&eDurability&7- null").withEnchantment(Enchantment.DAMAGE_ALL, 3).withEnchantment(Enchantment.DURABILITY, 4).hideEnchantment().hideAttributes().build());
        inv.setItem(1, new itemStackBuilder(Material.GOLDEN_APPLE).withAmount(6).withName(goldenAppleName).withLore("&7[&eKnight Kit&7]").build());
        inv.setItem(2, new itemStackBuilder(Material.ENDER_PEARL).withAmount(16).withName(enderPearlName).withLore("&7[&eKnight Kit&7]").build());

        inv.setItem(3, new potionStackBuilder(PotionType.SPEED).withName(speedName).isExtendedDuration().build());
        inv.setItem(4, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(5, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(6, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(7, new potionStackBuilder(PotionType.REGEN).withName(regenName).isSpalsh().build());
        inv.setItem(8, new potionStackBuilder(PotionType.REGEN).withName(regenName).isSpalsh().build());
        inv.setItem(9, new itemStackBuilder(Material.ENDER_PEARL).withAmount(16).withName(enderPearlName).withLore("&7[&eKnight Kit&7]").build());
        inv.setItem(10, new potionStackBuilder(PotionType.REGEN).withName(regenName).isSpalsh().build());
        inv.setItem(11, new potionStackBuilder(PotionType.REGEN).withName(regenName).isSpalsh().build());
        inv.setItem(12, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(13, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(14, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(15, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(16, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(17, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(18, new potionStackBuilder(PotionType.SPEED).withName(speedName).isExtendedDuration().build());
        inv.setItem(19, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(20, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(21, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(22, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(23, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(24, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(25, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(26, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(27, new potionStackBuilder(PotionType.SPEED).withName(speedName).isExtendedDuration().build());
        inv.setItem(28, new potionStackBuilder(PotionType.SPEED).withName(speedName).isExtendedDuration().build());
        inv.setItem(29, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(30, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(31, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(32, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(33, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(34, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        inv.setItem(35, new potionStackBuilder(PotionType.INSTANT_HEAL).withName(instHealName).isSpalsh().build());
        player.sendMessage(chatManager.color(activeMessage));
    }

    // Function to give a player a kit
    // Function to give a player a kit
    public void giveKit(Player player) {
        if (plugin.kitActive.contains(player.getUniqueId())) {
            player.sendMessage(chatManager.color("&aYou already have a kit active!"));
            return;
        }
        kit(player, "&a" + kitName + " &aKit is now active!");
        plugin.kitActive.add(player.getUniqueId());
    }

    public String getKitName() {
        return kitName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}