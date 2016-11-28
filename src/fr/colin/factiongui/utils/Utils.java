package fr.colin.factiongui.utils;

import com.massivecraft.factions.FactionListComparator;
import com.massivecraft.factions.Rel;
import com.massivecraft.factions.entity.Faction;
import com.massivecraft.factions.entity.MPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 07/10/2016.
 */
public class Utils {


    private static Utils ourInstance = new Utils();

    public static Utils getInstance() {
        return ourInstance;
    }

    private Utils() {
    }


    private Inventory invfaction = Bukkit.createInventory(null, InventoryType.CHEST, "§4Commandes Faction");
    private Inventory admininvfaction = Bukkit.createInventory(null, InventoryType.CHEST, "§4Commandes Faction Admin");
    private Faction faction;


    public void openInventory(Player p, int nbinvenory) {
        MPlayer pla = MPlayer.get(p);
        switch (nbinvenory) {
            case 1:
                ItemStack is3;
                ItemStack is4;
                if (pla.hasFaction()) {
                    is3 = new ItemBuilder(Material.SKULL_ITEM, 1, (byte) 3).setName("§cVous").setSkullOwner(p.getName()).setLore("§4Grade de la fac : " + pla.getRole(), " ", "§5Faction : " + pla.getFaction().getName(), " ", "§bVotre Power : " + Math.round(pla.getPower()), " ", "§cVotre titre : " + pla.getTitle()).toItemStack();
                    switch (pla.getRole()) {
                        case LEADER:
                            invTypeLead(pla);
                            break;
                        case OFFICER:
                            invTypeModo(pla);
                            break;
                        case MEMBER:
                            invTypeMembre(pla);
                            break;
                        case RECRUIT:
                            invTypeRecruit(pla);
                            break;
                    }
                } else {
                    invfaction.clear();
                    is3 = new ItemBuilder(Material.SKULL_ITEM, 1, (byte) 3).setName("§cVous").setSkullOwner(p.getName()).setLore("§4Sans Faction !").toItemStack();
                }
                invfaction.setItem(0, is3);
                p.openInventory(invfaction);

                break;
            case 2:
                if (p.hasPermission("invfaction.admin")) {
                    ItemStack is;
                    ItemStack is2;

                    if (pla.hasFaction()) {
                        is = new ItemBuilder(Material.SKULL_ITEM, 1, (byte) 3).setName("§cVous").setSkullOwner(p.getName()).setLore("§4Permission Admin", " ", "§5Faction : " + pla.getFaction().getName(), " ", "§bVotre Power : " + Math.round(pla.getPower())).toItemStack();
                    } else {
                        is = new ItemBuilder(Material.SKULL_ITEM, 1, (byte) 3).setName("§cVous").setSkullOwner(p.getName()).setLore("§4Permission Admin", " ", "§4Sans Faction !").toItemStack();
                    }
                    is2 = new ItemBuilder(Material.WOOD_AXE).setName("§cFaction Admin").toItemStack();
                    admininvfaction.setItem(0, is);
                    admininvfaction.setItem(4, is2);
                    p.openInventory(admininvfaction);
                } else {
                    p.sendMessage("§cErreur vous n'avez la permission d'effectuer cette commande");
                }
                break;
        }
    }

    public void invTypeRecruit(MPlayer mp) {
        invfaction.clear();
        ItemStack s;
        Faction f = mp.getFaction();
        if (f.hasHome()) {
            s = new ItemBuilder(Material.SIGN).setName("§cTéléportation vers le Home de Faction").toItemStack();
        } else {
            s = new ItemBuilder(Material.SIGN).setName("§cPas de Home de Faction").toItemStack();
        }


        ItemStack is = new ItemBuilder(Material.WOOL, 1, (byte) 14).setName("§cPermission de poser des Blocs : NON").toItemStack();
        ItemStack is2 = new ItemBuilder(Material.WOOL, 1, (byte) 14).setName("§cPermission de détruire des Blocs : NON").toItemStack();
        ItemStack is3 = new ItemBuilder(Material.WOOL, 1, (byte) 14).setName("§cPermission d'utiliser les coffres/fours : NON").toItemStack();
        ItemStack is4 = new ItemBuilder(Material.WOOL, 1, (byte) 14).setName("§cPermission d'utiliser les commandes de la fac : NON").toItemStack();
        ItemStack is5 = new ItemBuilder(Material.BARRIER).setName("§bBleu :O").toItemStack();
        ItemBuilder factionneutralouallier = new ItemBuilder(Material.PAPER).setName("§cVoir Votre Faction");

        invfaction.setItem(1, s);
        invfaction.setItem(10, is);
        invfaction.setItem(12, is2);
        invfaction.setItem(14, is3);
        invfaction.setItem(16, is4);
        invfaction.setItem(26, is5);


    }

