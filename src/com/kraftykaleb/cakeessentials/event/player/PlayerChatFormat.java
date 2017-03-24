package com.kraftykaleb.cakeessentials.event.player;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.kraftykaleb.cakeessentials.CakeEssentials;

public class PlayerChatFormat implements Listener {

	// @SuppressWarnings("unused")
	private CakeEssentials plugin;

	public PlayerChatFormat(CakeEssentials pl) {
		plugin = pl;
	}

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		//MPlayer u = MPlayer.get(p);
		String faction = "";
		//if (u.hasFaction() == false)
		//	faction = ChatColor.GRAY + " [WILD]" + ChatColor.GRAY;
		e.setCancelled(true);
		/*
		 * if(this.getRank(p).equals("A")) { e.setCancelled(true);
		 */
		// p.setPlayerListName(p.getCustomName());
		// p.setCustomNameVisible(true);

		if (plugin.getConfig().getString(p.getName() + ".nickname") == null) {
			if (p.hasPermission("chat.master")) {
				p.setPlayerListName("§c[MASTER] " + p.getName() + faction);
				p.setCustomName("§c[MASTER] " + p.getName() + "§f");
				p.setCustomNameVisible(true);
			}
			if (p.hasPermission("chat.co")) {
				p.setPlayerListName("§c[CO-MASTER] " + p.getName() + faction);
				p.setCustomName("§c[CO-MASTER] " + p.getName() + "§f");
				p.setCustomNameVisible(true);
			}
			if (p.hasPermission("chat.admin")) {
				p.setPlayerListName("§c[ADMIN] " + p.getName() + faction);
				p.setCustomName("§c[ADMIN] " + p.getName() + "§f");
				p.setCustomNameVisible(true);
			}
			if (p.hasPermission("chat.mod")) {
				p.setPlayerListName("§2[MOD] " + p.getName() + faction);
				p.setCustomName("§2[MOD] " + p.getName() + "§f");
				p.setCustomNameVisible(true);
			}
			if (p.hasPermission("chat.helper")) {
				p.setPlayerListName("§9[HELPER] " + p.getName() + faction);
				p.setCustomName("§9[HELPER] " + p.getName() + "§f");
				p.setCustomNameVisible(true);
			}
			//if (p.hasPermission("chat.buildteam")) {
			//	p.setPlayerListName("§3[BUILDTEAM] " + p.getName() + faction);
			//	p.setCustomName("§3[BUILDTEAM] " + p.getName() + "§f");
			//	p.setCustomNameVisible(true);
			//}
			if (p.hasPermission("chat.yt")) {
				p.setPlayerListName("§6[YT] " + p.getName() + faction);
				p.setCustomName("§6[YT] " + p.getName() + "§f");
				p.setCustomNameVisible(true);
			}/*
			if (p.hasPermission("chat.mvpplus")) {
				p.setPlayerListName("§b[MVP§c+§b] " + p.getName() + faction);
				p.setCustomName("§b[MVP§c+§b] " + p.getName() + "§f");
				p.setCustomNameVisible(true);
			}
			if (p.hasPermission("chat.mvp")) {
				p.setPlayerListName("§b[MVP] " + p.getName() + faction);
				p.setCustomName("§b[MVP] " + p.getName() + "§f");
				p.setCustomNameVisible(true);
			}
			if (p.hasPermission("chat.vipplus")) {
				p.setPlayerListName("§a[VIP§6+§a] " + p.getName() + faction);
				p.setCustomName("§a[VIP§6+§a] " + p.getName() + "§f");
				p.setCustomNameVisible(true);
			}*/
			if (p.hasPermission("chat.vip")) {
				p.setPlayerListName("§a[VIP] " + p.getName() + faction);
				p.setCustomName("§a[VIP] " + p.getName() + "§f");
				p.setCustomNameVisible(true);
			}
			if (p.hasPermission("chat.default")) {

				p.setPlayerListName("§7" + p.getName() + faction);
				p.setCustomName("§7" + p.getName() + "§f");
				p.setCustomNameVisible(true);

			}
		} else {
			String nickname = plugin.getConfig().getString(p.getName() + ".nickname");
			p.setPlayerListName("§a[VIP§a] " + nickname + faction);
			p.setCustomName("§a[VIP§a] " + nickname + "§f");
			p.setCustomNameVisible(true);
		}
		if (p.hasPermission("essentials.chatcolor")) {
			for (Player online : Bukkit.getServer().getOnlinePlayers()) {
				online.sendMessage(p.getCustomName() + faction + " » "
						+ ChatColor.translateAlternateColorCodes('&', e.getMessage()));
			}
		} else {
			String message = e.getMessage();
		    message = message.replace("&a", "");
		    message = message.replace("&b", "");
		    message = message.replace("&c", "");
		    message = message.replace("&d", "");
		    message = message.replace("&e", "");
		    message = message.replace("&f", "");
		    message = message.replace("&1", "");
		    message = message.replace("&2", "");
		    message = message.replace("&3", "");
		    message = message.replace("&4", "");
		    message = message.replace("&5", "");
		    message = message.replace("&6", "");
		    message = message.replace("&7", "");
		    message = message.replace("&8", "");
		    message = message.replace("&9", "");
		    message = message.replace("&0", "");
		    message = message.replace("&l", "");
		    message = message.replace("&m", "");
		    message = message.replace("&n", "");
		    message = message.replace("&o", "");
		    e.setMessage(message);
			//for (Player online : Bukkit.getServer().getOnlinePlayers()) {
			//	online.sendMessage(p.getCustomName() + faction + " » " + e.getMessage());
			//}
		    Logger logger = plugin.getLogger();
		    
		    Bukkit.getServer().broadcastMessage(p.getCustomName() + faction + " » " + e.getMessage());
		    logger.info(p.getName() + faction + " » " + e.getMessage());
		}

	}

}
