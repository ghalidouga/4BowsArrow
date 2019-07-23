package me.ghalidouga.bowsarrow.Events;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
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
        if(playerDeath instanceof  Player){
            ((Player) playerDeath).setGameMode(GameMode.SPECTATOR);
            ((Player) playerDeath).sendMessage(ChatColor.RED + "Kamu telah tertembak");
        }
    }

}
