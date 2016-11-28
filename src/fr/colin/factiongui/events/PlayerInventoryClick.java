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
 * Created by Admin on 07/10/2016.
 */
public class PlayerInventoryClick implements Listener {

    @EventHandler
    public void playerInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack s = e.getCurrentItem();
        Inventory inv = e.getClickedInventory();


        if(s == null)
            return;
        if(s.getItemMeta() == null)
            return;
        if(s.getItemMeta().getDisplayName() == null)
            return;
        if(inv == null)
            return;

        if (inv.getTitle().equalsIgnoreCase("§4Commandes Faction") || inv.getTitle().equalsIgnoreCase("§4Commandes Faction Admin")) {
            if (s.getItemMeta().getDisplayName().equalsIgnoreCase("§cTéléportation vers le Home de Faction")) {
                p.closeInventory();
                p.performCommand("f home");
                return;

            } else if (s.getItemMeta().getDisplayName().equalsIgnoreCase("§cNouveau Claim")) {
                p.closeInventory();
                p.chat("/f claim o");
                return;
            } else if (s.getItemMeta().getDisplayName().contains("§cNombre de Claims")) {
                p.closeInventory();
                p.chat("/f map");
                return;
            } else if (s.getItemMeta().getDisplayName().equalsIgnoreCase("§cVoir Votre Faction")) {
                p.closeInventory();
                p.chat("/f f");
                return;
            } else if(s.getItemMeta().getDisplayName().equalsIgnoreCase("§cPromote des Joueurs")){
                p.closeInventory();
                Utils.getInstance().invTypePromotePlayer(p);
                return;
            }else{
                e.setCancelled(true);
                return;
            }

        }


    }


}
