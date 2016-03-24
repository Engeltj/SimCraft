package com.antgaming.simcraft;

import com.antgaming.simcraft.player.Sim;
import com.antgaming.simcraft.player.Sims;
import com.antgaming.simcraft.player.Stat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

/**
 *
 * @author tim
 */
public class SimHUD {
    private Scoreboard scoreboard;
    private Objective objective;
    private Sim sim;
    
    public SimHUD(Player player) {
        this.sim = Sims.getSim(player.getUniqueId());
        registerScoreboard();
        player.setScoreboard(scoreboard);
        
        System.out.println(sim.getUniqueId());
        Iterator it = sim
                .getStats()
                .getStats()
                .entrySet()
                .iterator();
        while (it.hasNext()) {
            Entry pair = (Entry) it.next();
            Score score = objective.getScore(pair.getKey().toString());
            Stat stat = (Stat) pair.getValue();
            score.setScore(stat.getValue());
            it.remove(); // avoids a ConcurrentModificationException
        }
    }
    
    private void registerScoreboard()
    {
      this.scoreboard = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
      this.objective = this.scoreboard.getObjective("Armor");
      if (this.objective == null) {
        this.objective = this.scoreboard.registerNewObjective("Stats", "dummy");
        this.objective.setDisplayName(ChatColor.GRAY + "Stats");
        this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
      }
    }
}
