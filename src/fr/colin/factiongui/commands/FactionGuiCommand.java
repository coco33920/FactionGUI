package fr.colin.factiongui.commands;

import fr.colin.factiongui.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Admin on 07/10/2016.
 */
public class FactionGuiCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        Player p = (Player) commandSender;
        Utils.getInstance().openInventory(p, 1);

        return false;
    }
}
