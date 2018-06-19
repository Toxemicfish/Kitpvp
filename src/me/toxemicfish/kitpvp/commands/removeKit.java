package me.toxemicfish.kitpvp.commands;

import me.toxemicfish.kitpvp.Main;
import me.toxemicfish.kitpvp.kits.knight;
import me.toxemicfish.kitpvp.utils.chatManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class removeKit implements CommandExecutor {

    Main plugin = Main.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (plugin.kitActive.containsKey(player.getUniqueId())) {
                plugin.kitActive.remove(player.getUniqueId());
                player.getInventory().clear();
                player.getInventory().setArmorContents(null);
                player.removePotionEffect(PotionEffectType.REGENERATION);
                player.removePotionEffect(PotionEffectType.SPEED);
                player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
                player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
                player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
                player.removePotionEffect(PotionEffectType.JUMP);
                player.sendMessage(chatManager.color("&aKit removed &e" + plugin.kitActive.values().toString().replace(player.getUniqueId().toString(), "")));
                return true;
            } else {
                player.sendMessage(chatManager.color("&aYou currently have no kit active."));
            }
        } else {
            chatManager.playerOnly(sender);
        }
        return true;
    }

}
