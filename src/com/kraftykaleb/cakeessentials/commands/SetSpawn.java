package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kraftykaleb.cakeessentials.CakeEssentials;

public class SetSpawn implements CommandExecutor {

	private CakeEssentials plugin;

	public SetSpawn(CakeEssentials pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("setspawn")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("You must be a player to run this command!");
				return true;
			}
				Player player = (Player) sender;
				
				if (!player.hasPermission("essentials.fly")) {
					player.sendMessage(ChatColor.RED + "You must be of the [ADMIN] rank to use this command!");
					return true;
				}
				
				plugin.getConfig().set("spawn.world", player.getLocation().getWorld().getName());
				plugin.getConfig().set("spawn.x", player.getLocation().getX());
				plugin.getConfig().set("spawn.y", player.getLocation().getY());
				plugin.getConfig().set("spawn.z", player.getLocation().getZ());
				plugin.getConfig().set("spawn.pitch", player.getLocation().getPitch());
				plugin.getConfig().set("spawn.yaw", player.getLocation().getYaw());
				plugin.saveConfig();
				player.sendMessage(ChatColor.GREEN + "Spawnpoint set!");
				return true;

			}

		return true;
	}
}
