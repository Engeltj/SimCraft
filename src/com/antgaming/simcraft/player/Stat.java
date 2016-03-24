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
    int value;
    
    public Stat(String name) {
        this.name = name;
        this.value = 100;
    }
    
    public int getValue() {
        return value;
    }
}
