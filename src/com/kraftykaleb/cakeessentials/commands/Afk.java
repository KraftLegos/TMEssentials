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
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import com.kraftykaleb.cakeessentials.CakeEssentials;

@SuppressWarnings("deprecation")
public class Afk implements CommandExecutor, Listener {

	private CakeEssentials plugin;

	public Afk(CakeEssentials pl) {
		plugin = pl;
	}

	public Scoreboard board;
	// public Objective o;
	// public Score s;
	public String debug = ChatColor.YELLOW + "[DEBUG] ";

	// @SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		if (board == null) {
			board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();
			// o = board.registerNewObjective("coins", "dummy");
			// o.setDisplayName("Coins");
			// o.setDisplaySlot(DisplaySlot.SIDEBAR);

			// s = o.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Number:
			// "));

			// s.setScore(EconManager.getBalance(p.getUniqueId().toString()).intValue());
		}
		board = Bukkit.getServer().getScoreboardManager().getMainScoreboard();

		// s = o.getScore(Bukkit.getOfflinePlayer(ChatColor.GREEN + "Number:
		// "));
		// s.setScore(EconManager.getBalance(p.getUniqueId().toString()).intValue());

		Team teamdefault = board.getTeam("DEFAULT");
		Team teamvip = board.getTeam("VIP");
		// Team teamvipplus = board.getTeam("VIPPLUS");
		// Team teammvp = board.getTeam("MVP");
		// Team teammvpplus = board.getTeam("MVPPLUS");
		// Team teambuildteam = board.getTeam("BUILDTEAM");
		Team teamyt = board.getTeam("YT");
		Team teamhelper = board.getTeam("HELPER");
		Team teammod = board.getTeam("MOD");
		Team teamadmin = board.getTeam("ADMIN");
		Team teamco = board.getTeam("COMASTER");
		Team teamowner = board.getTeam("MASTER");

		// MPlayer u = MPlayer.get(p);
		/*
		 * if (u.hasFaction()) { //String faction = "§7 [" + u.getFactionName()
		 * + "]"; if (plugin.getConfig().getString(p.getName() + ".nickname") ==
		 * null) { if (p.hasPermission("chat.default")) { if (teamdefault ==
		 * null) { teamdefault = board.registerNewTeam("DEFAULT");
		 * teamdefault.setSuffix(faction); teamdefault.setPrefix("§7");
		 * teamdefault.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } else if
		 * (teamdefault.getEntries().contains(p.getName()) == false) {
		 * teamdefault.setSuffix(faction); teamdefault.setPrefix("§7");
		 * teamdefault.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } } if
		 * (p.hasPermission("chat.vip")) { if (teamvip == null) { teamvip =
		 * board.registerNewTeam("VIP"); teamvip.setSuffix(faction);
		 * teamvip.setPrefix("§a[VIP] "); teamvip.addEntry(p.getName()); for
		 * (Player online : Bukkit.getOnlinePlayers()) {
		 * online.setScoreboard(board); } } else if
		 * (teamvip.getEntries().contains(p.getName()) == false) {
		 * teamvip.setSuffix(faction); teamvip.setPrefix("§a[VIP] ");
		 * teamvip.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } } if
		 * (p.hasPermission("chat.vipplus")) { if (teamvipplus == null) {
		 * teamvipplus = board.registerNewTeam("VIPPLUS");
		 * teamvipplus.setSuffix(faction); teamvipplus.setPrefix("§a[VIP§6+§a] "
		 * ); teamvipplus.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } else if
		 * (teamvipplus.getEntries().contains(p.getName()) == false) {
		 * teamvipplus.setSuffix(faction); teamvipplus.setPrefix("§a[VIP§6+§a] "
		 * ); teamvipplus.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } } if
		 * (p.hasPermission("chat.mvp")) { if (teammvp == null) { teammvp =
		 * board.registerNewTeam("MVP"); teammvp.setSuffix(faction);
		 * teammvp.setPrefix("§b[MVP] "); teammvp.addEntry(p.getName()); for
		 * (Player online : Bukkit.getOnlinePlayers()) {
		 * online.setScoreboard(board); } } else if
		 * (teammvp.getEntries().contains(p.getName()) == false) {
		 * teammvp.setSuffix(faction); teammvp.setPrefix("§b[MVP] ");
		 * teammvp.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } } if
		 * (p.hasPermission("chat.mvpplus")) { if (teammvpplus == null) {
		 * teammvpplus = board.registerNewTeam("MVPPLUS");
		 * teammvpplus.setSuffix(faction); teammvpplus.setPrefix("§b[MVP§c+§b] "
		 * ); teammvpplus.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } else if
		 * (teammvpplus.getEntries().contains(p.getName()) == false) {
		 * teammvpplus.setSuffix(faction); teammvpplus.setPrefix("§b[MVP§c+§b] "
		 * ); teammvpplus.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } } if
		 * (p.hasPermission("chat.buildteam")) { if (teambuildteam == null) {
		 * teambuildteam = board.registerNewTeam("BUILDTEAM");
		 * teambuildteam.setSuffix(faction); teambuildteam.setPrefix(
		 * "§3[BUILDTEAM] "); teambuildteam.addEntry(p.getName()); for (Player
		 * online : Bukkit.getOnlinePlayers()) { online.setScoreboard(board); }
		 * } else if (teambuildteam.getEntries().contains(p.getName()) == false)
		 * { teambuildteam.setSuffix(faction); teambuildteam.setPrefix(
		 * "§3[BUILDTEAM] "); teambuildteam.addEntry(p.getName()); for (Player
		 * online : Bukkit.getOnlinePlayers()) { online.setScoreboard(board); }
		 * } } if (p.hasPermission("chat.yt")) { if (teamyt == null) { teamyt =
		 * board.registerNewTeam("YT"); teamyt.setSuffix(faction);
		 * teamyt.setPrefix("§6[YT] "); teamyt.addEntry(p.getName()); for
		 * (Player online : Bukkit.getOnlinePlayers()) {
		 * online.setScoreboard(board); } } else if
		 * (teamyt.getEntries().contains(p.getName()) == false) {
		 * teamyt.setSuffix(faction); teamyt.setPrefix("§6[YT] ");
		 * teamyt.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } } if
		 * (p.hasPermission("chat.helper")) { if (teamhelper == null) {
		 * teamhelper = board.registerNewTeam("HELPER");
		 * teamhelper.setSuffix(faction); teamhelper.setPrefix("§9[HELPER] ");
		 * teamhelper.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } else if
		 * (teamhelper.getEntries().contains(p.getName()) == false) {
		 * teamhelper.setSuffix(faction); teamhelper.setPrefix("§9[HELPER] ");
		 * teamhelper.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } } if
		 * (p.hasPermission("chat.mod")) { if (teammod == null) { teammod =
		 * board.registerNewTeam("MOD"); teammod.setSuffix(faction);
		 * teammod.setPrefix("§2[MOD] "); teammod.addEntry(p.getName()); for
		 * (Player online : Bukkit.getOnlinePlayers()) {
		 * online.setScoreboard(board); } } else if
		 * (teammod.getEntries().contains(p.getName()) == false) {
		 * teammod.setSuffix(faction); teammod.setPrefix("§2[MOD] ");
		 * teammod.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } } if
		 * (p.hasPermission("chat.admin")) { if (teamadmin == null) { teamadmin
		 * = board.registerNewTeam("ADMIN"); teamadmin.setSuffix(faction);
		 * teamadmin.setPrefix("§c[ADMIN] "); teamadmin.addEntry(p.getName());
		 * for (Player online : Bukkit.getOnlinePlayers()) {
		 * online.setScoreboard(board); } } else if
		 * (teamadmin.getEntries().contains(p.getName()) == false) {
		 * teamadmin.setSuffix(faction); teamadmin.setPrefix("§c[ADMIN] ");
		 * teamadmin.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } } if
		 * (p.hasPermission("chat.co")) { if (teamco == null) { teamco =
		 * board.registerNewTeam("COOWNER"); teamco.setSuffix(faction);
		 * teamco.setPrefix("§c[COOWNER] "); teamco.addEntry(p.getName()); for
		 * (Player online : Bukkit.getOnlinePlayers()) {
		 * online.setScoreboard(board); } } else if
		 * (teamco.getEntries().contains(p.getName()) == false) {
		 * teamco.setSuffix(faction); teamco.setPrefix("§c[COOWNER] ");
		 * teamco.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } } if
		 * (p.hasPermission("chat.owner")) { if (teamowner == null) { teamowner
		 * = board.registerNewTeam("OWNER"); teamowner.setSuffix(faction);
		 * teamowner.setPrefix("§c[OWNER] "); teamowner.addEntry(p.getName());
		 * for (Player online : Bukkit.getOnlinePlayers()) {
		 * online.setScoreboard(board); } } else if
		 * (teamowner.getEntries().contains(p.getName()) == false) {
		 * teamowner.setSuffix(faction); teamowner.setPrefix("§c[OWNER] ");
		 * teamowner.addEntry(p.getName()); for (Player online :
		 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } } }
		 * else { String nickname = plugin.getConfig().getString(p.getName() +
		 * ".nickname"); if (teamvip == null) { teamvip =
		 * board.registerNewTeam("VIP"); teamvip.setSuffix(faction);
		 * teamvip.setPrefix("§a[VIP] "); teamvip.addEntry(nickname); for
		 * (Player online : Bukkit.getOnlinePlayers()) {
		 * online.setScoreboard(board); } } else if
		 * (teamvip.getEntries().contains(nickname) == false) {
		 * teamvip.setSuffix(" §a[VIP]"); teamdefault.addEntry(nickname); for
		 * (Player online : Bukkit.getOnlinePlayers()) {
		 * online.setScoreboard(board); } } } } else {
		 */
		// String faction = ChatColor.GRAY + " [WILD]";
		if (plugin.getConfig().getString(p.getName().toLowerCase() + ".nickname") == null) {
			if (p.hasPermission("chat.default")) {
				if (teamdefault == null) {
					teamdefault = board.registerNewTeam("DEFAULT");
					// teamdefault.setSuffix(faction);
					teamdefault.setPrefix("§7");
					teamdefault.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				} else if (teamdefault.getEntries().contains(p.getName()) == false) {
					// teamdefault.setSuffix(faction);
					teamdefault.setPrefix("§7");
					teamdefault.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				}
			}
			if (p.hasPermission("chat.vip")) {
				if (teamvip == null) {
					teamvip = board.registerNewTeam("VIP");
					// teamvip.setSuffix(faction);
					teamvip.setPrefix("§a[VIP] ");
					teamvip.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				} else if (teamvip.getEntries().contains(p.getName()) == false) {
					// teamvip.setSuffix(faction);
					teamvip.setPrefix("§a[VIP] ");
					teamvip.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				}
			}
			/*
			 * if (p.hasPermission("chat.vipplus")) { if (teamvipplus == null) {
			 * teamvipplus = board.registerNewTeam("VIPPLUS");
			 * //teamvipplus.setSuffix(faction); teamvipplus.setPrefix(
			 * "§a[VIP§6+§a] "); teamvipplus.addEntry(p.getName()); for (Player
			 * online : Bukkit.getOnlinePlayers()) {
			 * online.setScoreboard(board); } } else if
			 * (teamvipplus.getEntries().contains(p.getName()) == false) {
			 * //teamvipplus.setSuffix(faction); teamvipplus.setPrefix(
			 * "§a[VIP§6+§a] "); teamvipplus.addEntry(p.getName()); for (Player
			 * online : Bukkit.getOnlinePlayers()) {
			 * online.setScoreboard(board); } } } if
			 * (p.hasPermission("chat.mvp")) { if (teammvp == null) { teammvp =
			 * board.registerNewTeam("MVP"); //teammvp.setSuffix(faction);
			 * teammvp.setPrefix("§b[MVP] "); teammvp.addEntry(p.getName()); for
			 * (Player online : Bukkit.getOnlinePlayers()) {
			 * online.setScoreboard(board); } } else if
			 * (teammvp.getEntries().contains(p.getName()) == false) {
			 * //teammvp.setSuffix(faction); teammvp.setPrefix("§b[MVP] ");
			 * teammvp.addEntry(p.getName()); for (Player online :
			 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); } } }
			 * if (p.hasPermission("chat.mvpplus")) { if (teammvpplus == null) {
			 * teammvpplus = board.registerNewTeam("MVPPLUS");
			 * //teammvpplus.setSuffix(faction); teammvpplus.setPrefix(
			 * "§b[MVP§c+§b] "); teammvpplus.addEntry(p.getName()); for (Player
			 * online : Bukkit.getOnlinePlayers()) {
			 * online.setScoreboard(board); } } else if
			 * (teammvpplus.getEntries().contains(p.getName()) == false) {
			 * //teammvpplus.setSuffix(faction); teammvpplus.setPrefix(
			 * "§b[MVP§c+§b] "); teammvpplus.addEntry(p.getName()); for (Player
			 * online : Bukkit.getOnlinePlayers()) {
			 * online.setScoreboard(board); } } } if
			 * (p.hasPermission("chat.buildteam")) { if (teambuildteam == null)
			 * { teambuildteam = board.registerNewTeam("BUILDTEAM");
			 * //teambuildteam.setSuffix(faction); teambuildteam.setPrefix(
			 * "§3[BUILDTEAM] "); teambuildteam.addEntry(p.getName()); for
			 * (Player online : Bukkit.getOnlinePlayers()) {
			 * online.setScoreboard(board); } } else if
			 * (teambuildteam.getEntries().contains(p.getName()) == false) {
			 * //teambuildteam.setSuffix(faction); teambuildteam.setPrefix(
			 * "§3[BUILDTEAM] "); teambuildteam.addEntry(p.getName()); for
			 * (Player online : Bukkit.getOnlinePlayers()) {
			 * online.setScoreboard(board); } } }
			 */
			if (p.hasPermission("chat.yt")) {
				if (teamyt == null) {
					teamyt = board.registerNewTeam("YT");
					// teamyt.setSuffix(faction);
					teamyt.setPrefix("§6[YT] ");
					teamyt.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				} else if (teamyt.getEntries().contains(p.getName()) == false) {
					// teamyt.setSuffix(faction);
					teamyt.setPrefix("§6[YT] ");
					teamyt.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				}
			}
			if (p.hasPermission("chat.helper")) {
				if (teamhelper == null) {
					teamhelper = board.registerNewTeam("HELPER");
					// teamhelper.setSuffix(faction);
					teamhelper.setPrefix("§9[HELPER] ");
					teamhelper.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				} else if (teamhelper.getEntries().contains(p.getName()) == false) {
					// teamhelper.setSuffix(faction);
					teamhelper.setPrefix("§9[HELPER] ");
					teamhelper.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				}
			}
			if (p.hasPermission("chat.mod")) {
				if (teammod == null) {
					teammod = board.registerNewTeam("MOD");
					// teammod.setSuffix(faction);
					teammod.setPrefix("§2[MOD] ");
					teammod.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				} else if (teammod.getEntries().contains(p.getName()) == false) {
					// teammod.setSuffix(faction);
					teammod.setPrefix("§2[MOD] ");
					teammod.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				}
			}
			if (p.hasPermission("chat.admin")) {
				if (teamadmin == null) {
					teamadmin = board.registerNewTeam("ADMIN");
					// teamadmin.setSuffix(faction);
					teamadmin.setPrefix("§c[ADMIN] ");
					teamadmin.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				} else if (teamadmin.getEntries().contains(p.getName()) == false) {
					// teamadmin.setSuffix(faction);
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
					// teamco.setSuffix(faction);
					teamco.setPrefix("§c[COMASTER] ");
					teamco.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				} else if (teamco.getEntries().contains(p.getName()) == false) {
					// teamco.setSuffix(faction);
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
					// teamowner.setSuffix(faction);
					teamowner.setPrefix("§c[MASTER] ");
					teamowner.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				} else if (teamowner.getEntries().contains(p.getName()) == false) {
					// teamowner.setSuffix(faction);
					teamowner.setPrefix("§c[MASTER] ");
					teamowner.addEntry(p.getName());
					for (Player online : Bukkit.getOnlinePlayers()) {
						online.setScoreboard(board);
					}
				}
			}
		} else {
			String nickname = plugin.getConfig().getString(p.getName() + ".nickname");
			if (teamvip == null) {
				teamvip = board.registerNewTeam("VIP");
				// teamvip.setSuffix(faction);
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
			}
		}

		p.setScoreboard(board);
	}

	static ArrayList<String> afked = new ArrayList<String>();

	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		String pname = p.getName();
		if (afked.contains(pname)) {
			afked.remove(pname);
			Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "* " + p.getCustomName() + ChatColor.GRAY + " is no longer AFK *");
			return;
		}
	}
	
	@EventHandler
	public void onChat(PlayerChatEvent e) {
		Player p = e.getPlayer();
		String pname = p.getName();
		if (afked.contains(pname)) {
			afked.remove(pname);
			Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "* " + p.getCustomName() + ChatColor.GRAY + " is no longer AFK *");
			return;
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("afk")) {
			Player p = (Player) sender;
			if (p.hasPermission("essentials.afk")) {
				if (afked.contains(p.getName())){
					Bukkit.broadcastMessage("");
					afked.remove(p.getName());
					Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "* " + p.getCustomName() + ChatColor.GRAY + " is no longer AFK *");
					return true;
				} else {
					afked.add(p.getName());
					Bukkit.getServer().broadcastMessage(ChatColor.GRAY + "* " + p.getCustomName() + ChatColor.GRAY + " is now AFK *");
					return true;
				}
			} else {
				p.sendMessage(ChatColor.RED + "You must be of the " + ChatColor.GREEN + "[VIP] " + ChatColor.RED + "rank to use this command!");
				return true;
			}
			
			/*
			 * if (board == null) { board =
			 * Bukkit.getServer().getScoreboardManager().getNewScoreboard(); }
			 * 
			 * Team team = board.getTeam("AFK");
			 * 
			 * if (team == null) { team = board.registerNewTeam("AFK");
			 * team.setSuffix(" §e[AFK]"); team.addEntry(p.getName()); for
			 * (Player online : Bukkit.getOnlinePlayers()) {
			 * online.setScoreboard(board); } p.sendMessage(ChatColor.GREEN +
			 * "You are now afk!"); return true; } else if
			 * (team.getEntries().contains(p.getName()) == false) {
			 * team.setSuffix(" §c[AFK]"); team.addEntry(p.getName()); for
			 * (Player online : Bukkit.getOnlinePlayers()) {
			 * online.setScoreboard(board); } p.sendMessage(ChatColor.GREEN +
			 * "You are now afk!"); return true; } else {
			 * team.removeEntry(p.getName()); for (Player online :
			 * Bukkit.getOnlinePlayers()) { online.setScoreboard(board); }
			 * p.sendMessage(ChatColor.GREEN + "You are no longer afk"); }
			 */
		}

		return true;
	}
}
