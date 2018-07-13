package me.toxemicfish.kitpvp.commands;

import me.toxemicfish.kitpvp.Main;
import me.toxemicfish.kitpvp.utils.chatManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class coins implements CommandExecutor {

    Main plugin = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if(!plugin.getSqlSetterGetter().playerExists(p.getUniqueId())) {
                plugin.getSqlSetterGetter().createPlayer(p.getUniqueId(), p);
             return true;
            }
            p.sendMessage(chatManager.color("&aCoins&7: &e" + plugin.getSqlSetterGetter().getCoins(p.getUniqueId())));
        } else {
            chatManager.playerOnly(sender);
        }
        return true;
    }

}
