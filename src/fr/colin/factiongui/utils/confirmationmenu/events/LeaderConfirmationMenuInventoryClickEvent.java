package fr.colin.factiongui.utils.confirmationmenu.events;

import com.massivecraft.factions.Rel;
import com.massivecraft.factions.entity.MPlayer;
import fr.colin.factiongui.utils.confirmationmenu.LeaderConfirmationMenu;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

/**
 * Created by Admin on 24/11/2016.
 */
public class LeaderConfirmationMenuInventoryClickEvent implements Listener {




    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        HashMap<String, LeaderConfirmationMenu> confirmationMenuHashMap = LeaderConfirmationMenu.getLeaderConfirmationMenuArrayList();



        ItemStack s = event.getCurrentItem();
        Inventory inv = event.getClickedInventory();
        if(s == null)
            return;

        ItemMeta meta = s.getItemMeta();
        if(meta == null)
            return;

        String displayName = meta.getDisplayName();

        if(displayName == null)
            return;
        if(inv == null){
            return;
        }

        if(inv.getName().equalsIgnoreCase("§aConfirmation Chef")) {
            LeaderConfirmationMenu leaderConfirmationMenu = confirmationMenuHashMap.get(player.getName());
            Player target = leaderConfirmationMenu.getTarget();
            Bukkit.broadcastMessage("Debug" + target.getDisplayName());
            if (displayName.equalsIgnoreCase("§cNon !")) {
                event.setCancelled(true);
                player.closeInventory();
                player.sendMessage("§cChoix annulé !");
                return;
            } else if (displayName.equalsIgnoreCase("§aOk !"))
                event.setCancelled(true);
            player.closeInventory();
            player.sendMessage("§aChoix validé !");
            if(target == null){
                Bukkit.broadcastMessage("Debug 1");
            }
            MPlayer mPlayer = MPlayer.get(target);
            MPlayer.get(player).setRole(Rel.OFFICER);
            mPlayer.setRole(Rel.LEADER);

            target.sendMessage("§cVous avez été promu chef de votre faction !");
            player.sendMessage("§cVous avez promu " + target.getName() + " chef !");

        } else {
            event.setCancelled(true);
        }
    }
}
