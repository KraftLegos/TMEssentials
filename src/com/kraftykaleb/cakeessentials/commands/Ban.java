package com.kraftykaleb.cakeessentials.commands;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kraftykaleb.cakeessentials.CakeEssentials;

public class Ban implements CommandExecutor {

	private CakeEssentials plugin;

	public Ban(CakeEssentials pl) {
		plugin = pl;
	}
	
	public static HashMap<String, String> permbanlist = new HashMap<>();

	Date now = new Date();
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("kbans.ban")) {
			if (args.length < 2) {
				sender.sendMessage(ChatColor.RED + "Invalid arguments! Please use: /ban <player> <reason>");
				return true;
			}
			String banReason = "";

			for (int i = 1; i < args.length; i++) {
				String arg = args[i] + " ";
				banReason = banReason + arg;
			}
			Player t = Bukkit.getServer().getPlayer(args[0]);
			@SuppressWarnings("deprecation")
			OfflinePlayer offline = Bukkit.getServer().getOfflinePlayer(args[0]);
			if (t == null) {
				// permbanlist.put(offline.getName(), args[1]);
				plugin.getConfig().set("permban." + offline.getUniqueId().toString() + ".reason", banReason);
				plugin.getConfig().set("permban." + offline.getUniqueId().toString() + ".name", offline.getName());
				plugin.getConfig().set("permban." + offline.getUniqueId().toString() + ".BannedbBy", sender.getName());
				plugin.getConfig().set("permban." + offline.getUniqueId().toString() + ".length", "Perm");
				plugin.getConfig().set("permban." + offline.getUniqueId().toString() + ".time", format.format(now));
				try {
					Integer bans = plugin.getConfig().getInt(args[0].toLowerCase() + ".info.bans");
					plugin.getConfig().set(args[0].toLowerCase() + ".info.bans", bans + 1);
					plugin.getConfig().set(args[0].toLowerCase() + ".info.isbanned", "TRUE");
				} catch (Exception e) {
					plugin.getConfig().set(args[0].toLowerCase() + ".info.bans", 1);
				}
				plugin.saveConfig();
				for(Player p : Bukkit.getServer().getOnlinePlayers()) {
					if (p.hasPermission("essentials.staff")) {
					p.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.WHITE + sender.getName() + " banned '" + args[0] + "' for '" + banReason + "'.");
					}
				}
				return true;
			} else if (t.hasPermission("essentials.ban.admin")) {
				if (sender.hasPermission("essentials.ban.all")) {

					t.setOp(false);
					for (Player p : Bukkit.getServer().getOnlinePlayers()) {
						if (p.hasPermission("essentials.staff")) {
						p.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.WHITE + sender.getName() + " banned '" + args[0] + "' for '" + banReason + "'.");
						p.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.WHITE + sender.getName() + " kicked '" + args[0] + "' for '" + banReason + "'.");
						}
					}
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pex user " + t.getName() + " group set nonmember");
					Bukkit.getServer().broadcastMessage("[ANTICHEAT] " + ChatColor.RED + ChatColor.BOLD
							+ "A user has been removed from the server for hacking or abuse! Thanks for reporting it!");
					// permbanlist.put(t.getName(), "banned");
					plugin.getConfig().set("permban." + t.getUniqueId().toString() + ".reason", banReason);
					plugin.getConfig().set("permban." + t.getUniqueId().toString() + ".name", t.getName());
					plugin.getConfig().set("permban." + t.getUniqueId().toString() + ".BannedbBy", sender.getName());
					plugin.getConfig().set("permban." + t.getUniqueId().toString() + ".length", "Perm");
					plugin.getConfig().set("permban." + t.getUniqueId().toString() + ".time", format.format(now));
					
					Integer bans = plugin.getConfig().getInt(args[0].toLowerCase() + ".info.bans");
					plugin.getConfig().set(args[0].toLowerCase() + ".info.bans", bans + 1);
					plugin.getConfig().set(args[0].toLowerCase() + ".info.isbanned", "TRUE");
					
					plugin.saveConfig();
					t.kickPlayer("[" + plugin.getConfig().getString("permban." + t.getUniqueId().toString() + ".time")
							+ "] " + ChatColor.RED + "You have been permanently banned!" + "\n"
							+ ChatColor.RESET + "Reason: "
							+ plugin.getConfig().getString("permban." + t.getUniqueId().toString() + ".reason") + "\n"
							+ "If you feel this ban is wrong, Appeal on slack!");
					return true;
				} else {
					sender.sendMessage(
							"[BANS] " + ChatColor.RED + ChatColor.BOLD + "You are unable to ban this player.");
					return true;
				}
			} else {
				for (Player p : Bukkit.getServer().getOnlinePlayers()) {
					if (p.hasPermission("essentials.staff")) {
					p.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.WHITE + sender.getName() + " kicked '" + args[0] + "' for '" + banReason + "'.");
					p.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.WHITE + sender.getName() + " banned '" + args[0] + "' for '" + banReason + "'.");
					}
				}
				Bukkit.getServer().broadcastMessage("[ANTICHEAT] " + ChatColor.RED + ChatColor.BOLD
						+ "A user has been removed from the server for hacking or abuse! Thanks for reporting it!");
				plugin.getConfig().set("permban." + t.getUniqueId().toString() + ".reason", banReason);
				plugin.getConfig().set("permban." + t.getUniqueId().toString() + ".name", t.getName());
				plugin.getConfig().set("permban." + t.getUniqueId().toString() + ".BannedbBy", sender.getName());
				plugin.getConfig().set("permban." + t.getUniqueId().toString() + ".length", "Perm");
				plugin.getConfig().set("permban." + t.getUniqueId().toString() + ".time", format.format(now));
				
				Integer bans = plugin.getConfig().getInt(args[0].toLowerCase() + ".info.bans");
				plugin.getConfig().set(args[0].toLowerCase() + ".info.bans", bans + 1);
				plugin.getConfig().set(args[0].toLowerCase() + ".info.isbanned", "TRUE");
				
				plugin.saveConfig();
				t.kickPlayer("[" + plugin.getConfig().getString("permban." + t.getUniqueId().toString() + ".time")
						+ "] " + ChatColor.RED + "You have been permanently banned!" + "\n"
						+ ChatColor.RESET + "Reason: " + plugin.getConfig().getString("permban." + t.getUniqueId().toString() + ".reason")
						+ "\n" + "If you feel this ban is wrong, Appeal on slack!");
				return true;
			}
		} else {
			sender.sendMessage(ChatColor.RED + "You must be of the " + ChatColor.DARK_GREEN + "[MOD]" + ChatColor.RED + " rank to use this command!");
			return true;
		}
	}

	public static HashMap<String, String> getPermBanMap() {
		return permbanlist;
	}

	public static void setPermBan(String player, String banMessage) {
		return;
	}

}
