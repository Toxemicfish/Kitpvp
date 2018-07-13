package me.toxemicfish.kitpvp.events;

import me.toxemicfish.kitpvp.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class joinEvent implements Listener {

    Main plugin = Main.getInstance();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = (Player) event.getPlayer();
        UUID uuid = player.getUniqueId();
        if (plugin.getSqlSetterGetter().playerExists(player.getUniqueId())) {
            return;
        }
        plugin.getSqlSetterGetter().createPlayer(player.getUniqueId(), player);
        plugin.getpBoard().playerStats(player, plugin.getSqlSetterGetter().getCoins(uuid), "Null", plugin.getrManager().getRank(uuid));
    }

}
