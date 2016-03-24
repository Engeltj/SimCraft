package com.antgaming.simcraft.player;

import com.antgaming.simcraft.SimHUD;
import com.antgaming.simcraft.SimUtil;
import java.util.List;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.world.WorldSaveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

/**
 *
 * @author tim
 */
public class SimListener implements Listener {
    
    @EventHandler(priority=EventPriority.NORMAL)
    public void onPlayerJoin(PlayerJoinEvent event){
        Player p = event.getPlayer();
        Sims.loadSim(p.getUniqueId());
        new SimHUD(p);
        p.sendMessage("We are here.");
    }
    
    @EventHandler(priority= EventPriority.NORMAL)
    public void onSignChange(SignChangeEvent event){
    
    }
    
    @EventHandler(priority=EventPriority.NORMAL)
    public void onSignDestroy(BlockBreakEvent event){
        
    }
    
    @EventHandler
    public void onWorldSave(WorldSaveEvent event){
        SimUtil.save();
    }
    
    @EventHandler(priority=EventPriority.NORMAL)
    public void onBlockBreak(BlockBreakEvent event){
    
    }
    
    @EventHandler(priority=EventPriority.NORMAL)
    public void onPlayerInteractInventory(InventoryClickEvent event){
        if (event.getInventory() instanceof PlayerInventory) {
            Player p = (Player) event.getInventory().getHolder();
            Sim s = Sims.getSim(p.getUniqueId());
            ItemStack is = event.getCurrentItem();
            event.setCancelled(true);
        }
    }
    
    @EventHandler
    public void onPlayerOpenInventory(InventoryOpenEvent event) {
        if (event.getInventory() instanceof PlayerInventory) {
            Player p = (Player) event.getInventory().getHolder();
            Sim s = Sims.getSim(p.getUniqueId());
            if (s.getBuildMode() == true) {
                
            }
        }
    
    }
    
}
