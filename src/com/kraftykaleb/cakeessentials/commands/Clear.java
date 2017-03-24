package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import net.md_5.bungee.api.ChatColor;

public class Clear implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (args.length == 0) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You must be a player to run this command!");
				return false;
			}
			Player player = (Player) sender;
			PlayerInventory inv = player.getInventory();
			inv.setHelmet(null);
			inv.setChestplate(null);
			inv.setLeggings(null);
			inv.setBoots(null);
			inv.clear();
			player.sendMessage(ChatColor.GREEN + "Inventory Cleared!");
			return true;
		} else if (args.length == 1) {
			Player p = Bukkit.getServer().getPlayer(args[0]);
			if (sender.hasPermission("clear.others")) {
				if (p == null) {
					sender.sendMessage(ChatColor.RED + "That player is not online!");
					return true;
				} else {
					PlayerInventory inv = p.getInventory();
					inv.setHelmet(null);
					inv.setChestplate(null);
					inv.setLeggings(null);
					inv.setBoots(null);
					inv.clear();
					p.sendMessage(ChatColor.GREEN + "Inventory Cleared!");
					sender.sendMessage(
							ChatColor.GREEN + "Cleared inventory of " + p.getCustomName() + ChatColor.GREEN + "!");
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You must be of the " + ChatColor.DARK_GREEN + "[MOD] " + ChatColor.RED + "rank to use this command!");
				return true;
			}
		}
		return true;
	}
}
