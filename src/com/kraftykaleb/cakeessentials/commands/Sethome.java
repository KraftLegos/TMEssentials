package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kraftykaleb.cakeessentials.CakeEssentials;

public class Sethome implements CommandExecutor {

	private CakeEssentials plugin;

	public Sethome(CakeEssentials pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("sethome")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (args.length == 0) {
					setHome("HOME", p);
					return true;
				} else if (args.length == 1){
					setHome(args[0].toUpperCase(), p);
					return true;
				} else {
					p.sendMessage("/sethome name");
				}
			} else {
				sender.sendMessage("You must be a player to set a home!");
			}

			/*
			 * if (plugin.getConfig().contains(p.getName() + ".home")) {
			 * plugin.getConfig().set(p.getName().toLowerCase() + ".home.world",
			 * p.getLocation().getWorld().getName());
			 * plugin.getConfig().set(p.getName().toLowerCase() + ".home.x",
			 * p.getLocation().getX());
			 * plugin.getConfig().set(p.getName().toLowerCase() + ".home.y",
			 * p.getLocation().getY());
			 * plugin.getConfig().set(p.getName().toLowerCase() + ".home.z",
			 * p.getLocation().getZ());
			 * plugin.getConfig().set(p.getName().toLowerCase() + ".home.pitch",
			 * p.getLocation().getPitch());
			 * plugin.getConfig().set(p.getName().toLowerCase() + ".home.yaw",
			 * p.getLocation().getYaw()); plugin.saveConfig();
			 * 
			 * p.sendMessage(ChatColor.GREEN +
			 * "Successfully set home to your current location!"); } else {
			 * plugin.getConfig().set(p.getName().toLowerCase() + ".home.world",
			 * p.getLocation().getWorld().getName());
			 * plugin.getConfig().set(p.getName().toLowerCase() + ".home.x",
			 * p.getLocation().getX());
			 * plugin.getConfig().set(p.getName().toLowerCase() + ".home.y",
			 * p.getLocation().getY());
			 * plugin.getConfig().set(p.getName().toLowerCase() + ".home.z",
			 * p.getLocation().getZ());
			 * plugin.getConfig().set(p.getName().toLowerCase() + ".home.pitch",
			 * p.getLocation().getPitch());
			 * plugin.getConfig().set(p.getName().toLowerCase() + ".home.yaw",
			 * p.getLocation().getYaw()); plugin.saveConfig();
			 * 
			 * p.sendMessage(ChatColor.GREEN +
			 * "Successfully set home to your current location!"); }
			 */
		}
		return true;
	}

	public void setHome(String homeName, Player p) {
		if ((plugin.getConfig().getString(p.getName().toLowerCase() + ".home." + homeName)) != null) {
			plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".world",
					p.getLocation().getWorld().getName());
			plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".x", p.getLocation().getX());
			plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".y", p.getLocation().getY());
			plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".z", p.getLocation().getZ());
			plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".pitch",
					p.getLocation().getPitch());
			plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".yaw", p.getLocation().getYaw());
			plugin.saveConfig();

			p.sendMessage(ChatColor.GREEN + "Successfully set a home named " + ChatColor.ITALIC + homeName
					+ ChatColor.RESET + ChatColor.GREEN + " to your current location!");
			return;
		} else {
			if ((plugin.getConfig().get(p.getName().toLowerCase() + ".homes.amount") == null)) {
				plugin.getConfig().set(p.getName().toLowerCase() + ".homes.list", homeName);

				plugin.getConfig().set(p.getName().toLowerCase() + ".homes.amount", 1);
				plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".world",
						p.getLocation().getWorld().getName());
				plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".x", p.getLocation().getX());
				plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".y", p.getLocation().getY());
				plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".z", p.getLocation().getZ());
				plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".pitch",
						p.getLocation().getPitch());
				plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".yaw",
						p.getLocation().getYaw());
				plugin.saveConfig();
				p.sendMessage(ChatColor.GREEN + "Successfully set a home named " + ChatColor.ITALIC + homeName
						+ ChatColor.RESET + ChatColor.GREEN + " to your current location!");
				return;
			} else if (plugin.getConfig().getInt(p.getName().toLowerCase() + ".homes.amount") >= 1) {
				if (!p.hasPermission("essentials.vip")) {
					p.sendMessage(ChatColor.RED + "You must be of the " + ChatColor.GREEN + "[VIP] " + ChatColor.RED + "rank to have more than 1 home!");
					return;
				} else {
					if (plugin.getConfig().getInt(p.getName().toLowerCase() + ".homes.amount") >= 3) {
						p.sendMessage(ChatColor.RED + "You must be of the " + ChatColor.GOLD + "[YT] " + ChatColor.RED + "rank to have more than 3 homes!");
						return;
					}
					String homeslist = plugin.getConfig().getString(p.getName().toLowerCase() + ".homes.list");
					
					plugin.getConfig().set(p.getName().toLowerCase() + ".homes.list", homeslist + ", " + homeName);

					plugin.getConfig().set(p.getName().toLowerCase() + ".homes.amount", plugin.getConfig().getInt(p.getName().toLowerCase() + ".homes.amount") + 1);
					plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".world",
							p.getLocation().getWorld().getName());
					plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".x", p.getLocation().getX());
					plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".y", p.getLocation().getY());
					plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".z", p.getLocation().getZ());
					plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".pitch",
							p.getLocation().getPitch());
					plugin.getConfig().set(p.getName().toLowerCase() + ".home." + homeName + ".yaw", p.getLocation().getYaw());
					plugin.saveConfig();
					p.sendMessage(ChatColor.GREEN + "Successfully set a home named " + ChatColor.ITALIC + homeName
							+ ChatColor.RESET + ChatColor.GREEN + " to your current location!");
					return;
				}
			}
		}
	}

}
