package com.kraftykaleb.cakeessentials.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.kraftykaleb.cakeessentials.CakeEssentials;

public class Vanish implements CommandExecutor, Listener {

	static ArrayList<Player> vanished = new ArrayList<Player>();

	private CakeEssentials plugin;

	public Vanish(CakeEssentials pl) {
		plugin = pl;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		for (Player p : vanished) {
			e.getPlayer().hidePlayer(p);
			// Bukkit.broadcastMessage("DEBUG: vanished " + p.getCustomName());
		}
		// Bukkit.broadcastMessage("DEBUG: vanish on join listener worked!");
		// Bukkit.broadcastMessage("DEBUG: vanished: " + vanished.size());
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("vanish") || label.equalsIgnoreCase("v")) {
			Player p = (Player) sender;

			if (p.hasPermission("essentials.vanish") == false) {
				p.sendMessage(ChatColor.RED + "You must be of the " + ChatColor.GREEN + "[MOD] " + ChatColor.RED
						+ "rank to use this command!");
				return true;
			}

			if (args.length == 0) {
				if (!(sender instanceof Player)) {
					sender.sendMessage("You must be a player to vanish, or use /vanish <player>");
					return true;
				}
				if (!vanished.contains(p)) {
					for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
						if (!pl.hasPermission("essentials.vanish")) {
							pl.hidePlayer(p);
							
						} else {
							pl.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.RESET + p.getCustomName()
									+ ChatColor.YELLOW + "'s vanish mode was enabled by " + p.getCustomName()
									+ ChatColor.YELLOW + "!");
						}
					}
					vanished.add(p);
					plugin.getConfig().set(p.getName().toLowerCase() + ".info.vanished", "TRUE");
					plugin.saveConfig();
					p.sendMessage(ChatColor.GREEN + "You enabled vanish mode for " + p.getCustomName());
					Bukkit.getServer().broadcastMessage(p.getCustomName() + ChatColor.YELLOW + " left.");

					// Bukkit.broadcastMessage("DEBUG: vanished: " +
					// vanished.size());
					return true;
				} else {
					for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
						if (!pl.hasPermission("essentials.vanish")) {
							pl.showPlayer(p);
							
						} else {
							pl.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.RESET + p.getCustomName()
									+ ChatColor.YELLOW + "'s vanish mode was disabled by " + p.getCustomName()
									+ ChatColor.YELLOW + "!");
						}
					}
					vanished.remove(p);
					plugin.getConfig().set(p.getName().toLowerCase() + ".info.vanished", "FALSE");
					plugin.saveConfig();
					p.sendMessage(ChatColor.GREEN + "You disabled vanish mode for " + p.getCustomName());
					Bukkit.getServer().broadcastMessage(p.getCustomName() + ChatColor.YELLOW + " joined.");
					// Bukkit.broadcastMessage("DEBUG: vanished: " +
					// vanished.size());
					return true;
				}
			} else if (args.length == 1) {
				Player t = Bukkit.getServer().getPlayer(args[0]);
				if (t == null) {
					sender.sendMessage(ChatColor.RED + "Could not find the player " + args[0]);
				} else if (t == p) {
					if (!vanished.contains(p)) {
						for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
							if (!pl.hasPermission("essentials.vanish")) {
								pl.hidePlayer(p);
								
							} else {
								pl.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.RESET + p.getCustomName()
										+ ChatColor.YELLOW + "'s vanish mode was enabled by " + p.getCustomName()
										+ ChatColor.YELLOW + "!");
							}
						}
						vanished.add(p);
						plugin.getConfig().set(p.getName().toLowerCase() + ".info.vanished", "TRUE");
						plugin.saveConfig();
						p.sendMessage(ChatColor.GREEN + "You enabled vanish mode for " + t.getCustomName());
						Bukkit.getServer().broadcastMessage(p.getCustomName() + ChatColor.YELLOW + " left.");
						return true;
					} else {
						for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
							if (!pl.hasPermission("essentials.vanish")) {
								pl.showPlayer(p);
								
							} else {
								pl.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.RESET + p.getCustomName()
										+ ChatColor.YELLOW + "'s vanish mode was disabled by " + p.getCustomName()
										+ ChatColor.YELLOW + "!");
							}
						}
						vanished.remove(p);
						plugin.getConfig().set(p.getName().toLowerCase() + ".info.vanished", "FALSE");
						plugin.saveConfig();
						p.sendMessage(ChatColor.GREEN + "You disabled vanish mode for " + t.getCustomName());
						Bukkit.getServer().broadcastMessage(p.getCustomName() + ChatColor.YELLOW + " joined.");
						return true;
					}
				} else {
					if (!vanished.contains(t)) {
						for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
							if (!pl.hasPermission("essentials.vanish")) {
								pl.hidePlayer(t);
							} else {
								pl.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.RESET + t.getCustomName()
										+ ChatColor.YELLOW + "'s vanish mode was enabled by " + p.getCustomName()
										+ ChatColor.YELLOW + "!");
							}
						}
						vanished.add(t);
						plugin.getConfig().set(t.getName().toLowerCase() + ".info.vanished", "TRUE");
						plugin.saveConfig();
						sender.sendMessage(ChatColor.GREEN + "You enabled vanish mode for " + t.getCustomName());
						Bukkit.getServer().broadcastMessage(t.getCustomName() + ChatColor.YELLOW + " left.");
						return true;
					} else {
						for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
							if (!pl.hasPermission("essentials.vanish")) {
								pl.hidePlayer(t);
							} else {
								pl.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.RESET + t.getCustomName()
										+ ChatColor.YELLOW + "'s vanish mode was disabled by " + p.getCustomName()
										+ ChatColor.YELLOW + "!");
							}
						}
						vanished.remove(t);
						plugin.getConfig().set(p.getName().toLowerCase() + ".info.vanished", "TRUE");
						plugin.saveConfig();
						sender.sendMessage(ChatColor.GREEN + "You disabled vanish mode for " + t.getCustomName());
						Bukkit.getServer().broadcastMessage(t.getCustomName() + ChatColor.YELLOW + " joined.");
						return true;
					}
				}
			}
		}
		return true;

	}

	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		// Bukkit.broadcastMessage("DEBUG: vanished: " + vanished.size());
		Player p = e.getPlayer();
		for (Player pl : Bukkit.getServer().getOnlinePlayers()) {
			pl.showPlayer(p);
		}
		e.setQuitMessage(null);
		
		plugin.getConfig().set(p.getName().toLowerCase() + ".info.vanished", "TRUE");
		plugin.saveConfig();
		
		vanished.remove(p);
		// Bukkit.broadcastMessage("DEBUG: vanished: " + vanished.size());
	}
}
