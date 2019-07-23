package me.ghalidouga.bowsarrow.Events;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class CantBreak implements Listener {
    //Mencegah player menhancurkan block
    @EventHandler
    public void cantBreak(BlockBreakEvent e){
        Player player = e.getPlayer();
        e.setCancelled(true);
        player.sendMessage(ChatColor.RED + "Maaf, tydak bisa menghancurkan block");
    }



}
