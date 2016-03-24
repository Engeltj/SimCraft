package com.antgaming.simcraft.datastore;

import com.antgaming.simcraft.player.Sim;
import java.util.UUID;

/**
 *
 * @author tim
 */
public interface DataStore {
    public Sim loadSim(UUID uniqueId);
    public Sim loadSim(String name);
    public boolean saveSim(Sim s);

}
