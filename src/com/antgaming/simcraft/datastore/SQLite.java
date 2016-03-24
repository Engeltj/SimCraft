package com.antgaming.simcraft.datastore;

import com.antgaming.simcraft.player.Sim;
import java.util.UUID;

/**
 *
 * @author tim
 */
public class SQLite implements DataStore {
    public static void load () {
        
    }

    public Sim loadSim(UUID uniqueId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Sim loadSim(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean saveSim(Sim s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
