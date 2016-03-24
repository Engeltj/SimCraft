package com.antgaming.simcraft.player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
/**
 *
 * @author tim
 */
@Embeddable
public class Stats implements Serializable {
    
    Map<String, Stat> stats;
    
    public Stats () {
        this.stats = new HashMap<String, Stat>();
        stats.put("Hunger", new Stat("Hunger"));
        stats.put("Energy", new Stat("Energy"));
        stats.put("Fun", new Stat("Fun"));
        stats.put("Social", new Stat("Social"));
        stats.put("Hygiene", new Stat("Hygiene"));
    }
    
    public Map<String, Stat> getStats() {
        return this.stats;
    }
    
    public void setStats() {
        
    }
    
}
