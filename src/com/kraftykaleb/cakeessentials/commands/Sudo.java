package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Sudo implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (sender.hasPermission("essentials.sudo")) {
			if (args.length < 2) {
				sender.sendMessage(ChatColor.RED + "Usage: /sudo <player> <command>");
				return true;
			}
			Player t = Bukkit.getServer().getPlayer(args[0]);
			
			String command = "";

			for (int i = 1; i < args.length; i++) {
				String arg = args[i] + " ";
				command = command + arg;
			}
			
			
			if (t == null) {
				sender.sendMessage(ChatColor.RED + "That player is not online!");
				return true;
			}
			
			t.chat("/" + command);
			sender.sendMessage(ChatColor.GREEN + "You forced " + t.getCustomName() + ChatColor.GREEN + " to run '" + command + "'.");
			return true;
		} else {
			sender.sendMessage(ChatColor.RED + "You do not have permission to run this command!");
			return true;
		}
		
	}

}
