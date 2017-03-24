package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sc implements CommandExecutor {

	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("essentials.staffchat")) {
		Player player = (Player) sender;
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (p.hasPermission("essentials.staffchat")) {
				String message = "";
				if (args.length == 0) {
					sender.sendMessage(ChatColor.RED + "Usage: /sc <message>");
					return true;
				}
				for (int i = 0; i < args.length; i++) {
					String arg = args[i] + " ";
					message = message + arg;
				}
				p.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.RESET + player.getCustomName() + ": " + ChatColor.RESET + message);
			}
		}
		return true;
		}
		return true;
	}

}
