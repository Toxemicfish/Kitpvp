package me.toxemicfish.kitpvp;

import me.toxemicfish.kitpvp.commands.removeKit;
import me.toxemicfish.kitpvp.commands.setKit;
import me.toxemicfish.kitpvp.kits.archer;
import me.toxemicfish.kitpvp.kits.knight;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Main extends JavaPlugin {

    /*
        TODO:
            - Fix kit system
            - Added kit cooldown
            - Add signs for kit
            - Add more kits
            - Personal kits gui
     */


    public HashMap<UUID, String> kitActive = new HashMap<>();


    private static Main instance;

    private knight kitKnight;
    private archer kitArcher;

    public void onEnable() {

        instance = this;

        kitKnight = new knight(this);
        kitArcher = new archer(this);

        registerCommands();
        registerEvents();
    }

    public void onDisable() {

    }

    private void registerCommands() {
        getCommand("kit").setExecutor(new setKit());
        getCommand("kitreset").setExecutor(new removeKit());
    }

    private void registerEvents() {

    }

    public HashMap<UUID, String> getKitActive() {
        return kitActive;
    }

    public void setKitActive(HashMap<UUID, String> kitActive) {
        this.kitActive = kitActive;
    }

    public knight getKitKnight() {
        return kitKnight;
    }

    public archer getKitArcher() {
        return kitArcher;
    }

    public static Main getInstance() {
        return instance;
    }
}