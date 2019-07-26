package me.ghalidouga.bowsarrow.Events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.*;
import org.bukkit.inventory.Inventory;
import org.bukkit.event.inventory.ClickType;

import java.util.Set;

public class MoveWool implements Listener {

    @EventHandler
    public void moveWool(InventoryClickEvent e){
        ClickType leftClick = e.getClick();
        if(leftClick.isLeftClick()){
            e.setCancelled(true);
        }


        }
    }


