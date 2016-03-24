package com.antgaming.simcraft.player;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author tim
 */
@Entity
public class Stat {
    @Id
    String name;
    Integer value;
    
    public Stat(String name) {
        this.name = name;
        this.value = 100;
    }
}
