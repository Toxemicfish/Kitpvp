package me.toxemicfish.kitpvp.utils;

import me.toxemicfish.kitpvp.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class playerScoreboard {

    private Main plugin;

    public playerScoreboard(Main plugin) {
        this.plugin = plugin;
    }

    private ScoreboardManager m;
    private Scoreboard b;
    private Objective o;
    private Score activeKit;
    private Score coins;
    private Score rank;
    private Score online;
    private Score blank;
    private Score blank2;
    private Score blank3;
    private Score blank4;
    private Score blank5;

    public void playerStats(Player player, int coinsAmount, String kitName, String playerRank) {
        m = Bukkit.getScoreboardManager();
        b = m.getNewScoreboard();
        o = b.registerNewObjective("stats", "");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(chatManager.color("&6" + player.getName() + " &bStats"));

        blank = o.getScore(ChatColor.RESET.toString() + ChatColor.RESET.toString());
        blank.setScore(13);

        coins = o.getScore(chatManager.color("&eCoins: &a" + coinsAmount));
        coins.setScore(12);

        blank = o.getScore(ChatColor.RESET.toString());
        blank.setScore(10);

        activeKit = o.getScore(chatManager.color("&eKit: &a" + kitName));
        activeKit.setScore(9);

        blank2 = o.getScore(ChatColor.RESET.toString() + ChatColor.RESET.toString() + ChatColor.RESET.toString());
        blank2.setScore(7);

        rank = o.getScore(chatManager.color("&eRank: &a" + playerRank));
        rank.setScore(6);

        blank4 = o.getScore(ChatColor.RESET.toString() + ChatColor.RESET.toString() + ChatColor.RESET.toString() + ChatColor.RESET.toString());
        blank4.setScore(4);

        online = o.getScore(chatManager.color("&eOnline: &a" + Bukkit.getOnlinePlayers().size()));
        online.setScore(3);

        player.setScoreboard(b);
    }

}
