package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kraftykaleb.cakeessentials.CakeEssentials;

public class Unban implements CommandExecutor {

	private CakeEssentials plugin;

	public Unban(CakeEssentials pl) {
		plugin = pl;
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("essentials.unban")) {
			if (!(args.length == 1)) {
				sender.sendMessage("[BANS] " + ChatColor.RED + ChatColor.BOLD + "Usage: /unban <player>");
				return true;
			} else {
				Player t = Bukkit.getServer().getPlayer(args[0]);
				@SuppressWarnings("deprecation")
				OfflinePlayer offline = Bukkit.getServer().getOfflinePlayer(args[0]);
				if (t == null) {
					if (plugin.getConfig().contains("permban." + offline.getUniqueId().toString())) {
						plugin.getConfig().set("permban." + offline.getUniqueId().toString(), null);
						plugin.getConfig().set(args[0].toLowerCase() + ".info.isbanned", "FALSE");
						plugin.saveConfig();
						for (Player p : Bukkit.getServer().getOnlinePlayers()) {
							if (p.hasPermission("essentials.ban")) {
							p.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.WHITE + sender.getName() + " unbanned '" + args[0] + "'.");
							}
						}
						return true;
					} else {
						sender.sendMessage("[BANS] " + ChatColor.RED + ChatColor.BOLD + args[0] +" is not banned");
						return true;
					}
				} else {
					if (plugin.getConfig().contains("permban." + t.getUniqueId().toString())) {
						plugin.getConfig().set("permban." + t.getUniqueId().toString(), null);
						plugin.getConfig().set(args[0].toLowerCase() + ".info.isbanned", "FALSE");
						plugin.saveConfig();
						for (Player p : Bukkit.getServer().getOnlinePlayers()) {
							if (p.hasPermission("essentials.ban")) {
							p.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.WHITE + sender.getName() + " unbanned '" + args[0] + "'.");
							}
						}
						return true;
					} else {
						sender.sendMessage("[BANS] " + ChatColor.RED + ChatColor.BOLD + args[0] +" is not banned");
						return true;
					}
				}
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You must be of the MOD rank to use this command!");
			return true;
		}
	}

}
