package me.ghalidouga.bowsarrow.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class OnReady implements Listener {
    @EventHandler
    public void onReady(PlayerMoveEvent e){
        Player player = e.getPlayer();
        if(player.getInventory().contains(Material.GREEN_WOOL,1)){
            e.setCancelled(true);
        }


        }


}


