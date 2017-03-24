package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kraftykaleb.cakeessentials.economy.EconManager;

public class Coins implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Please use /coins <set/add/remove> <player>");
				return true;
			} else {
				Player p = (Player) sender;
				Double bal = EconManager.getBalance(p.getUniqueId().toString());
				
				p.sendMessage(ChatColor.GOLD + "You currently have " + bal + " coins!");
				//p.sendMessage("DEBUG: " + EconManager.getBalanceMap());
				return true;
			}
		}
		if (args.length == 3) {
			Player t = Bukkit.getServer().getPlayer(args[1]);
			//UUID uuid = t.getUniqueId();
			if (args[0].equalsIgnoreCase("add")) {
				if (!EconManager.hasAccount(t.getUniqueId().toString())) {
					sender.sendMessage(ChatColor.RED + "That player has never joined the server!");
					return true;
				}
				double amount = 0;

				try {
					amount = Double.parseDouble(args[2]);
				} catch (Exception e) {
					sender.sendMessage(ChatColor.RED + "You must use a number value!");
					return true;
				}

				EconManager.setBalance(t.getUniqueId().toString(), EconManager.getBalance(t.getUniqueId().toString()) + amount);
				sender.sendMessage(ChatColor.GREEN + "You added " + amount + " to the player " + args[1] + ", now they have " + EconManager.getBalance(t.getUniqueId().toString()));
			} else if (args[0].equalsIgnoreCase("remove")) {
				if (!EconManager.hasAccount(t.getUniqueId().toString())) {
					sender.sendMessage(ChatColor.RED + "That player has never joined the server!");
					return true;
				}
				double amount = 0;

				try {
					amount = Double.parseDouble(args[2]);
				} catch (Exception e) {
					sender.sendMessage(ChatColor.RED + "You must use a number value!");
					return true;
				}

				EconManager.setBalance(t.getUniqueId().toString(), EconManager.getBalance(t.getUniqueId().toString()) - amount);
				sender.sendMessage(ChatColor.GREEN + "You added " + amount + " to the player " + args[1] + ", now they have " + EconManager.getBalance(t.getUniqueId().toString()));
			} else if (args[0].equalsIgnoreCase("set")) {
				if (!EconManager.hasAccount(t.getUniqueId().toString())) {
					sender.sendMessage(ChatColor.RED + "That player has never joined the server!");
					return true;
				}
				double amount = 0;

				try {
					amount = Double.parseDouble(args[2]);
				} catch (Exception e) {
					sender.sendMessage(ChatColor.RED + "You must use a number value!");
					return true;
				}

				EconManager.setBalance(t.getUniqueId().toString(), amount);
				sender.sendMessage(ChatColor.GREEN + "You added " + amount + " to the player " + args[1] + ", now they have " + EconManager.getBalance(t.getUniqueId().toString()));
			} else {
				sender.sendMessage(ChatColor.RED + "Please use /coins set/add/remove");
			}
		} else {
			sender.sendMessage(ChatColor.RED + "Please use /coins set/add/remove");
		}
		// if(sender.hasPermission("economy.use")) {
		// }

		return true;
	}

}
