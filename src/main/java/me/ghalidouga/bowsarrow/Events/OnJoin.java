package me.ghalidouga.bowsarrow.Events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class OnJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        player.getInventory().clear();
        player.setGameMode(GameMode.SURVIVAL);
        player.getInventory().addItem(new ItemStack(Material.RED_WOOL, 1));
    }
}
