package fr.colin.factiongui.utils.confirmationmenu;

import com.massivecraft.factions.Rel;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import fr.colin.factiongui.FactionGUI;
import fr.colin.factiongui.utils.ItemBuilder;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Admin on 22/11/2016.
 */
public class LeaderConfirmationMenu extends ConfirmationMenu{


    private Player target;
    private String string;
    private static HashMap<String ,LeaderConfirmationMenu> leaderConfirmationMenuArrayList = new HashMap<>();
    private PluginManager pluginManager = Bukkit.getPluginManager();

    public LeaderConfirmationMenu(Player player, Player target) {
        super(player, new ItemBuilder(Material.DIAMOND).setName("§cPromouvoir Chef " + target.getName()).toItemStack(), "Chef");
        //this.target = target;

        string = "lol";

        //pluginManager.registerEvents(this, FactionGUI.getInstance());
        leaderConfirmationMenuArrayList.put(player.getName(), this);
    }




        public Player getTarget(){
            return target;
        }

    public static HashMap<String, LeaderConfirmationMenu> getLeaderConfirmationMenuArrayList() {
        return leaderConfirmationMenuArrayList;
    }
}


