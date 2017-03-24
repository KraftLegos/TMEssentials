package com.kraftykaleb.cakeessentials.event.player;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.kraftykaleb.cakeessentials.CakeEssentials;


@SuppressWarnings("unused")
public class PlayerQuit implements Listener {

	private CakeEssentials plugin;

	public PlayerQuit(CakeEssentials pl) {
		plugin = pl;
	}

	@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		// for (Player player : Bukkit.getServer().getOnlinePlayers()) {
		Player p = (Player) event.getPlayer();

		plugin.getConfig().set(p.getName().toLowerCase() + ".info.location", p.getLocation().getBlockX() + ", " + p.getLocation().getBlockY() + ", " + p.getLocation().getBlockZ());
		plugin.getConfig().set(p.getName().toLowerCase() + ".info.gamemode", p.getGameMode().toString());
		plugin.getConfig().set(p.getName().toLowerCase() + ".info.customname", p.getCustomName());
		plugin.saveConfig();
		
		if (plugin.getConfig().getString(p.getName().toLowerCase() + ".hasjoined") != null) {
			if (event.getPlayer().hasPermission("leaves.message")) {
				String leaveMessage = ChatColor.translateAlternateColorCodes('&', plugin.getConfig()
						.getString("LeaveMessage").replace("%player%", event.getPlayer().getCustomName()));
				// event.setQuitMessage(event.getPlayer().getCustomName() +
				// ChatColor.YELLOW + " left.");
				event.setQuitMessage(null);
				Bukkit.getServer().broadcastMessage(event.getPlayer().getCustomName() + ChatColor.YELLOW + " left.");
			} else {
				event.setQuitMessage(null);
			}
		} else {
			event.setQuitMessage(null);
		}
	}
}
