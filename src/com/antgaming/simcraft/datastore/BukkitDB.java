package com.antgaming.simcraft.datastore;

import com.antgaming.simcraft.player.Sim;
import com.avaje.ebean.EbeanServer;
import java.util.UUID;
import javax.persistence.OptimisticLockException;

/**
 *
 * @author tim
 */
public class BukkitDB {
    private final EbeanServer db;
    
    public BukkitDB (EbeanServer db) {
        this.db = db;
    }
    
    public Sim loadSim(UUID uniqueId) {
        Sim s = db.find(Sim.class)
          .where().eq("uuid", uniqueId.toString())
          .findUnique();
        return s;
    }
    
    public boolean saveSim(Sim s) {
        try {
            db.save(s);
            return true;
        } catch (OptimisticLockException e) {
            return false;
        }
    }
    
}
