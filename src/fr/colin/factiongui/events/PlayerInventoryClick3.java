package fr.colin.factiongui.events;

import com.massivecraft.factions.entity.MPlayer;
import fr.colin.factiongui.utils.Utils;
import fr.colin.factiongui.utils.confirmationmenu.ConfirmationMenu;
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
public class PlayerInventoryClick3 implements Listener {



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




        if(inv.getTitle().equalsIgnoreCase("§4Promouvoir")){

            if(e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§cPromouvoir Chef")) {
                e.setCancelled(true);
                p.closeInventory();
                Utils.getInstance().openLeadership(MPlayer.get(p));
                return;
            }
            e.setCancelled(true);
            String displayName = e.getCurrentItem().getItemMeta().getLore().get(3);
            Player targetPlayer = Bukkit.getPlayer(displayName);
            MPlayer mPlayer = MPlayer.get(targetPlayer);
            mPlayer.setRole(Utils.getInstance().getRel(mPlayer));
            mPlayer.getPlayer().sendMessage("§cVous avez été promu au rang de : " + mPlayer.getRole().getName());
            p.sendMessage("§cVous avez promu " + mPlayer.getPlayer().getName() + " au rang de : " + mPlayer.getRole().getName());
        }



    }



}
