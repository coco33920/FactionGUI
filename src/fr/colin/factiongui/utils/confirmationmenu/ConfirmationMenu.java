package fr.colin.factiongui.utils.confirmationmenu;

import fr.colin.factiongui.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

/**
 * Created by Admin on 22/11/2016.
 */
public abstract class ConfirmationMenu {

   protected Player player;
    protected ItemStack toConfirming;
    protected Inventory inventory;
    protected ItemStack laineVerte;
    protected ItemStack laineRouge;
    protected String name;



    public ConfirmationMenu(Player player, ItemStack toConfirming, String name){
        this.player = player;
        this.toConfirming = toConfirming;
        this.name = name;
        this.inventory = Bukkit.createInventory(null, InventoryType.CHEST, "§aConfirmation " + name);
    }




    private void fill(){

         laineVerte = new ItemBuilder(Material.WOOL, 1, (byte) 5).setName("§aOk ! " ).toItemStack();
         laineRouge = new ItemBuilder(Material.WOOL, 1, (byte) 14).setName("§cNon !").toItemStack();

        inventory.setItem(11, laineVerte);
        inventory.setItem(13, toConfirming);
        inventory.setItem(15, laineRouge);


    }




    public void show(){
        fill();
        player.openInventory(inventory);
    }


    public Player getPlayer() {
        return player;
    }


    public ItemStack getToConfirming() {
        return toConfirming;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ItemStack getLaineVerte() {
        return laineVerte;
    }

    public ItemStack getLaineRouge() {
        return laineRouge;
    }

    public String getName() {
        return name;
    }
}
