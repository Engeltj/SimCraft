package com.antgaming.simcraft.player;

import java.util.HashMap;
import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
/**
 *
 * @author tim
 */
@Embeddable
public class Stats {
    
    @ManyToMany(mappedBy = "stats")
    @MapKey(name = "name")
    HashMap<String, Stat> stats = new HashMap<String, Stat>();
    
    public Stats () {
        stats.put("Hunger", new Stat("Hunger"));
        stats.put("Energy", new Stat("Energy"));
        stats.put("Fun", new Stat("Fun"));
        stats.put("Social", new Stat("Social"));
        stats.put("Hygiene", new Stat("Hygiene"));
    }
    
}
