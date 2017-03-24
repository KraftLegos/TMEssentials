package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Fly implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("fly")) {
			Player player;
			if (!(sender instanceof Player)) {
				sender.sendMessage("You must be a player to run this command!");
				return true;
			}
			player = (Player) sender;
			if (!player.hasPermission("essentials.fly")) {
				player.sendMessage(ChatColor.RED + "You must be of the " + ChatColor.GOLD + "[YT] " + ChatColor.RED + "rank to use this command!");
				return true;
			}
			player.setAllowFlight(!player.getAllowFlight());
			if (player.isFlying() == true) {
				player.setFlying(false);
			}
			if (player.getAllowFlight() == true) {
				player.sendMessage(ChatColor.GREEN + "You can now fly!");
			} else if (player.getAllowFlight() == false) {
				player.sendMessage(ChatColor.GREEN + "You can no longer fly!");
			}
			return true;
		}
		return true;
	}

}
