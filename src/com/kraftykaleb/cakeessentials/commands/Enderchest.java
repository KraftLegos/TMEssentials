package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Enderchest implements CommandExecutor {

public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(label.equalsIgnoreCase("enderchest")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				Player t = Bukkit.getServer().getPlayer(args[0]);
				if (p.hasPermission("essentials.enderchest")) {
					if (t == null) {
						p.sendMessage(ChatColor.RED + "That player is offline or doesn't exist!");
						return true;
					}
					if ((args.length != 1) || (args[0].equalsIgnoreCase(p.getName()) || (t.getAddress().toString().equals(p.getAddress().toString())))) {
						p.sendMessage(ChatColor.RED + "Missing arguments! Please use /enderchest <player>");
						return true;
					} else {
					
					Inventory inv = t.getEnderChest();
					p.openInventory(inv);
					p.sendMessage(ChatColor.GREEN + "Opened the enderchest of " + t.getCustomName());
					
					return true;
					}
				} else {
					p.sendMessage(ChatColor.RED + "You must be of the " + ChatColor.DARK_GREEN + "[MOD] " + ChatColor.RED + "rank to use this command!");
					return true;
				}
			} else {
				sender.sendMessage("You must be a player to run this command!");
				return true;
			}
		}
		
		return true;
	}

}

