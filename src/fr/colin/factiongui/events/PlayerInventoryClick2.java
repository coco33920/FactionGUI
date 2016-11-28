package fr.colin.factiongui.events;

import com.massivecraft.factions.entity.MPlayer;
import fr.colin.factiongui.utils.Utils;
import fr.colin.factiongui.utils.confirmationmenu.LeaderConfirmationMenu;
import org.apache.commons.lang.Validate;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Admin on 22/11/2016.
 */
public class PlayerInventoryClick2 implements Listener{



    @EventHandler
    public void playerIventoryClick(InventoryClickEvent e){
        Inventory inv = e.getClickedInventory();
        Player p = (Player) e.getWhoClicked();
             ItemStack s = e.getCurrentItem();
        if(s == null)
            return;
        if(s.getItemMeta() == null)
            return;
        if(s.getItemMeta().getDisplayName() == null)
            return;
        if(inv == null)
            return;




         if(e.getInventory().getTitle().equalsIgnoreCase("§4Promouvoir Chef")){
            p.closeInventory();
            String displayName = e.getCurrentItem().getItemMeta().getLore().get(1);
             Player player = Bukkit.getPlayer(displayName);

             if(player == null){
                 return;
             }

             Bukkit.broadcastMessage(player.getName());

            new LeaderConfirmationMenu(p, player).show();



        }

    }





}
