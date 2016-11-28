package fr.colin.factiongui;

import fr.colin.factiongui.commands.FactionGuiAdminCommand;
import fr.colin.factiongui.commands.FactionGuiCommand;
import fr.colin.factiongui.events.EventsManager;
import fr.colin.factiongui.events.PlayerInventoryClick;
import fr.colin.factiongui.events.PlayerInventoryClick2;
import fr.colin.factiongui.events.PlayerInventoryClick3;
import fr.colin.factiongui.utils.confirmationmenu.LeaderConfirmationMenu;
import fr.colin.factiongui.utils.confirmationmenu.events.LeaderConfirmationMenuInventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Admin on 07/10/2016.
 */
public class FactionGUI extends JavaPlugin {


    private static FactionGUI instance;

    @Override
    public void onEnable() {
        getCommand("fguiadmin").setExecutor(new FactionGuiAdminCommand());
        getCommand("fgui").setExecutor(new FactionGuiCommand());
        new EventsManager(this, new PlayerInventoryClick(), new PlayerInventoryClick2(), new PlayerInventoryClick3(), new LeaderConfirmationMenuInventoryClickEvent());
        super.onEnable();
        instance = this;

    }

    public static FactionGUI getInstance() {
        return instance;
    }
}
