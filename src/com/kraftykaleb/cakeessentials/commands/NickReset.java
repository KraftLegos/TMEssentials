package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kraftykaleb.cakeessentials.CakeEssentials;

//import me.libraryaddict.disguise.DisguiseAPI;

public class NickReset implements CommandExecutor {

	private CakeEssentials plugin;

	public NickReset(CakeEssentials pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("nickreset")) {
			if (sender.hasPermission("essentials.nickreset")) {
				Player p = (Player) sender;
				if (plugin.getConfig().getString(p.getName() + ".nickname") != null) {
					//DisguiseAPI.undisguiseToAll(p);
					p.setCustomName(null);
					p.setCustomNameVisible(true);
					plugin.getConfig().set(p.getName() + ".nickname", null);

					plugin.saveConfig();
					p.sendMessage(ChatColor.GREEN + "You successfully unnicked yourself");
					return true;
				} else {
					sender.sendMessage(ChatColor.RED + "You are not currently nicked!");
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You must be of the" + ChatColor.GOLD + "[YT]" + ChatColor.RED
						+ "rank or higher to use this command!");
				return true;
			}
		}

		return true;
	}

}
