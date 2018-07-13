package me.toxemicfish.kitpvp.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class chatManager {

    private static String prefix = "§7[§eKitpvp§6] §f";
    private static String warn = "§7[§c!§7] §f";

    public static String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }

    public static void goodConsole(String message) {
        Bukkit.getServer().getConsoleSender().sendMessage(prefix + ChatColor.GREEN + " ✔ " + message);
    }

    public static void badConsole(String message) {
        Bukkit.getServer().getConsoleSender().sendMessage(prefix + ChatColor.RED + message);
    }

    public static void infoConsole(String message) {
        Bukkit.getServer().getConsoleSender().sendMessage(prefix + ChatColor.YELLOW + message);
    }

    public static void warnConsole(String message) {
        Bukkit.getServer().getConsoleSender().sendMessage(prefix + warn + ChatColor.RED + message);
    }

    public static void playerOnly(CommandSender sender) {
        sender.sendMessage(prefix + ChatColor.RED + "Player only command!");
    }

    public static void consoleOnly(Player player) {
        player.sendMessage(prefix + ChatColor.RED + "Console only command!");
    }

    public static String getPrefix() {
        return prefix;
    }

    public static String getWarn() {
        return warn;
    }
}
