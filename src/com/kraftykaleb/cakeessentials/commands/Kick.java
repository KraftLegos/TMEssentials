package com.kraftykaleb.cakeessentials.commands;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kraftykaleb.cakeessentials.CakeEssentials;


public class Kick implements CommandExecutor{

	private CakeEssentials plugin;

	public Kick(CakeEssentials pl) {
		plugin = pl;
	}
	
	Date now = new Date();
	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player t = Bukkit.getServer().getPlayer(args[0]);
		
		if (!sender.hasPermission("essentials.kick")) {
			sender.sendMessage(ChatColor.RED + "You must be of the " + ChatColor.BLUE + "[HELPER] " + ChatColor.RED + "rank to use that command!");
			return true;
		}
		
		if (t == null){
			sender.sendMessage(ChatColor.RED + "That player is offline!");
			return true;
		}
		
		Integer kicks = plugin.getConfig().getInt(args[0].toLowerCase() + ".info.kicks");
		
		String kickReason = "";

		for (int i = 1; i < args.length; i++) {
			String arg = args[i] + " ";
			kickReason = kickReason + arg;
		}
		
		if (kicks != null) {
			plugin.getConfig().set(t.getName().toLowerCase() + ".info.kicks", kicks + 1);
			plugin.getConfig().set(t.getName().toLowerCase() + ".info.kick.reason." + kicks + 1, kickReason);
			plugin.getConfig().set(t.getName().toLowerCase() + ".info.kick.kickedBy." + kicks + 1, sender.getName().toLowerCase());
			plugin.getConfig().set(t.getName().toLowerCase() + ".info.kick.date." + kicks + 1, format.format(now));
			plugin.saveConfig();
		}
		
		t.kickPlayer("[" + plugin.getConfig().get(t.getName().toLowerCase() + ".info.kick.date." + kicks + 1)
				+ "] " + ChatColor.RED + "You have been kicked from the server" + "\n"
				+ ChatColor.RESET + "Reason: " + plugin.getConfig().get(t.getName().toLowerCase() + ".info.kick.reason" + kicks + 1));
				//+ "\n" + "If you feel this ban is wrong, Appeal on slack!");
		
		for (Player p : Bukkit.getServer().getOnlinePlayers()) {
			if (p.hasPermission("essentials.staff")) {
			p.sendMessage(ChatColor.DARK_GREEN + "[STAFF] " + ChatColor.WHITE + sender.getName() + " kicked '" + args[0] + "' for '" + kickReason + "'.");
			}
		}
		
		return true;
	}

}
