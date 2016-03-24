package com.antgaming.simcraft.player;

import com.antgaming.simcraft.SimUtil;
import com.antgaming.simcraft.datastore.DataStore;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 *
 * @author tim
 */
public class Sims {
    private static Map<UUID, Sim> sims = new HashMap<UUID, Sim>();
    
    
//    public static Sim getSim(String name) {
//        Sim s = null;
//        Player p = Bukkit.getServer().getPlayer(name);
//        if (p != null) {
//            s = getSim(p.getUniqueId());
//        }
//        return s;
//    }
    
    public static Sim getSim(UUID uniqueId) {
        Sim s = sims.get(uniqueId);
        if (s == null) {
            loadSim(uniqueId);
            s = sims.get(uniqueId);
        }
        return s;
    }
    
    public static void loadSim(UUID uniqueId) {
        DataStore db = SimUtil.getDatabase();
        if (sims.get(uniqueId) == null)
            if (db.loadSim(uniqueId) == null)
                sims.put(uniqueId, createSim(uniqueId));
    }
    
    private static Sim createSim(UUID uniqueId) {
        DataStore db = SimUtil.getDatabase();
        Sim s = new Sim(uniqueId);
        return s;
    }
    
    public static void saveSim(Sim s) {
        DataStore db = SimUtil.getDatabase();
        db.saveSim(s);
    }
    
    public static void saveSims() {
        DataStore db = SimUtil.getDatabase();
        for (Sim s : sims.values()) {
            db.saveSim(s);
        }
    }
}
