package me.ghalidouga.bowsarrow.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DroppingItem implements Listener {

    @EventHandler
    public void dropItem(PlayerDropItemEvent e){
        //Player player = e.getPlayer();
        e.setCancelled(true);

    }

}
