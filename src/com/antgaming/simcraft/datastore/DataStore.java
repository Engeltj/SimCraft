package com.antgaming.simcraft.datastore;

import com.avaje.ebean.EbeanServer;

/**
 *
 * @author tim
 */
public class DataStore extends BukkitDB {

    public DataStore(EbeanServer db) {
        super(db);
    }

}
