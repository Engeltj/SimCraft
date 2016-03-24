package com.antgaming.simcraft.property;

import com.sk89q.worldguard.domains.DefaultDomain;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.managers.storage.StorageException;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

/**
 *
 * @author tim
 */
public class LotControl {
    private static WorldGuardUtil wgu;
    
    public LotControl () {
        wgu = new WorldGuardUtil();
    }
    
    public Map<String, ProtectedRegion> getRegionsByOwner(String owner){
        HashMap<String, ProtectedRegion> map = new HashMap<String, ProtectedRegion>();
        for (World w : Bukkit.getServer().getWorlds()){
            RegionManager mgr = wgu.getRegionManager(w);
            Iterator it = mgr.getRegions().entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pairs = (Map.Entry)it.next();
                ProtectedRegion rg = (ProtectedRegion) pairs.getValue();
                for (String key : rg.getOwners().getPlayers()){
                    if (key.equalsIgnoreCase(owner))
                        map.put(rg.getId(), rg);  
                }
            }
        }
        return map;
    }
    
    public ProtectedRegion createRegion(String name, Location start, Location end){
        World w = start.getWorld();
        
        try {
           return wgu.createRegion(name, start, end);
        } catch (Exception ex) {
           Logger.getLogger(LotControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ProtectedRegion createRegion(String name, Location loc, int length, int width, int height){
        World w = loc.getWorld();
        Location start,end;
        start = new Location(w,loc.getX()-length/2.0, loc.getY()-height/2.0, loc.getZ()-width/2.0);
        end = new Location(w,loc.getX()+length/2.0, loc.getY()+height/2.0, loc.getZ()+width/2.0);
        
        return createRegion(name,start, end);
    }
    
    public ProtectedRegion createRegion(String name, Location loc, int radius){
        return createRegion(name, loc, radius*2, radius*2, radius*2);
    }
    
    public ProtectedRegion createRegion(String name, Location loc, int h_radius, int v_radius){
        return createRegion(name, loc, h_radius*2, h_radius*2, v_radius*2);
    }
    
    public ProtectedRegion createRegionVert(String name, Location loc, int length, int width){
        World w = loc.getWorld();
        Location start,end;
        start = new Location(w,loc.getX()-length/2.0, 0L, loc.getZ()-width/2.0);
        end = new Location(w,loc.getX()+length/2.0, 255L, loc.getZ()+width/2.0);
        
        return createRegion(name,start, end);
    }
    
    public void removeRegion(String region, World w){
        wgu.deleteRegion(region, w);
    }
    
    public void saveRegions(World w){
        try {
            wgu.getRegionManager(w).save();
        } catch (StorageException e) {
            e.printStackTrace();
        }
    }
    
    public void addRegionOwner(String owner, ProtectedRegion pr){
        DefaultDomain dd = pr.getOwners();
        dd.addPlayer(owner);
        pr.setOwners(dd);
    }
    
    public void setRegionOwner(String owner, ProtectedRegion pr){
        DefaultDomain dd = pr.getOwners();
        dd.removeAll();
        if (owner != null && !owner.isEmpty())
            dd.addPlayer(owner);
        pr.setOwners(dd);
    }
}
