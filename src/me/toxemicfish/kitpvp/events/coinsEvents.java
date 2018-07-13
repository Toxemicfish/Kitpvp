package me.toxemicfish.kitpvp.events;

import me.toxemicfish.kitpvp.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEggThrowEvent;

import java.util.Random;
import java.util.UUID;

public class coinsEvents implements Listener {

    Main plugin = Main.getInstance();

    @EventHandler
    public void playerHit(PlayerEggThrowEvent event) {
        Player player = (Player) event.getPlayer();
        UUID uuid = player.getUniqueId();
        if(!plugin.getSqlSetterGetter().playerExists(player.getUniqueId())) {
            plugin.getSqlSetterGetter().createPlayer(player.getUniqueId(), player);
            return;
        }

        event.setHatching(true);
        event.getHandlers().bake();
        plugin.getSqlSetterGetter().addCoins(player.getUniqueId(), 25);
        plugin.getpBoard().playerStats(player, plugin.getSqlSetterGetter().getCoins(uuid), "Null", plugin.getrManager().getRank(uuid));
    }

}
