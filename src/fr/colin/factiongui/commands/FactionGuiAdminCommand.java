package fr.colin.factiongui.commands;

import com.massivecraft.factions.entity.MPlayer;
import fr.colin.factiongui.utils.Utils;
import fr.colin.factiongui.utils.confirmationmenu.LeaderConfirmationMenu;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Admin on 07/10/2016.
 */
public class FactionGuiAdminCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] label) {

        Player p = (Player) sender;
        p.sendMessage("" + MPlayer.get(p).hasFaction() + " " + MPlayer.get(p).getFaction().getName() + " " + MPlayer.get(p).getName());


        return false;
    }
}
