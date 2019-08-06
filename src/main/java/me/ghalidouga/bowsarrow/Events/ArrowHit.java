package me.ghalidouga.bowsarrow.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerTeleportEvent;


public class ArrowHit implements Listener {

    @EventHandler
    public void arrowHit(ProjectileHitEvent e){
        Entity playerDeath = e.getHitEntity();
        Location tpOnDeath = new Location(Bukkit.getWorld("Blast"),-24,28,0,-90,0);
        if(playerDeath instanceof  Player){
            playerDeath.teleport(tpOnDeath);
            ((Player) playerDeath).sendMessage(ChatColor.RED + "Kamu telah tertembak");
        }
    }

}
