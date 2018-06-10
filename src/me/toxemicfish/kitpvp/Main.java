package me.toxemicfish.kitpvp;

import me.toxemicfish.kitpvp.utils.messageManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;

    public void onEnable() {

        instance = this;

        registerCommands();
        registerEvents();
    }

    public void onDisable() {

    }

    private void registerCommands() {

    }

    private void registerEvents() {

    }

    public static Main getInstance() {
        return instance;
    }
}
