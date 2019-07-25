package me.ghalidouga.bowsarrow;



import me.ghalidouga.bowsarrow.Events.ArrowHit;
import me.ghalidouga.bowsarrow.Events.CantBreak;
import me.ghalidouga.bowsarrow.Events.DroppingItem;
import me.ghalidouga.bowsarrow.Events.OnJoin;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.server.BroadcastMessageEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.NumberConversions;

public final class BowsArrow extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new CantBreak(), this);
        getServer().getPluginManager().registerEvents(new ArrowHit(), this);
        getServer().getPluginManager().registerEvents(new DroppingItem(),this);
        getServer().getPluginManager().registerEvents(new OnJoin(),this);
        getServer().getPluginManager().registerEvents(this,this);
        saveDefaultConfig();



    }
    public static ItemStack GreenWool(){
        ItemStack greenwool = new ItemStack(Material.GREEN_WOOL,1);
        ItemMeta greenmeta = greenwool.getItemMeta();
        greenwool.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK,1000);
        greenmeta.setDisplayName(ChatColor.GREEN + "Sudah Ready");
        greenwool.setItemMeta(greenmeta);
        return greenwool;



    }

    public static ItemStack RedWool(){
        ItemStack redwool = new ItemStack(Material.RED_WOOL,1);
        ItemMeta redwoolmeta = redwool.getItemMeta();
        redwool.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK,1000);
        redwoolmeta.setDisplayName(ChatColor.RED + "Belom Ready");
        redwool.setItemMeta(redwoolmeta);
        return redwool;


    }


    // Ready Unready Command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // command /ready

        if(command.getName().equals("ready")){
            if(sender instanceof  Player) {
                Player player = (Player) sender;
                ItemStack greenwool = new ItemStack(Material.GREEN_WOOL,1);
                greenwool.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK,1000);
                ItemMeta greenmeta = greenwool.getItemMeta();
                greenmeta.setDisplayName(ChatColor.GREEN + "Sudah Ready");
                greenwool.setItemMeta(greenmeta);
                if(player.getInventory().contains(new ItemStack(Material.BOW,1))){
                    player.sendMessage(ChatColor.RED + "Maaf, kamu sudah ready");
                }else {
                    getServer().broadcastMessage(player.getDisplayName() + ChatColor.GREEN + " Telah Ready");
                    player.getInventory().addItem(new ItemStack(Material.BOW, 1));
                    player.getInventory().setItem(8,greenwool);
                    player.getInventory().removeItem(new ItemStack(Material.RED_WOOL, 1));
                }
            }
        }
        // command /unready
        if(command.getName().equals("unready")){
            if(sender instanceof  Player){
                Player player = (Player) sender;
                ItemStack redwool = new ItemStack(Material.RED_WOOL,1);
                redwool.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK,1000);
                ItemMeta redwoolmeta = redwool.getItemMeta();
                redwoolmeta.setDisplayName(ChatColor.RED + "Belom Ready");
                redwool.setItemMeta(redwoolmeta);
                if(player.getInventory().contains(new ItemStack(Material.BOW,1)))
                {
                    getServer().broadcastMessage(player.getDisplayName() + ChatColor.RED + " tidak jadi Ready");
                    player.getInventory().removeItem(new ItemStack(Material.BOW, 1));
                    player.getInventory().removeItem(new ItemStack(Material.GREEN_WOOL));
                    player.getInventory().setItem(8,redwool);

                }else{
                    player.sendMessage(ChatColor.RED + "Kamu harus ready dulu sebelum unready, Pepega.");
                }

            }
        }



        return true;
    }
}

