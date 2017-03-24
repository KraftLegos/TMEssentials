package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kraftykaleb.cakeessentials.CakeEssentials;


public class Warp implements CommandExecutor {

	private CakeEssentials plugin;

	public Warp(CakeEssentials pl) {
		plugin = pl;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to run this command!");
			return true;
		}
		
		Player p = (Player) sender;
		
		String warplist = plugin.getWarpsConfig1().getString("warpslist");
		
		if (warplist == null) warplist = "NO WARPS DEFINED";
		
		if (args.length != 1) {
			p.sendMessage(ChatColor.GREEN + "AVALABLE WARPS: " + ChatColor.ITALIC + warplist);
			return true;
		}
		if ((plugin.getWarpsConfig1().getString("warps." + args[0].toUpperCase())) != null) {
			
			World w = Bukkit.getServer().getWorld(plugin.getWarpsConfig1().getString("warps." + args[0].toUpperCase() + ".world"));

			double x = plugin.getWarpsConfig1().getDouble("warps." + args[0].toUpperCase() + ".x");
			double y = plugin.getWarpsConfig1().getDouble("warps." + args[0].toUpperCase() + ".y");
			double z = plugin.getWarpsConfig1().getDouble("warps." + args[0].toUpperCase() + ".z");

			float yaw = Float.parseFloat(plugin.getWarpsConfig1().getString("warps" + "." + args[0].toUpperCase() + ".yaw"));
			float pitch = Float.parseFloat(plugin.getWarpsConfig1().getString("warps" + "." + args[0].toUpperCase() + ".pitch"));

			Location warp = new Location(w, x, y, z, yaw, pitch);
			
			p.teleport(warp);
			
			p.sendMessage(ChatColor.GREEN + "Teleporting...");
			return true;
		} else {
			p.sendMessage(ChatColor.RED + "That warp does not exist!");
			p.sendMessage(ChatColor.RED + "AVALABLE WARPS: " + ChatColor.ITALIC + warplist);
		}
		return true;
	}

}
