package me.ghalidouga.bowsarrow.Events;


import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class CantBreak implements Listener {
    //Mencegah player menhancurkan block
    @EventHandler
    public void cantBreak(BlockBreakEvent e){
        Player player = e.getPlayer();
        e.setCancelled(true);
        if(player.isOp()){
            e.setCancelled(false);
        }
    }

    @EventHandler
    public void cantPlace(BlockPlaceEvent e){
        Player player = e.getPlayer();
        e.setCancelled(true);
        if(player.isOp()){
            e.setBuild(true);
        }
    }



}
