package com.antgaming.simcraft;

import com.antgaming.simcraft.datastore.BukkitDB;
import com.antgaming.simcraft.datastore.DataStore;
import com.antgaming.simcraft.player.Sim;
import com.avaje.ebean.EbeanServer;
import java.io.File;
import org.bukkit.Bukkit;

/**
 *
 * @author tim
 */
public class SimUtil {
    private static DataStore db;
    
    public static void sendConsole(String message) {
        Bukkit.getServer().getLogger().info(message);
    }
    
    public static File getDataFolder() {
        SimCraft sc = (SimCraft) Bukkit.getServer().getPluginManager().getPlugin("SimCraft");
        return sc.getDataFolder();
    }
    
    public static void save() {
        SimCraft sc = (SimCraft) Bukkit.getServer().getPluginManager().getPlugin("SimCraft");
        sc.save();
    }
    
    public static DataStore getDatabase() {
        SimCraft sc = (SimCraft) Bukkit.getServer().getPluginManager().getPlugin("SimCraft");
        if (db == null)
            db = (DataStore) new BukkitDB(sc.getDatabase());
        return db;
    };
    
}
