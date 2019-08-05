package me.ghalidouga.bowsarrow;



import me.ghalidouga.bowsarrow.Events.*;
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
        //getServer().getPluginManager().registerEvents(new CantBreak(), this);
        getServer().getPluginManager().registerEvents(new ArrowHit(), this);
        getServer().getPluginManager().registerEvents(new DroppingItem(),this);
        getServer().getPluginManager().registerEvents(new OnJoin(),this);
        getServer().getPluginManager().registerEvents(new MoveWool(), this);
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getPluginManager().registerEvents(new OnReady(),this);
        saveDefaultConfig();



    }
    public static ItemStack GreenWool(){
        ItemStack greenwool = new ItemStack(Material.GREEN_WOOL,1);
        greenwool.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK,1000);
        ItemMeta greenmeta = greenwool.getItemMeta();
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

    public static ItemStack UnbreakingBow(){
        ItemStack unbreakbow = new ItemStack(Material.BOW,1);
        unbreakbow.addUnsafeEnchantment(Enchantment.DURABILITY,1000);
        ItemMeta unbreakbowmeta = unbreakbow.getItemMeta();
        unbreakbowmeta.setDisplayName(ChatColor.GREEN + "Bow 1 Hit");
        unbreakbow.setItemMeta(unbreakbowmeta);
        return unbreakbow;
    }


    // Ready Unready Command
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // command /ready

        if(command.getName().equals("ready")){
            if(sender instanceof  Player) {
                Player player = (Player) sender;
                Location loc1 = new Location(Bukkit.getWorld("Blast"),0.5,4,-11.5,0,0);
                Location loc2 = new Location(Bukkit.getWorld("Blast"),-11.5,4,0.5,-90,0);
                Location loc3 = new Location(Bukkit.getWorld("Blast"),0.5,4,12.5,180,0);
                Location loc4 = new Location(Bukkit.getWorld("Blast"),12.5,4,0.5,90,0);

                ItemStack greenwool = new ItemStack(Material.GREEN_WOOL,1);
                greenwool.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK,1000);
                ItemMeta greenmeta = greenwool.getItemMeta();
                greenmeta.setDisplayName(ChatColor.GREEN + "Sudah Ready");
                greenwool.setItemMeta(greenmeta);

                ItemStack unbreakbow = new ItemStack(Material.BOW,1);
                unbreakbow.addUnsafeEnchantment(Enchantment.DURABILITY,1000);
                ItemMeta unbreakbowmeta = unbreakbow.getItemMeta();
                unbreakbowmeta.setDisplayName(ChatColor.GREEN + "Bow 1 Hit");
                unbreakbow.setItemMeta(unbreakbowmeta);

                player.teleport(loc1);
                if(player.getInventory().contains(GreenWool())){
                    player.sendMessage(ChatColor.RED + "Maaf, kamu sudah ready");
                }else {
                    getServer().broadcastMessage(player.getDisplayName() + ChatColor.GREEN + " Telah Ready");
                    player.getInventory().setItem(0,unbreakbow);
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
                if(player.getInventory().contains(GreenWool()))
                {
                    getServer().broadcastMessage(player.getDisplayName() + ChatColor.RED + " tidak jadi Ready");
                    player.getInventory().removeItem(UnbreakingBow());
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

