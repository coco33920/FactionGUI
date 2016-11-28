package fr.colin.factiongui.events;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

/**
 * Created by Admin on 07/10/2016.
 */
public class EventsManager {


    public EventsManager(Plugin pl, Listener... listeners) {

        PluginManager pm = Bukkit.getPluginManager();

        for (int i = 0; i < listeners.length; i++) {
            pm.registerEvents(listeners[i], pl);
        }


    }

}
