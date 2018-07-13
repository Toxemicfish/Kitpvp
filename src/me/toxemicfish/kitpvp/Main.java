package me.toxemicfish.kitpvp;

import me.toxemicfish.kitpvp.commands.coins;
import me.toxemicfish.kitpvp.commands.removeKit;
import me.toxemicfish.kitpvp.commands.setKit;
import me.toxemicfish.kitpvp.events.coinsEvents;
import me.toxemicfish.kitpvp.events.joinEvent;
import me.toxemicfish.kitpvp.kits.archer;
import me.toxemicfish.kitpvp.kits.knight;
import me.toxemicfish.kitpvp.sql.sqlSetterGetter;
import me.toxemicfish.kitpvp.utils.chatManager;
import me.toxemicfish.kitpvp.utils.playerScoreboard;
import me.toxemicfish.kitpvp.utils.rankManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
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


    //public HashMap<UUID, String> kitActive = new HashMap<>();
    public ArrayList<UUID> kitActive = new ArrayList<>();


    private static Main instance;

    File configFile = new File(this.getDataFolder(), "config.yml");

    private Connection connection;
    public String host, database, username, password, table;
    public int port;

    private knight kitKnight;
    private archer kitArcher;
    private sqlSetterGetter sqlSG;
    private playerScoreboard pBoard;
    private rankManager rManager;

    public void onEnable() {
        instance = this;

        loadConfig();
        mysqlSetup();

        kitKnight = new knight(this);
        kitArcher = new archer(this);
        sqlSG = new sqlSetterGetter(this);
        pBoard = new playerScoreboard(this);
        rManager = new rankManager(this);

        registerCommands();
        registerEvents();
    }

    public void onDisable() {

    }

    private void registerCommands() {
        getCommand("kit").setExecutor(new setKit());
        getCommand("kitreset").setExecutor(new removeKit());
        getCommand("coins").setExecutor(new coins());
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new joinEvent(), this);
        pm.registerEvents(new coinsEvents(), this);
    }


    public void loadConfig() {
        if(configFile.exists()) {
            return;
        }

        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public void mysqlSetup() {
        host = this.getConfig().getString("sql.host");
        port = this.getConfig().getInt("sql.port");
        database = this.getConfig().getString("sql.database");
        username = this.getConfig().getString("sql.username");
        password = this.getConfig().getString("sql.password");
        table = this.getConfig().getString("sql.table");

        try {

            synchronized (this) {
                if (getConnection() != null && !getConnection().isClosed()) {
                    return;
                }

                Class.forName("com.mysql.jdbc.Driver");
                setConnection(DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database,
                        this.username, this.password));

                chatManager.goodConsole("MYSQL CONNECTED");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            chatManager.badConsole("MYSQL NOT CONNECTED");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public ArrayList<UUID> getKitActive() {
        return kitActive;
    }

    public void setKitActive(ArrayList<UUID> kitActive) {
        this.kitActive = kitActive;
    }

    public knight getKitKnight() {
        return kitKnight;
    }

    public archer getKitArcher() {
        return kitArcher;
    }

    public sqlSetterGetter getSqlSetterGetter() {
        return sqlSG;
    }

    public playerScoreboard getpBoard() {
        return pBoard;
    }

    public rankManager getrManager() {
        return rManager;
    }

    public static Main getInstance() {
        return instance;
    }
}