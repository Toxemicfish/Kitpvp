package me.toxemicfish.kitpvp.commands;

import me.toxemicfish.kitpvp.utils.chatManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class pKit implements CommandExecutor {

    Inventory inv;



   // public static Inventory gui = Bukkit.createInventory("null", 9, "Personal Kit");

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

        } else {
            chatManager.playerOnly(sender);
        }
        return true;
    }
}
