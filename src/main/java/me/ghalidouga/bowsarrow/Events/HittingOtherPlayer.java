package me.ghalidouga.bowsarrow.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class HittingOtherPlayer implements Listener {

    @EventHandler
    public void HittingOtherPlayer(EntityDamageByEntityEvent e){
        e.setCancelled(true);
    }
}
