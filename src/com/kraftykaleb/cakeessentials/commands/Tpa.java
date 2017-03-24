package com.kraftykaleb.cakeessentials.commands;

//import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kraftykaleb.cakeessentials.CakeEssentials;

import mkremins.fanciful.FancyMessage;

//import mkremins.fanciful.FancyMessage;

public class Tpa implements CommandExecutor {

	private CakeEssentials plugin;

	public Tpa(CakeEssentials pl) {
		plugin = pl;
	}
	
	//Map<String, String> tpa = new HashMap();
	//ArrayList<Player> duration = new ArrayList<Player>();
	//ArrayList<Player> tpdelay = new ArrayList<Player>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final Player p = (Player) sender;
		String playerto = plugin.getConfig().getString(p.getName().toLowerCase() + ".requestfor");
		if (label.equalsIgnoreCase("tpa")) {
			if (args.length == 0) {
				new FancyMessage("You didn't specify a player!").color(ChatColor.RED).send(p);
				return true;
			} else if (args.length == 1) {
				Player t = Bukkit.getServer().getPlayer(args[0]);
				if (t == null) {
					p.sendMessage(ChatColor.RED + "Couldn't find '" + args[0] + "'!");
					return true;
				} else if (t == p) {
					p.sendMessage(ChatColor.RED + "You cannot teleport to yourself!");
					return true;
				} else {
					plugin.getConfig().set(args[0].toLowerCase() + ".requestfor", p.getName());
					p.sendMessage(ChatColor.GREEN + "Sent a teleport request to " + t.getCustomName() + ChatColor.GREEN
							+ "!");
					t.sendMessage(
							ChatColor.GREEN + "Teleport request from " + p.getCustomName() + ChatColor.GREEN + "!");
					
					new FancyMessage("[ACCEPT]").color(ChatColor.GREEN).style(ChatColor.BOLD).command("/tpyes")
							.then(" ").then("[DENY]").color(ChatColor.RED).style(ChatColor.BOLD).command("/tpdeny")
							.send(t);
					return true;
				}
			} else {
				new FancyMessage("To many arguments!").color(ChatColor.RED).send(p);
				new FancyMessage("Click here to try again!").color(ChatColor.RED).style(ChatColor.ITALIC)
						.suggest("/back").send(p);
				return true;
			}
		} else if (label.equalsIgnoreCase("tpaccept") || label.equalsIgnoreCase("tpyes")) {
			
			if (playerto != null) {
				final Player p1 = Bukkit.getServer().getPlayer(playerto);
				p1.sendMessage(p.getCustomName() + ChatColor.GREEN + " has acccepted your teleport request! Teleporting in 4 seconds...");
				p.sendMessage(ChatColor.GREEN + "You accepted the request! Teleporting in 4 seconds...");
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
					public void run() {
						//tpdelay.remove(p);
						p.sendMessage(ChatColor.GREEN + "Teleporting...");
						p1.teleport(p);
						plugin.getConfig().set(p.getName().toLowerCase() + ".requestfor", null);
					}
				}, 80);
				return true;
			} else {
				p.sendMessage(ChatColor.RED + "You do not have a pending teleport request!");
				return true;
			}
		} else if (label.equalsIgnoreCase("tpdeny") || label.equalsIgnoreCase("tpno")) {
			if (playerto != null) {
				Player p1 = Bukkit.getServer().getPlayer(playerto);
				plugin.getConfig().set(p.getName().toLowerCase() + ".requestfor", null);
				p1.sendMessage(p.getCustomName() + ChatColor.RED + " has denied your teleport request!");
				return true;
			} else {
				p.sendMessage(ChatColor.RED + "You do not have a pending teleport request!");
				return true;
			}
		} //else if (label.equalsIgnoreCase("tpdebug")) {
		//	p.sendMessage(tpa.values().toString());
		//}

		return true;
	}
}