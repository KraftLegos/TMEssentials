package com.kraftykaleb.cakeessentials.event.player;

import com.kraftykaleb.cakeessentials.CakeEssentials;

//import me.libraryaddict.disguise.DisguiseAPI;
//import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinName implements Listener {

	private CakeEssentials plugin;

	public PlayerJoinName(CakeEssentials pl) {
		plugin = pl;
	}

	@EventHandler

	public void onPlayerJoin(PlayerJoinEvent event) {
		Player p = event.getPlayer();
		//MPlayer u = MPlayer.get(p);
		//if (u.hasFaction()) {
			//String faction = ChatColor.GRAY + " [" + u.getFactionName() + "]";
			if (plugin.getConfig().getString(p.getName() + ".nickname") == null) {
				if (p.hasPermission("chat.master")) {
					p.setPlayerListName("§c[MASTER] " + p.getName());
					p.setCustomName("§c[MASTER] " + p.getName() + "§f");
					p.setCustomNameVisible(true);
				}
				if (p.hasPermission("chat.co")) {
					p.setPlayerListName("§c[CO-MASTER] " + p.getName());
					p.setCustomName("§c[CO-MASTER] " + p.getName() + "§f");
					p.setCustomNameVisible(true);
				}
				if (p.hasPermission("chat.admin")) {
					p.setPlayerListName("§c[ADMIN] " + p.getName());
					p.setCustomName("§c[ADMIN] " + p.getName() + "§f");
					p.setCustomNameVisible(true);
				}
				if (p.hasPermission("chat.mod")) {
					p.setPlayerListName("§2[MOD] " + p.getName());
					p.setCustomName("§2[MOD] " + p.getName() + "§f");
					p.setCustomNameVisible(true);
				}
				if (p.hasPermission("chat.helper")) {
					p.setPlayerListName("§9[HELPER] " + p.getName());
					p.setCustomName("§9[HELPER] " + p.getName() + "§f");
					p.setCustomNameVisible(true);
				}
				if (p.hasPermission("chat.yt")) {
					p.setPlayerListName("§6[YT] " + p.getName());
					p.setCustomName("§6[YT] " + p.getName() + "§f");
					p.setCustomNameVisible(true);
				}
				if (p.hasPermission("chat.vip")) {
					p.setPlayerListName("§a[VIP] " + p.getName());
					p.setCustomName("§a[VIP] " + p.getName() + "§f");
					p.setCustomNameVisible(true);
				}
				if (p.hasPermission("chat.default")) {
					p.setPlayerListName("§7" + p.getName());
					p.setCustomName("§7" + p.getName());
					p.setCustomNameVisible(true);

				}
			}  else {
				String nickname = plugin.getConfig().getString(p.getName() + ".nickname");
				//PlayerDisguise playerDisguise = new PlayerDisguise(nickname);
				//DisguiseAPI.disguiseToAll(p, playerDisguise);
				p.setPlayerListName("§a[VIP§a] " + nickname);
				p.setCustomName("§a[VIP§a] " + nickname + "§f");
				p.setCustomNameVisible(true);
			}
		/*} else {
			String faction = ChatColor.GRAY + " [WILD]";
			if (plugin.getConfig().getString(p.getName() + ".nickname") == null) {
				if (p.hasPermission("chat.master")) {
					p.setPlayerListName("§c[MASTER] " + p.getName());
					p.setCustomName("§c[MASTER] " + p.getName() + "§f");
					p.setCustomNameVisible(true);
				}
				if (p.hasPermission("chat.co")) {
					p.setPlayerListName("§c[CO-MASTER] " + p.getName());
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
				if (p.hasPermission("chat.yt")) {
					p.setPlayerListName("§6[YT] " + p.getName() + faction);
					p.setCustomName("§6[YT] " + p.getName() + "§f");
					p.setCustomNameVisible(true);
				}
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
				PlayerDisguise playerDisguise = new PlayerDisguise(nickname);
				DisguiseAPI.disguiseToAll(p, playerDisguise);
				p.setPlayerListName("§a[VIP§a] " + nickname + faction);
				p.setCustomName("§a[VIP§a] " + nickname + "§f");
				p.setCustomNameVisible(true);
			}
		}*/
	}
}
