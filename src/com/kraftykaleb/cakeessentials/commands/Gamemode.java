package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("gamemode") || label.equalsIgnoreCase("gm") || label.equalsIgnoreCase("mode")) {
			if (sender.hasPermission("essentials.gamemode")) {
				if (args.length == 0) {
					sender.sendMessage(
							ChatColor.RED + "You forgot to enter a gamemode! Please use /gamemode <mode> <player>");
					return true;
				} else if (args.length >= 1) {
					if (args[0].equalsIgnoreCase("survival") || args[0].equalsIgnoreCase("0")) {
						if (args.length == 2) {
							otherPlayer(sender, args[1], GameMode.SURVIVAL);
							return true;
						} else {
							otherPlayer(sender, sender.getName(), GameMode.SURVIVAL);
							return true;
						}
					}
					if (args[0].equalsIgnoreCase("s")) {
						if (args.length == 2) {
							otherPlayer(sender, args[1], GameMode.SURVIVAL);
							return true;
						} else {
							otherPlayer(sender, sender.getName(), GameMode.SURVIVAL);
							return true;
						}
					}
					if (args[0].equalsIgnoreCase("creative") || args[0].equalsIgnoreCase("1")) {
						if (args.length == 2) {
							otherPlayer(sender, args[1], GameMode.CREATIVE);
							return true;
						} else {
							otherPlayer(sender, sender.getName(), GameMode.CREATIVE);
							return true;
						}
					}
					if (args[0].equalsIgnoreCase("c")) {
						if (args.length == 2) {
							otherPlayer(sender, args[1], GameMode.CREATIVE);
							return true;
						} else {
							otherPlayer(sender, sender.getName(), GameMode.CREATIVE);
							return true;
						}
					}
					if (args[0].equalsIgnoreCase("spectator") || args[0].equalsIgnoreCase("3")) {
						if (args.length == 2) {
							otherPlayer(sender, args[1], GameMode.SPECTATOR);
							return true;
						} else {
							otherPlayer(sender, sender.getName(), GameMode.SPECTATOR);
							return true;
						}
					}
					if (args[0].equalsIgnoreCase("sp")) {
						if (args.length == 2) {
							otherPlayer(sender, args[1], GameMode.SPECTATOR);
							return true;
						} else {
							otherPlayer(sender, sender.getName(), GameMode.SPECTATOR);
							return true;
						}
					}
					if (args[0].equalsIgnoreCase("adventure") || args[0].equalsIgnoreCase("2")) {
						if (args.length == 2) {
							otherPlayer(sender, args[1], GameMode.ADVENTURE);
							return true;
						} else {
							otherPlayer(sender, sender.getName(), GameMode.ADVENTURE);
							return true;
						}
					}
					if (args[0].equalsIgnoreCase("a")) {
						if (args.length == 2) {
							otherPlayer(sender, args[1], GameMode.ADVENTURE);
							return true;
						} else {
							otherPlayer(sender, sender.getName(), GameMode.ADVENTURE);
							return true;
						}
					} else {
						sender.sendMessage(ChatColor.RED
								+ "That is not a valid gamemode! Try using 'Creative, Survival, Adventure or Spectator");
						return true;
					}
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You must be of the [ADMIN] rank to use this command!");
				return true;
			}
		}

		return true;
	}

	public void otherPlayer(CommandSender sender, String player, GameMode gamemode) {
		Player p = Bukkit.getServer().getPlayer(player);
		if (p == null) {
			sender.sendMessage("Could not find the player '" + player + "'! Please try again!");
			return;
		} else {
			p.setGameMode(gamemode);
			sender.sendMessage(ChatColor.GREEN + "You changed " + p.getCustomName() + ChatColor.GREEN
					+ "'s gamemode to " + gamemode);
			p.sendMessage(ChatColor.GREEN + "Your gamemode is now " + gamemode + "!");
			return;
		}
	}

}
