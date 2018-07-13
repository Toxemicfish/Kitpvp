package me.toxemicfish.kitpvp.commands;

import me.toxemicfish.kitpvp.Main;
import me.toxemicfish.kitpvp.utils.chatManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setKit implements CommandExecutor{

    Main plugin = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;

            if(args.length == 0) {
                p.sendMessage(chatManager.color("&aUsage: /kit <kitName>"));
                p.sendMessage(chatManager.color("&7--&aKit Names&7--"));
                p.sendMessage(chatManager.color("&7- &eknight"));
                p.sendMessage(chatManager.color("&7- &earcher"));
                return true;
            }

            if(args[0].equalsIgnoreCase("knight")) {
                plugin.getKitKnight().giveKit(p);
                return true;
            } else if(args[0].equalsIgnoreCase("archer")) {
                plugin.getKitArcher().giveKit(p);
                return true;
            }
            else {
                p.sendMessage(chatManager.color("&aSilly that is not a kit!"));
            }

        } else {
            chatManager.playerOnly(sender);
        }
        return true;
    }
}
