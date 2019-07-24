package me.ghalidouga.bowsarrow;



import me.ghalidouga.bowsarrow.Events.ArrowHit;
import me.ghalidouga.bowsarrow.Events.CantBreak;
import me.ghalidouga.bowsarrow.Events.DroppingItem;
import me.ghalidouga.bowsarrow.Events.OnJoin;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.server.BroadcastMessageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.NumberConversions;

public final class BowsArrow extends JavaPlugin implements Listener {
//public class TotalReady{
    //public int totalReady = 0;
//}
    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new CantBreak(), this);
        getServer().getPluginManager().registerEvents(new ArrowHit(), this);
        getServer().getPluginManager().registerEvents(new DroppingItem(),this);
        getServer().getPluginManager().registerEvents(new OnJoin(),this);
        saveDefaultConfig();



    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // command /ready
        if(command.getName().equals("ready")){
            if(sender instanceof  Player) {
                Player player = (Player) sender;
                if(player.getInventory().contains(new ItemStack(Material.BOW,1))){
                    player.sendMessage(ChatColor.RED + "Maaf, kamu sudah ready");
                }else {
                    getServer().broadcastMessage(player.getDisplayName() + ChatColor.GREEN + " Telah Ready");
                    player.getInventory().addItem(new ItemStack(Material.BOW, 1));
                }
            }
        }

        if(command.getName().equals("unready")){
            if(sender instanceof  Player){
                Player player = (Player) sender;
                if(player.getInventory().contains(new ItemStack(Material.BOW,1)))
                {
                    getServer().broadcastMessage(player.getDisplayName() + ChatColor.RED + " tidak jadi Ready");
                    player.getInventory().removeItem(new ItemStack(Material.BOW, 1));
                }else{
                    player.sendMessage(ChatColor.RED + "Kamu harus ready dulu sebelum unready, Pepega.");
                }

            }
        }



        return true;
    }
}

