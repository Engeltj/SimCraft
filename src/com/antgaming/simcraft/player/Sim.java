package com.antgaming.simcraft.player;

import java.util.UUID;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author tim
 */
@Entity
public class Sim {
    @Id
    private UUID uniqueId;
    
    private boolean buildMode;
    
    @Embedded 
    private Stats stats;
    
    public Sim(UUID uniqueId) {
        this.uniqueId = uniqueId;
        this.stats = new Stats();
        this.buildMode = false;
    }
    
    public boolean isInBuildMode() {
        return buildMode;
    }
}
