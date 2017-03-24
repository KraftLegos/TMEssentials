package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kraftykaleb.cakeessentials.CakeEssentials;

import mkremins.fanciful.FancyMessage;

public class Userinfo implements CommandExecutor {

	private CakeEssentials plugin;

	public Userinfo(CakeEssentials pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (sender.hasPermission("essentials.userinfo")) {
			if (!(args.length == 1)) {
				sender.sendMessage(ChatColor.RED + "Arguments: /userinfo <name>");
				return true;
			} else {
				Player t = Bukkit.getServer().getPlayer(args[0]);
				if (t == null) {
					try {
						if (!((plugin.getConfig().getString(args[0].toLowerCase() + ".hasjoined").equals(null)))) {
							sender.sendMessage(plugin.getConfig().getString(args[0].toLowerCase() + ".info.customname"));
							sender.sendMessage(ChatColor.GOLD + "Connection Status: " + ChatColor.GRAY
									+ ChatColor.ITALIC + "Offline");
							sender.sendMessage(ChatColor.GOLD + "Last login: " + ChatColor.WHITE
									+ plugin.getConfig().getString(args[0].toLowerCase() + ".info.lastlogin"));
							sender.sendMessage(ChatColor.GOLD + "First login: " + ChatColor.WHITE
									+ plugin.getConfig().getString(args[0].toLowerCase() + ".info.firstlogin"));
							sender.sendMessage(ChatColor.GOLD + "IP: " + ChatColor.WHITE
									+ plugin.getConfig().getString(args[0].toLowerCase() + ".info.ip"));
							sender.sendMessage(ChatColor.GOLD + "Gamemode: " + ChatColor.WHITE
									+ plugin.getConfig().getString(args[0].toLowerCase() + ".info.gamemode"));
							sender.sendMessage(ChatColor.GOLD + "Location: "
									+ plugin.getConfig().getString(args[0].toLowerCase() + ".info.location"));
							if ((plugin.getConfig().get(args[0].toLowerCase() + ".info.vanished")).equals("TRUE")) {
								sender.sendMessage(ChatColor.GOLD + "Vanished: " + ChatColor.GREEN + "TRUE");
								
							} else if ((plugin.getConfig().get(args[0].toLowerCase() + ".info.vanished")).equals("FALSE")){
								sender.sendMessage(ChatColor.GOLD + "Vanished: " + ChatColor.RED + "FALSE");
								
							}
							
							if (plugin.getConfig().get(args[0].toLowerCase() + ".info.isbanned") == "FALSE") {
								sender.sendMessage(ChatColor.GOLD + "Is Banned: " + ChatColor.RED + "FALSE");
							} else if (plugin.getConfig().get(args[0].toLowerCase() + ".info.isbanned").equals("TRUE")) {
								@SuppressWarnings("deprecation")
								OfflinePlayer offline = Bukkit.getServer().getOfflinePlayer(args[0]);
								sender.sendMessage(ChatColor.GOLD + "Is Banned: " + ChatColor.GREEN + "TRUE" + ChatColor.WHITE + " Reason: " + plugin.getConfig().getString("permban." + offline.getUniqueId().toString() + ".reason"));
							}
							new FancyMessage("Punishments: ")
							.color(ChatColor.GOLD)
						.then("Bans")
						    .command("/checkbans")
						    .color(punishColor(args[0]))
						    .style(ChatColor.BOLD)
						.then(" " + (plugin.getConfig().getInt(args[0].toLowerCase() + ".info.bans")))
							.color(ChatColor.WHITE)
							.command("/checkbans")
						.then(" - ")
							.color(ChatColor.GOLD)
						.then("Kicks")
						    .command("/checkkicks")
							.color(ChatColor.GREEN)
							.style(ChatColor.BOLD)
						.then(" " + (plugin.getConfig().getInt(args[0].toLowerCase() + ".info.kicks")))
							.command("/checkkicks")
							.color(ChatColor.WHITE)
						.send(sender);
							
							return true;
						} else {
							sender.sendMessage(ChatColor.RED + "ERROR: That player has never joined!");
							return true;
						}
					} catch (Exception e) {
						sender.sendMessage(ChatColor.RED + "ERROR: That player has never joined!");
						return true;
					}
				} else {
					sender.sendMessage(t.getCustomName());
					sender.sendMessage(ChatColor.GOLD + "Connection Status: " + ChatColor.GREEN + "Online");
					sender.sendMessage(ChatColor.GOLD + "Last login: " + ChatColor.WHITE + "NOW!");
					sender.sendMessage(ChatColor.GOLD + "First login: " + ChatColor.WHITE
							+ plugin.getConfig().getString(t.getName().toLowerCase() + ".info.firstlogin"));
					sender.sendMessage(
							ChatColor.GOLD + "IP: " + ChatColor.WHITE + t.getAddress().getAddress().getHostAddress());
					sender.sendMessage(ChatColor.GOLD + "Gamemode: " + ChatColor.WHITE + t.getGameMode());
					sender.sendMessage(ChatColor.GOLD + "Location: " + ChatColor.WHITE + t.getLocation().getBlockX()
							+ ", " + t.getLocation().getBlockY() + ", " + t.getLocation().getBlockZ());
					if ((plugin.getConfig().get(args[0].toLowerCase() + ".info.vanished")).equals("TRUE")) {
						sender.sendMessage(ChatColor.GOLD + "Vanished: " + ChatColor.GREEN + "TRUE");
					} else if ((plugin.getConfig().get(args[0].toLowerCase() + ".info.vanished")).equals("FALSE")){
						sender.sendMessage(ChatColor.GOLD + "Vanished: " + ChatColor.RED + "FALSE");
					} else {
						sender.sendMessage(ChatColor.GOLD + "Vanished: " + ChatColor.RED + "FALSE");
					}
					
					if (plugin.getConfig().get(args[0].toLowerCase() + ".info.isbanned").equals("FALSE")) {
						sender.sendMessage(ChatColor.GOLD + "Is Banned: " + ChatColor.RED + "FALSE");
					} else if (plugin.getConfig().get(args[0].toLowerCase() + ".info.isbanned").equals("TRUE")) {
						sender.sendMessage(ChatColor.GOLD + "Is Banned: " + ChatColor.RED + "TRUE" + ChatColor.WHITE + "Reason: " + plugin.getConfig().getString("permban." + t.getUniqueId().toString() + ".reason"));
					}
					new FancyMessage("Punishments: ")
						.color(ChatColor.GOLD)
					.then("Bans")
					    .command("/checkbans")
					    .color(punishColor(args[0]))
					    .style(ChatColor.BOLD)
					.then(" " + (plugin.getConfig().getInt(args[0].toLowerCase() + ".info.bans")))
						.color(ChatColor.WHITE)
						.command("/checkbans")
					.then(" - ")
						.color(ChatColor.GOLD)
					.then("Kicks")
					    .command("/checkkicks")
						.color(ChatColor.GREEN)
						.style(ChatColor.BOLD)
					.then(" " + (plugin.getConfig().getInt(args[0].toLowerCase() + ".info.kicks")))
						.command("/checkkicks")
						.color(ChatColor.WHITE)
					.send(sender);
						
					return true;
				}
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You must be of the " + ChatColor.DARK_BLUE + "[HELPER] " + ChatColor.RED
					+ "rank to use this command!");
			return true;
		}
	}
	
	public ChatColor punishColor(String name) {
		if (plugin.getConfig().get(name.toLowerCase() + ".info.isbanned").equals("TRUE")) {
			return ChatColor.RED;
		} else {
			return ChatColor.GREEN;
		}
		
	}

}
