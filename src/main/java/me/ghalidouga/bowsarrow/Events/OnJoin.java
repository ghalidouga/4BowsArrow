package me.ghalidouga.bowsarrow.Events;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class OnJoin implements Listener {

    @EventHandler
    public void  onJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();

        player.setFoodLevel(20);
        player.setHealth(20);

        player.getInventory().clear();
        player.setGameMode(GameMode.SURVIVAL);

        ItemStack redwool = new ItemStack(Material.RED_WOOL,1);
        redwool.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1000);
        ItemMeta redwoolmeta = redwool.getItemMeta();
        redwoolmeta.setDisplayName(ChatColor.RED + "Status Belum Ready");
        redwool.setItemMeta(redwoolmeta);
        Inventory hotbar = player.getInventory();
        hotbar.setItem(8, redwool);
        return ;
    }
}
