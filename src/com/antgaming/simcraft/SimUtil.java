package com.antgaming.simcraft;

import java.io.File;
import org.bukkit.Bukkit;

/**
 *
 * @author tim
 */
public class SimUtil {
    public static void sendConsole(String message) {
        Bukkit.getServer().getLogger().info(message);
    }
    
    public static File getDataFolder() {
        SimCraft sc = (SimCraft) Bukkit.getServer().getPluginManager().getPlugin("SimCraft");
        return sc.getDataFolder();
    }
    
}
