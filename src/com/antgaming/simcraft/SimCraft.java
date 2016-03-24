package com.antgaming.simcraft;

import com.antgaming.simcraft.player.Sim;
import com.antgaming.simcraft.player.SimListener;
import com.antgaming.simcraft.player.Stats;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author tim
 */
public final class SimCraft extends JavaPlugin {
    
    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        
        if (!(pm.getPlugin("WorldGuard") == null)) {
            getLogger().info(String.format("[%s] - Disabled due to no instance of WorldGuard found!", getDescription().getName()));
            pm.disablePlugin(this);
            return;
        } else if (!(pm.getPlugin("WorldEdit") == null)) {
            getLogger().info(String.format("[%s] - Disabled due to no instance of WorldEdit found!", getDescription().getName()));
            pm.disablePlugin(this);
            return;
        }
        
//        this.installDDL();
        pm.registerEvents(new SimListener(), this);
    }
    
    @Override
    public List<Class<?>> getDatabaseClasses() {
        List<Class<?>> list = new ArrayList<Class<?>>();
        list.add(Sim.class);
        list.add(Stats.class);
        return list;
    }
    
    @Override
    public void onDisable() {
        getLogger().info("SimCraft by AnTGaming has been disabled");
    }
    
    public void save() {
        
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        return true;
    }

}
