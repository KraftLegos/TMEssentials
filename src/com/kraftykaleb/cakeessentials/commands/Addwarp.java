package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kraftykaleb.cakeessentials.CakeEssentials;

public class Addwarp implements CommandExecutor {

	private CakeEssentials plugin;

	public Addwarp(CakeEssentials pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) {

			return true;
		}

		if (!sender.hasPermission("essentials.addwarp")) {
			sender.sendMessage(ChatColor.RED + "You must be of the [ADMIN] Rank to use that command!");
			return true;
		}
		
		Player p = (Player) sender;

		String warpslist = (plugin.getWarpsConfig1().getString("warpslist"));
		
		
		
		if (warpslist == null) {
			plugin.getWarpsConfig1().set("warpslist", args[0].toUpperCase());
		} else {
			String warps = (warpslist + ", " + args[0].toUpperCase()).replace("null", "");

			plugin.getWarpsConfig1().set("warpslist", warps);
		}
		
		plugin.getWarpsConfig1().set("warps." + args[0].toUpperCase() + ".world", p.getLocation().getWorld().getName());
		plugin.getWarpsConfig1().set("warps." + args[0].toUpperCase() + ".x", p.getLocation().getX());
		plugin.getWarpsConfig1().set("warps." + args[0].toUpperCase() + ".y", p.getLocation().getY());
		plugin.getWarpsConfig1().set("warps." + args[0].toUpperCase() + ".z", p.getLocation().getZ());
		plugin.getWarpsConfig1().set("warps." + args[0].toUpperCase() + ".pitch", p.getLocation().getPitch());
		plugin.getWarpsConfig1().set("warps." + args[0].toUpperCase() + ".yaw", p.getLocation().getYaw());
		plugin.saveWarpsConfig();

		p.sendMessage(ChatColor.GREEN + "Successfully set a warp named " + ChatColor.ITALIC + args[0].toUpperCase() + ChatColor.RESET
				+ ChatColor.GREEN + " to your current location!");
		return true;

	}

}
