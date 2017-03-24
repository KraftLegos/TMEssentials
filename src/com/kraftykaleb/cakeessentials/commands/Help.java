package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Help implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (label.equalsIgnoreCase("help")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You must be a player to use this command!");
				return true;
			}
			Player player = (Player) sender;
			player.sendMessage(ChatColor.AQUA + "-------------------------------");
			player.sendMessage(ChatColor.GOLD + "         Factions Help         ");
			player.sendMessage(ChatColor.YELLOW + " - /help");
			player.sendMessage(ChatColor.YELLOW + " - /factions");
			player.sendMessage(ChatColor.YELLOW + " - /warp");
			player.sendMessage(ChatColor.YELLOW + " - /spawn");
			player.sendMessage(ChatColor.YELLOW + " - /shop");
			player.sendMessage(ChatColor.YELLOW + " - /home");
			player.sendMessage(ChatColor.YELLOW + " - /server");
			player.sendMessage(ChatColor.YELLOW + " - /class");
			player.sendMessage(ChatColor.AQUA + "-------------------------------");

			return true;
		}
		return true;
	}
}
