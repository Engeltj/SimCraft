package com.antgaming.simcraft.player;

import java.util.Map;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapKey;
import javax.persistence.Table;

/**
 *
 * @author tim
 */
@Entity
@Table(name="players")
public class Sim {
    @Id
    @Column(name="id")
    private String uniqueId;
    
    transient private UUID UUID;
    
    @Column(name="buildMode")
    private boolean buildMode;
    
    @Embedded
    @ManyToMany(mappedBy = "stats")
    @MapKey(name = "name")
    private Stats stats;
    
    public Sim() {
        
    }
    
    public Sim(UUID uniqueId) {
        this.UUID = uniqueId;
        this.uniqueId = UUID.toString();
        this.stats = new Stats();
        this.buildMode = false;
    }
    
    public String getUniqueId() {
        return this.uniqueId;
    }
    
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
        this.UUID = UUID.fromString(uniqueId);
    }
    
    public boolean getBuildMode() {
        return buildMode;
    }
    
    public void setBuildMode(boolean buildMode) {
        this.buildMode = buildMode;
    }
    
    public Stats getStats() {
        return stats;
    }
    
    public void setStats(Stats stats) {
        this.stats = stats;
    }
}
