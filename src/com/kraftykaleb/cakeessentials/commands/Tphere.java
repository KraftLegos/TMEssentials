package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mkremins.fanciful.FancyMessage;

public class Tphere implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("tphere") || label.equalsIgnoreCase("s") || label.equalsIgnoreCase("tpme")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You must be a player to run this command!");
				return true;
			}
			Player player = (Player) sender;
			if (player.hasPermission("essentials.tphere")) {
				if (args.length == 0) {
					player.sendMessage(ChatColor.RED + "Please specify a player to teleport to you!");
					new FancyMessage("Click here to try again!").color(ChatColor.RED).style(ChatColor.ITALIC).suggest("/tphere").send(sender);
					return true;
				}

				if (args.length == 1) {
					Player target = Bukkit.getServer().getPlayer(args[0]);
					if (target == null) {
						player.sendMessage(ChatColor.RED + "Could not find the player '" + args[0] + "'!");
						new FancyMessage("Click here to try again!").color(ChatColor.RED).style(ChatColor.ITALIC).suggest("/tphere").send(sender);
					} else {
						target.teleport(player.getLocation());
						return true;
					}
				}
			} else {
				player.sendMessage(ChatColor.RED + "You must be of the [ADMIN] rank to run this command!");
				return true;
			}

		}

		return true;
	}

}
