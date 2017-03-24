package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mkremins.fanciful.FancyMessage;

public class Tp implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("tp")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You must be a player to run this command!");
				return true;
			}
			Player player = (Player) sender;
			if (player.hasPermission("essentials.tp")) {
				if (args.length == 0) {
					player.sendMessage(ChatColor.RED + "Please specify a player to teleport to!");
					return true;
				} else {
					if (args.length == 1) {
						Player target = Bukkit.getServer().getPlayer(args[0]);
						if (target == null) {
							player.sendMessage("Could not find the player '" + args[0] + "'!");
							new FancyMessage("Click here to try again!").color(ChatColor.RED).style(ChatColor.ITALIC)
									.suggest("/tp").send(sender);
						} else {
							player.teleport(target.getLocation());
							return true;
						}
					} else if (args.length == 3) {
						double x = Double.parseDouble(args[0]);
						double y = Double.parseDouble(args[1]);
						double z = Double.parseDouble(args[2]);
						
						Location l = player.getLocation();
						
						l.setX(x);
						l.setY(y);
						l.setZ(z);
						
						player.teleport(l);
						return true;
					} else {
						player.sendMessage(ChatColor.RED + "Usage: /tp <player> or /tp <x> <y> <z>");
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
