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

public class Home implements CommandExecutor {

	private CakeEssentials plugin;

	public Home(CakeEssentials pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("home")) {
			if (sender instanceof Player) {
				Player p = (Player) sender;
				if (args.length == 0) {
						if (plugin.getConfig().get(p.getName().toLowerCase() + ".home") != null) {
							if (plugin.getConfig().get(p.getName().toLowerCase() + ".home.x") != null) {
								World w = Bukkit.getServer().getWorld(plugin.getConfig().getString(p.getName().toLowerCase() + ".home.world"));

								double x = plugin.getConfig().getDouble(p.getName().toLowerCase() + ".home.x");
								double y = plugin.getConfig().getDouble(p.getName().toLowerCase() + ".home.y");
								double z = plugin.getConfig().getDouble(p.getName().toLowerCase() + ".home.z");

								float yaw = Float.parseFloat(plugin.getConfig().getString(p.getName().toLowerCase() + ".home.yaw"));
								float pitch = Float.parseFloat(plugin.getConfig().getString(p.getName().toLowerCase() + ".home.pitch"));

								Location home = new Location(w, x, y, z, yaw, pitch);
								p.sendMessage(ChatColor.RED + "A home was found on our old home system! Please use set a home using /sethome again to prevent yourself from loosing this home!" + ChatColor.BOLD + "THIS FEATURE WILL BE REMOVED SOON!");
								p.teleport(home);
							}
							//Set<String> homeslist = plugin.getConfig().getConfigurationSection(p.getName().toLowerCase() + ".homes.list").getKeys(false);
							//.getStringList(p.getName().toLowerCase() + ".homes.list");
							String homeslist = plugin.getConfig().getString(p.getName().toLowerCase() + ".homes.list");
							
							p.sendMessage(ChatColor.RED + "Home not found!");
							p.sendMessage(ChatColor.RED + "Your current homes are: " + homeslist);
							return true;

					} else {
						p.sendMessage(ChatColor.RED + "You have no homes! Type /sethome <name> to set a home!");
						return true;
					}
				} else if (args.length == 1) {
					if ((plugin.getConfig().get(p.getName().toLowerCase() + ".home." + args[0].toUpperCase())) != null) {
						World w = Bukkit.getServer().getWorld(plugin.getConfig().getString(p.getName().toLowerCase() + ".home." + args[0].toUpperCase() + ".world"));

						double x = plugin.getConfig().getDouble(p.getName().toLowerCase() + ".home." + args[0].toUpperCase() + ".x");
						double y = plugin.getConfig().getDouble(p.getName().toLowerCase() + ".home." + args[0].toUpperCase() + ".y");
						double z = plugin.getConfig().getDouble(p.getName().toLowerCase() + ".home." + args[0].toUpperCase() + ".z");

						float yaw = Float.parseFloat(plugin.getConfig().getString(p.getName().toLowerCase() + ".home." + args[0].toUpperCase() + ".yaw"));
						float pitch = Float.parseFloat(plugin.getConfig().getString(p.getName().toLowerCase() + ".home." + args[0].toUpperCase() + ".pitch"));

						Location home = new Location(w, x, y, z, yaw, pitch);
						p.sendMessage(ChatColor.GREEN + "Teleporting...");
						p.teleport(home);

						return true;
					} else {
						//Set<String> homeslist = plugin.getConfig().getConfigurationSection(p.getName().toLowerCase() + ".homes.list").getKeys(false);
						//.getStringList(p.getName().toLowerCase() + ".homes.list");
						String homeslist = plugin.getConfig().getString(p.getName().toLowerCase() + ".homes.list");
						
						p.sendMessage(ChatColor.RED + "Home not found!");
						p.sendMessage(ChatColor.RED + "Your current homes are: " + homeslist);
						return true;
					}
				}
			} else {
				sender.sendMessage("You must be a player to warp to a home!");
				return true;
			}
		}
		return true;
	}
}
