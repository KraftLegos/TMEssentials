package com.kraftykaleb.cakeessentials.event.player;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;

import com.kraftykaleb.cakeessentials.CakeEssentials;
import com.kraftykaleb.cakeessentials.economy.EconManager;

public class PlayerJoin implements Listener {

	private CakeEssentials plugin;

	public PlayerJoin(CakeEssentials pl) {
		plugin = pl;
	}

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
	Date date = new Date();
	// (dateFormat.format(date));

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(PlayerLoginEvent e) {
		Player p = e.getPlayer();
		if (plugin.getConfig().contains("permban." + e.getPlayer().getUniqueId())) {
			e.disallow(PlayerLoginEvent.Result.KICK_BANNED,
					"[" + plugin.getConfig().getString("permban." + e.getPlayer().getUniqueId().toString() + ".time")
							+ "] " + ChatColor.RED + "You are permanently banned!" + ChatColor.RESET + "\n" + "Reason: "
							+ plugin.getConfig()
									.getString("permban." + e.getPlayer().getUniqueId().toString() + ".reason")
							+ "\n" + "If you feel this ban is wrong, Appeal on slack!");
		}

		if (plugin.getConfig().getString(p.getName() + ".hasjoined") == null) {
			if (plugin.getConfig().get(p.getName().toLowerCase() + ".info.bans") == null) {
				plugin.getConfig().get(p.getName().toLowerCase() + ".info.bans", 0);
			}
			if (plugin.getConfig().get(p.getName().toLowerCase() + ".info.kicks") == null) {
				plugin.getConfig().set(p.getName().toLowerCase() + ".info.kicks", 0);
			}
			plugin.getConfig().set(p.getName().toLowerCase() + ".info.isbanned", "FALSE");
			plugin.getConfig().set(p.getName().toLowerCase() + ".info.UUID", p.getUniqueId().toString());
			plugin.getConfig().set(p.getName().toLowerCase() + ".info.firstlogin", (dateFormat.format(date)));
			plugin.saveConfig();
			plugin.getConfig().set(p.getName().toLowerCase() + ".hasjoined", "Yes");
			plugin.saveConfig();
			return;
		}
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();

		String ip = p.getAddress().getAddress().getHostAddress();

		plugin.getConfig().set(p.getName().toLowerCase() + ".info.ip", ip);
		plugin.getConfig().set(p.getName().toLowerCase() + ".info.lastlogin", (dateFormat.format(date)));
		plugin.getConfig().set(p.getName().toLowerCase() + ".info.vanished", "FALSE");
		plugin.getConfig().set(p.getName().toLowerCase() + ".info.customname", p.getCustomName());
		plugin.saveConfig();
		if (!EconManager.hasAccount(p.getUniqueId().toString())) {
			EconManager.setBalance(p.getUniqueId().toString(), 100D);
		}
		
		//plugin.getServer().dispatchCommand(Bukkit.getConsoleSender(), "minecraft:tp " + p.getName() + " 1000 75 1000");
		
		
		
		
		
		// for (Player player : Bukkit.getServer().getOnlinePlayers()) {
		if (plugin.getConfig().getString(p.getName().toLowerCase() + ".hasjoined") != null) {
			if (p.hasPermission("joins.message")) {
				//@SuppressWarnings("unused")
				//String joinMessage = ChatColor.translateAlternateColorCodes('&',
						//plugin.getConfig().getString("JoinMessage").replace("%player%", p.getCustomName()));
				event.setJoinMessage(p.getCustomName() + ChatColor.YELLOW + " joined.");
				for (Player t : Bukkit.getServer().getOnlinePlayers()) {
					t.playSound(t.getLocation(), Sound.ENTITY_LIGHTNING_THUNDER, 1, 1);
				}
			} else {
				event.setJoinMessage(null);
			}
		} else {
			event.setJoinMessage(null);
		}

		if (plugin.getConfig().getString(p.getName() + ".hasjoined.firstlogin") == null) {
			
		}

		// }
		String welcomeMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("MOTD"));

		Player player = event.getPlayer();
		player.sendMessage(welcomeMessage);
		// event.setJoinMessage(player.getDisplayName() + ChatColor.YELLOW +
		// "joined.");
		//Bukkit.broadcastMessage(event.getJoinMessage());
		p.setPlayerListName(p.getCustomName());
		// player.sendMessage((dateFormat.format(date)));
	}
}