    public void invTypeMembre(MPlayer mp) {

        invfaction.clear();
        ItemStack s;
        Faction f = mp.getFaction();
        if (f.hasHome()) {
            s = new ItemBuilder(Material.SIGN).setName("§cTéléportation vers le Home de Faction").toItemStack();
        } else {
            s = new ItemBuilder(Material.SIGN).setName("§cPas de Home de Faction").toItemStack();
        }


        ItemStack is = new ItemBuilder(Material.WOOL, 1, (byte) 13).setName("§cPermission de poser des Blocs : OUI").toItemStack();
        ItemStack is2 = new ItemBuilder(Material.WOOL, 1, (byte) 13).setName("§cPermission de détruire des Blocs : OUI").toItemStack();
        ItemStack is3 = new ItemBuilder(Material.WOOL, 1, (byte) 13).setName("§cPermission d'utiliser les coffres/fours : OUI").toItemStack();
        ItemStack is4 = new ItemBuilder(Material.WOOL, 1, (byte) 14).setName("§cPermission d'utiliser les commandes de la fac : NON").toItemStack();
        ItemStack is5 = new ItemBuilder(Material.LEATHER_CHESTPLATE).setName("Membre :)").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1).toItemStack();
        ItemBuilder factionneutralouallier = new ItemBuilder(Material.PAPER).setName("§cVoir Votre Faction");
        invfaction.setItem(1, s);
        invfaction.setItem(10, is);
        invfaction.setItem(12, is2);
        invfaction.setItem(14, is3);
        invfaction.setItem(16, is4);
        invfaction.setItem(26, is5);


    }

    public void invTypeModo(MPlayer mp) {
        List<String> strings = new ArrayList<>();
        invfaction.clear();
        ItemStack s;
        Faction f = mp.getFaction();
        if (f.hasHome()) {
            s = new ItemBuilder(Material.SIGN).setName("§cTéléportation vers le Home de Faction").toItemStack();
        } else {
            s = new ItemBuilder(Material.SIGN).setName("§cPas de Home de Faction").toItemStack();
        }

        ItemStack claims = new ItemBuilder(Material.MAP).setName("§cNombre de Claims : " + f.getLandCount()).toItemStack();
        ItemStack power = new ItemBuilder(Material.SUGAR).setName("§cPower Total de la fac : " + f.getPowerRounded()).toItemStack();
        ItemStack nouveauclaim = new ItemBuilder(Material.EMPTY_MAP).setName("§cNouveau Claim").toItemStack();
        ItemBuilder gens = new ItemBuilder(Material.SKULL_ITEM, 1, (byte) 3);
        for (MPlayer mPlayer : f.getMPlayers()) {
            strings.add("§c" + mPlayer.getName());
        }
        gens.setLore(strings);
        gens.setName("§cNombre Total de joueur : " + f.getMPlayers().size());
        ItemStack is = new ItemBuilder(Material.WOOL, 1, (byte) 13).setName("§cPermission de poser des Blocs : OUI").toItemStack();
        ItemStack is2 = new ItemBuilder(Material.WOOL, 1, (byte) 13).setName("§cPermission de détruire des Blocs : OUI").toItemStack();
        ItemStack is3 = new ItemBuilder(Material.WOOL, 1, (byte) 13).setName("§cPermission d'utiliser les coffres/fours : OUI").toItemStack();
        ItemStack is4 = new ItemBuilder(Material.WOOL, 1, (byte) 13).setName("§cPermission d'utiliser les commandes de la fac : OUI").toItemStack();
        ItemStack is5 = new ItemBuilder(Material.GOLD_CHESTPLATE).setName("§6Modo !").addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5).toItemStack();
        ItemBuilder factionneutralouallier = new ItemBuilder(Material.PAPER).setName("§cVoir Votre Faction");
        invfaction.setItem(1, s);
        invfaction.setItem(2, claims);
        invfaction.setItem(3, power);
        invfaction.setItem(4, gens.toItemStack());
        invfaction.setItem(10, is);
        invfaction.setItem(12, is2);
        invfaction.setItem(14, is3);
        invfaction.setItem(16, is4);
        invfaction.setItem(18, nouveauclaim);
        invfaction.setItem(26, is5);


    }

    public void invTypeLead(MPlayer mp) {
        invfaction.clear();
        List<String> strings = new ArrayList<>();
        List<String> strings1 = new ArrayList<>();
        invfaction.clear();
        ItemStack s;
        Faction f = mp.getFaction();
        if (f.hasHome()) {
            s = new ItemBuilder(Material.SIGN).setName("§cTéléportation vers le Home de Faction").toItemStack();
        } else {
            s = new ItemBuilder(Material.SIGN).setName("§cPas de Home de Faction").toItemStack();
        }

        ItemStack claims = new ItemBuilder(Material.MAP).setName("§cNombre de Claims : " + f.getLandCount()).toItemStack();
        ItemStack power = new ItemBuilder(Material.SUGAR).setName("§cPower Total de la fac : " + f.getPowerRounded()).toItemStack();
        ItemStack nouveauclaim = new ItemBuilder(Material.EMPTY_MAP).setName("§cNouveau Claim").toItemStack();
        ItemBuilder gens = new ItemBuilder(Material.SKULL_ITEM, 1, (byte) 3);
        for (MPlayer mPlayer : f.getMPlayers()) {
            strings.add("§c" + mPlayer.getName());
        }
        gens.setLore(strings);
        ItemBuilder factionneutralouallier = new ItemBuilder(Material.PAPER).setName("§cVoir Votre Faction");
        gens.setName("§cNombre Total de joueur : " + f.getMPlayers().size());

        ItemStack is = new ItemBuilder(Material.WOOL, 1, (byte) 13).setName("§cPermission de poser des Blocs : OUI").toItemStack();
        ItemStack is2 = new ItemBuilder(Material.WOOL, 1, (byte) 13).setName("§cPermission de détruire des Blocs : OUI").toItemStack();
        ItemStack is3 = new ItemBuilder(Material.WOOL, 1, (byte) 13).setName("§cPermission d'utiliser les coffres/fours : OUI").toItemStack();
        ItemStack is4 = new ItemBuilder(Material.WOOL, 1, (byte) 13).setName("§cPermission d'utiliser les commandes de la fac : OUI").toItemStack();
        ItemStack is5 = new ItemBuilder(Material.DIAMOND_CHESTPLATE).setName("§4Big Boss !").addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10).toItemStack();
        ItemStack is6 = new ItemBuilder(Material.DIAMOND).setName("§cPromote des Joueurs").toItemStack();
        invfaction.setItem(1, s);
        invfaction.setItem(2, claims);
        invfaction.setItem(3, power);
        invfaction.setItem(4, gens.toItemStack());
        invfaction.setItem(5, is6);
        invfaction.setItem(10, is);
        invfaction.setItem(12, is2);
        invfaction.setItem(14, is3);
        invfaction.setItem(16, is4);
        invfaction.setItem(18, nouveauclaim);
        invfaction.setItem(26, is5);


    }

    public  void invTypePromotePlayer(Player player){




        Inventory inventory = Bukkit.createInventory(null, 54, "§4Promouvoir");
        MPlayer mPlayer = MPlayer.get(player);
        Faction faction = mPlayer.getFaction();
        ItemStack stack = new ItemBuilder(Material.DIAMOND).addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 1).setName("§cPromouvoir Chef").toItemStack();
       ItemMeta meta =  stack.getItemMeta();
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        stack.setItemMeta(meta);
        inventory.setItem(0, stack);
        for(MPlayer mPlayer1 : faction.getMPlayers()){
           boolean isLeader = mPlayer == mPlayer1;

            if(!isLeader) {
                String displayName = mPlayer1.getName();
                Rel rel = mPlayer1.getRole();

                if(!rel.equals(Rel.OFFICER)) {

                    ItemStack stack1 = new ItemBuilder(Material.SKULL_ITEM, 1, (byte) 3).setSkullOwner(displayName).setName("§c" + displayName + " " + rel.getName()).setLore(" ", "§cVers --> " + getRelName(mPlayer1), " ", displayName).toItemStack();
                    inventory.addItem(stack1);
                }

            }



        }

        player.openInventory(inventory);


    }

    public String getRelName(MPlayer mPlayer){


        String str = "";


        if(!mPlayer.hasFaction()){
            return "Pas de faction";
        }
        Faction faction = mPlayer.getFaction();
        Rel rel = mPlayer.getRole();
        switch (rel){
            case RECRUIT:
                return "§bMembre";
            case MEMBER:
                return "§6Officier";
            case OFFICER:
                return "§cAttention VOUS ALLEZ LE METTRE CHEF !";
            case LEADER:
                return "§cC'est vous";
        }

        return str;
    }
    public Rel getRel(MPlayer mPlayer){


        String str = "";


        if(mPlayer.hasFaction()) {
            Faction faction = mPlayer.getFaction();
            Rel rel = mPlayer.getRole();
            switch (rel) {
                case RECRUIT:
                    return Rel.MEMBER;
                case MEMBER:
                    return Rel.OFFICER;
                case OFFICER:
                    return Rel.OFFICER;
                case LEADER:
                    return Rel.LEADER;
            }

            return Rel.MEMBER;
        }else{
            Bukkit.broadcastMessage("Debug" + mPlayer.getFaction().getName());
            return Rel.TRUCE;
        }
    }



    public void openLeadership(MPlayer player){
        Inventory inventory = Bukkit.createInventory(null, 9, "§4Promouvoir Chef");

        if(!player.hasFaction()){
            return;
        }


        Faction faction = player.getFaction();
        Rel role = player.getRole();
        if(!(role == Rel.LEADER)){
            return;
        }


        List<MPlayer> mPlayers = faction.getMPlayers();
        int i = 0;
        for(MPlayer mPlayer : mPlayers){
            if(!mPlayer.isOffline()) {


                if (mPlayer.getRole().equals(Rel.OFFICER)) {
                    ItemStack stack = new ItemBuilder(Material.SKULL_ITEM, 1, (byte) 3).setSkullOwner(mPlayer.getName()).setName("§cPromouvoir " + mPlayer.getName() + " chef ?").setLore(" ", mPlayer.getName()).toItemStack();
                    inventory.addItem(stack);
                }
            }


        }

        player.getPlayer().openInventory(inventory);




    }



}
