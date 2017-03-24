package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kraftykaleb.cakeessentials.CakeEssentials;

public class Msg implements CommandExecutor {

	private static CakeEssentials plugin;

	public Msg(CakeEssentials pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("msg") || label.equalsIgnoreCase("tell") || label.equalsIgnoreCase("m")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("failed");
				return true;
			} else {
				Player p = (Player) sender;
				if (args.length >= 2) {
					Player t = Bukkit.getServer().getPlayer(args[0]);
					if (t == null) {
						
						p.sendMessage(ChatColor.RED + "That player could not be found"
								+ "! Please try again later.");
						
						return true;
					} else {
						plugin.messages.put(t, p);
						String message = "";

						for (int i = 1; i < args.length; i++) {
							String arg = args[i] + " ";
							message = message + arg;
						}
						
						p.sendMessage(ChatColor.LIGHT_PURPLE + "To " + t.getCustomName() + ChatColor.GRAY + ": " + message);
						t.sendMessage(ChatColor.LIGHT_PURPLE + "From " + p.getCustomName() + ChatColor.GRAY + ": " + message);
						return true;
					}
				} else {
					p.sendMessage(ChatColor.RED + "Please include a message with that command! Usage: /msg <player> <message>");
					return true;
				}
			}
		}
		
		if (label.equalsIgnoreCase("r") || label.equalsIgnoreCase("reply")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				
				if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "Please include a message with that command! Usage: /r <message>");
					return true;
				} else {
					if (plugin.messages.get(p) != null) {
						
						Player t = Bukkit.getServer().getPlayer(plugin.messages.get(p).getName());
						
						if (t == null) {
							p.sendMessage(ChatColor.RED + "That player is no longer online! Please try again later.");
							return true;
						}
						
						String message = "";

						for (int i = 0; i < args.length; i++) {
							String arg = args[i] + " ";
							message = message + arg;
						}
						plugin.messages.put(t, p);
						
						p.sendMessage(ChatColor.LIGHT_PURPLE + "To " + t.getCustomName() + ChatColor.GRAY + ": " + message);
						t.sendMessage(ChatColor.LIGHT_PURPLE + "From " + p.getCustomName() + ChatColor.GRAY + ": " + message);
						return true;
					} else {
						p.sendMessage(ChatColor.RED + "You haven't been messaged by a player yet!");
						return true;
					}
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You must be a player to use this command!");
			}
		}
		return true;
	}

}
