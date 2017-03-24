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

public class Spawn implements CommandExecutor {
	
	private CakeEssentials plugin;

	public Spawn(CakeEssentials pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("You must be a player to use this command!");
			return true;
		}
		Player player;
		player = (Player) sender;
		World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("spawn.world"));
		double x = plugin.getConfig().getDouble("spawn.x");
		double y = plugin.getConfig().getDouble("spawn.y");
		double z = plugin.getConfig().getDouble("spawn.z");
		
		//String valueFromConfig = getConfig().getString("my.path");
		//float myFloat = Float.parseFloat(valueFromConfig);
		
		float yaw = Float.parseFloat(plugin.getConfig().getString("spawn.yaw"));
		float pitch = Float.parseFloat(plugin.getConfig().getString("spawn.pitch"));
		
		
		Location spawn = new Location(w, x, y, z, yaw, pitch);
		player.sendMessage(ChatColor.GREEN + "Teleporting...");
		player.teleport(spawn);
		return true;
	}

}
