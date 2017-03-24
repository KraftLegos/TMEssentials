package com.kraftykaleb.cakeessentials.event.player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.kraftykaleb.cakeessentials.CakeEssentials;

public class PlayerChat implements Listener {

	public static Scoreboard board;
	private CakeEssentials plugin;

	public PlayerChat(CakeEssentials main) {
		plugin = main;
	}
	
	@EventHandler
	public void onPlayerChat (final AsyncPlayerChatEvent e) {

		Player p = e.getPlayer();
		plugin.getConfig().set(p.getName().toLowerCase() + ".info.customname", p.getCustomName());
		plugin.saveConfig();
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {

			
			
			public void run() {

				Player p = e.getPlayer();
				//String message = e.getMessage().toLowerCase();
				if (board == null) {
					board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
				}
				// p.setScoreboard(board);
				board = Bukkit.getServer().getScoreboardManager().getMainScoreboard();
				Team teamdefault = board.getTeam("DEFAULT");
				Team teamvip = board.getTeam("VIP");
				//Team teamvipplus = board.getTeam("VIPPLUS");
				//Team teammvp = board.getTeam("MVP");
				//Team teammvpplus = board.getTeam("MVPPLUS");
				//Team teambuildteam = board.getTeam("BUILDTEAM");
				Team teamyt = board.getTeam("YT");
				Team teamhelper = board.getTeam("HELPER");
				Team teammod = board.getTeam("MOD");
				Team teamadmin = board.getTeam("ADMIN");
				Team teamco = board.getTeam("COMASTER");
				Team teamowner = board.getTeam("MASTER");

				/*MPlayer u = MPlayer.get(p);
				if (u.hasFaction()) {
					String faction = "§7 [" + u.getFactionName() + "]";
					if (plugin.getConfig().getString(p.getName() + ".nickname") == null) {
						if (p.hasPermission("chat.default")) {
							if (teamdefault == null) {
								teamdefault = board.registerNewTeam("DEFAULT");
								teamdefault.setSuffix(faction);
								teamdefault.setPrefix("§7");
								teamdefault.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
								return;
							} else if (teamdefault.getEntries().contains(p.getName()) == false) {
								teamdefault.setSuffix(faction);
								teamdefault.setPrefix("§7");
								teamdefault.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
								return;
							}
						}
						if (p.hasPermission("chat.vip")) {
							if (teamvip == null) {
								teamvip = board.registerNewTeam("VIP");
								teamvip.setSuffix(faction);
								teamvip.setPrefix("§a[VIP] ");
								teamvip.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teamvip.getEntries().contains(p.getName()) == false) {
								teamvip.setSuffix(faction);
								teamvip.setPrefix("§a[VIP] ");
								teamvip.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.vipplus")) {
							if (teamvipplus == null) {
								teamvipplus = board.registerNewTeam("VIPPLUS");
								teamvipplus.setSuffix(faction);
								teamvipplus.setPrefix("§a[VIP§6+§a] ");
								teamvipplus.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teamvipplus.getEntries().contains(p.getName()) == false) {
								teamvipplus.setSuffix(faction);
								teamvipplus.setPrefix("§a[VIP§6+§a] ");
								teamvipplus.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.mvp")) {
							if (teammvp == null) {
								teammvp = board.registerNewTeam("MVP");
								teammvp.setSuffix(faction);
								teammvp.setPrefix("§b[MVP] ");
								teammvp.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teammvp.getEntries().contains(p.getName()) == false) {
								teammvp.setSuffix(faction);
								teammvp.setPrefix("§b[MVP] ");
								teammvp.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.mvpplus")) {
							if (teammvpplus == null) {
								teammvpplus = board.registerNewTeam("MVPPLUS");
								teammvpplus.setSuffix(faction);
								teammvpplus.setPrefix("§b[MVP§c+§b] ");
								teammvpplus.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teammvpplus.getEntries().contains(p.getName()) == false) {
								teammvpplus.setSuffix(faction);
								teammvpplus.setPrefix("§b[MVP§c+§b] ");
								teammvpplus.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.buildteam")) {
							if (teambuildteam == null) {
								teambuildteam = board.registerNewTeam("BUILDTEAM");
								teambuildteam.setSuffix(faction);
								teambuildteam.setPrefix("§3[BUILDTEAM] ");
								teambuildteam.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teambuildteam.getEntries().contains(p.getName()) == false) {
								teambuildteam.setSuffix(faction);
								teambuildteam.setPrefix("§3[BUILDTEAM] ");
								teambuildteam.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.yt")) {
							if (teamyt == null) {
								teamyt = board.registerNewTeam("YT");
								teamyt.setSuffix(faction);
								teamyt.setPrefix("§6[YT] ");
								teamyt.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teamyt.getEntries().contains(p.getName()) == false) {
								teamyt.setSuffix(faction);
								teamyt.setPrefix("§6[YT] ");
								teamyt.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.helper")) {
							if (teamhelper == null) {
								teamhelper = board.registerNewTeam("HELPER");
								teamhelper.setSuffix(faction);
								teamhelper.setPrefix("§9[HELPER] ");
								teamhelper.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teamhelper.getEntries().contains(p.getName()) == false) {
								teamhelper.setSuffix(faction);
								teamhelper.setPrefix("§9[HELPER] ");
								teamhelper.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.mod")) {
							if (teammod == null) {
								teammod = board.registerNewTeam("MOD");
								teammod.setSuffix(faction);
								teammod.setPrefix("§2[MOD] ");
								teammod.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teammod.getEntries().contains(p.getName()) == false) {
								teammod.setSuffix(faction);
								teammod.setPrefix("§2[MOD] ");
								teammod.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.admin")) {
							if (teamadmin == null) {
								teamadmin = board.registerNewTeam("ADMIN");
								teamadmin.setSuffix(faction);
								teamadmin.setPrefix("§c[ADMIN] ");
								teamadmin.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teamadmin.getEntries().contains(p.getName()) == false) {
								teamadmin.setSuffix(faction);
								teamadmin.setPrefix("§c[ADMIN] ");
								teamadmin.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.co")) {
							if (teamco == null) {
								teamco = board.registerNewTeam("COOWNER");
								teamco.setSuffix(faction);
								teamco.setPrefix("§c[COOWNER] ");
								teamco.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							} else if (teamco.getEntries().contains(p.getName()) == false) {
								teamco.setSuffix(faction);
								teamco.setPrefix("§c[COOWNER] ");
								teamco.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.owner")) {
							if (teamowner == null) {
								teamowner = board.registerNewTeam("OWNER");
								teamowner.setSuffix(faction);
								teamowner.setPrefix("§c[OWNER] ");
								teamowner.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teamowner.getEntries().contains(p.getName()) == false) {
								teamowner.setSuffix(faction);
								teamowner.setPrefix("§c[OWNER] ");
								teamowner.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
					} else {
						String nickname = plugin.getConfig().getString(p.getName() + ".nickname");
						if (teamvip == null) {
							teamvip = board.registerNewTeam("VIP");
							teamvip.setSuffix(faction);
							teamvip.setPrefix("§a[VIP] ");
							teamvip.addEntry(nickname);
							for (Player online : Bukkit.getOnlinePlayers()) {
								online.setScoreboard(board);
							}
						} else if (teamvip.getEntries().contains(nickname) == false) {
							teamvip.setSuffix(" §a[VIP]");
							teamdefault.addEntry(nickname);
							for (Player online : Bukkit.getOnlinePlayers()) {
								online.setScoreboard(board);
							}
						}return;
					}
				} else {
					String faction = ChatColor.GRAY + " [WILD]";*/
					if (plugin.getConfig().getString(p.getName() + ".nickname") == null) {
						if (p.hasPermission("chat.default")) {
							if (teamdefault == null) {
								teamdefault = board.registerNewTeam("DEFAULT");
								//teamdefault.setSuffix(faction);
								teamdefault.setPrefix("§7");
								teamdefault.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teamdefault.getEntries().contains(p.getName()) == false) {
								//teamdefault.setSuffix(faction);
								teamdefault.setPrefix("§7");
								teamdefault.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.vip")) {
							if (teamvip == null) {
								teamvip = board.registerNewTeam("VIP");
								//teamvip.setSuffix(faction);
								teamvip.setPrefix("§a[VIP] ");
								teamvip.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teamvip.getEntries().contains(p.getName()) == false) {
								//teamvip.setSuffix(faction);
								teamvip.setPrefix("§a[VIP] ");
								teamvip.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						/*if (p.hasPermission("chat.vipplus")) {
							if (teamvipplus == null) {
								teamvipplus = board.registerNewTeam("VIPPLUS");
								//teamvipplus.setSuffix(faction);
								teamvipplus.setPrefix("§a[VIP§6+§a] ");
								teamvipplus.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teamvipplus.getEntries().contains(p.getName()) == false) {
								//teamvipplus.setSuffix(faction);
								teamvipplus.setPrefix("§a[VIP§6+§a] ");
								teamvipplus.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.mvp")) {
							if (teammvp == null) {
								teammvp = board.registerNewTeam("MVP");
								//teammvp.setSuffix(faction);
								teammvp.setPrefix("§b[MVP] ");
								teammvp.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teammvp.getEntries().contains(p.getName()) == false) {
								//teammvp.setSuffix(faction);
								teammvp.setPrefix("§b[MVP] ");
								teammvp.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.mvpplus")) {
							if (teammvpplus == null) {
								teammvpplus = board.registerNewTeam("MVPPLUS");
								//teammvpplus.setSuffix(faction);
								teammvpplus.setPrefix("§b[MVP§c+§b] ");
								teammvpplus.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teammvpplus.getEntries().contains(p.getName()) == false) {
								//teammvpplus.setSuffix(faction);
								teammvpplus.setPrefix("§b[MVP§c+§b] ");
								teammvpplus.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.buildteam")) {
							if (teambuildteam == null) {
								teambuildteam = board.registerNewTeam("BUILDTEAM");
								//teambuildteam.setSuffix(faction);
								teambuildteam.setPrefix("§3[BUILDTEAM] ");
								teambuildteam.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teambuildteam.getEntries().contains(p.getName()) == false) {
								//teambuildteam.setSuffix(faction);
								teambuildteam.setPrefix("§3[BUILDTEAM] ");
								teambuildteam.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}*/
						if (p.hasPermission("chat.yt")) {
							if (teamyt == null) {
								teamyt = board.registerNewTeam("YT");
								//teamyt.setSuffix(faction);
								teamyt.setPrefix("§6[YT] ");
								teamyt.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teamyt.getEntries().contains(p.getName()) == false) {
								//teamyt.setSuffix(faction);
								teamyt.setPrefix("§6[YT] ");
								teamyt.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.helper")) {
							if (teamhelper == null) {
								teamhelper = board.registerNewTeam("HELPER");
								//teamhelper.setSuffix(faction);
								teamhelper.setPrefix("§9[HELPER] ");
								teamhelper.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teamhelper.getEntries().contains(p.getName()) == false) {
								//teamhelper.setSuffix(faction);
								teamhelper.setPrefix("§9[HELPER] ");
								teamhelper.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.mod")) {
							if (teammod == null) {
								teammod = board.registerNewTeam("MOD");
								//teammod.setSuffix(faction);
								teammod.setPrefix("§2[MOD] ");
								teammod.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teammod.getEntries().contains(p.getName()) == false) {
								//teammod.setSuffix(faction);
								teammod.setPrefix("§2[MOD] ");
								teammod.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
						if (p.hasPermission("chat.admin")) {
							if (teamadmin == null) {
								teamadmin = board.registerNewTeam("ADMIN");
								//teamadmin.setSuffix(faction);
								teamadmin.setPrefix("§c[ADMIN] ");
								teamadmin.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}return;
							} else if (teamadmin.getEntries().contains(p.getName()) == false) {
								//teamadmin.setSuffix(faction);
								teamadmin.setPrefix("§c[ADMIN] ");
								teamadmin.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}
						}
						if (p.hasPermission("chat.co")) {
							if (teamco == null) {
								teamco = board.registerNewTeam("COMASTER");
								//teamco.setSuffix(faction);
								teamco.setPrefix("§c[COMASTER] ");
								teamco.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							} else if (teamco.getEntries().contains(p.getName()) == false) {
								//teamco.setSuffix(faction);
								teamco.setPrefix("§c[COMASTER] ");
								teamco.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}
						}
						if (p.hasPermission("chat.master")) {
							if (teamowner == null) {
								teamowner = board.registerNewTeam("MASTER");
								//teamowner.setSuffix(faction);
								teamowner.setPrefix("§c[MASTER] ");
								teamowner.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							} else if (teamowner.getEntries().contains(p.getName()) == false) {
								//teamowner.setSuffix(faction);
								teamowner.setPrefix("§c[MASTER] ");
								teamowner.addEntry(p.getName());
								for (Player online : Bukkit.getOnlinePlayers()) {
									online.setScoreboard(board);
								}
							}return;
						}
					} else {
						String nickname = plugin.getConfig().getString(p.getName() + ".nickname");
						if (teamvip == null) {
							teamvip = board.registerNewTeam("VIP");
							//teamvip.setSuffix(faction);
							teamvip.setPrefix("§a[VIP] ");
							teamvip.addEntry(nickname);
							for (Player online : Bukkit.getOnlinePlayers()) {
								online.setScoreboard(board);
							}return;
						} else if (teamvip.getEntries().contains(nickname) == false) {
							teamvip.setSuffix(" §a[VIP]");
							teamdefault.addEntry(nickname);
							for (Player online : Bukkit.getOnlinePlayers()) {
								online.setScoreboard(board);
							}
						}return;
					}
				}
				
				/*if(message.contains("dik")) {
					e.setCancelled(true);
					p.sendMessage(ChatColor.RED + "Please do not use this language in public chat!");*/
				//}
		
	
	
		}, 1L);

	}
}