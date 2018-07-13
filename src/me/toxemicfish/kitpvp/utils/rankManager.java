package me.toxemicfish.kitpvp.utils;

import me.toxemicfish.kitpvp.Main;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class rankManager {

    private Main plugin;

    public rankManager(Main plugin) {
        this.plugin = plugin;
    }


    public void setRank(UUID uuid, String rank) {
        try {
            PreparedStatement statement = plugin.getConnection().prepareStatement("UPDATE " + plugin.table + " SET RANK=? WHERE UUID=?");
            statement.setString(1, rank);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeRank(UUID uuid, String rank) {
        try {
            PreparedStatement statement = plugin.getConnection().prepareStatement("UPDATE " + plugin.table + " SET RANK=? WHERE UUID=?");
            statement.setString(1, rank);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getRank(UUID uuid) {
        try {
            PreparedStatement statement = plugin.getConnection().prepareStatement("SELECT * FROM " + plugin.table + " WHERE UUID=?");
            statement.setString(1, uuid.toString());
            ResultSet results = statement.executeQuery();
            results.next();

            return results.getString("RANK");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean isRank(UUID uuid, String rank){
        if(rank.equals(getRank(uuid))) {
            return true;
        }
        return false;
    }

}
