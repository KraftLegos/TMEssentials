package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Whois implements CommandExecutor {

	
	public String op(Player p) {
		if (!p.isOp()) {
			String isOp = ChatColor.RED + "false";
			return isOp;
		} else {
			String isOp = ChatColor.GREEN + "true";
			return isOp;
		}
	}
	
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("whois")) {
			Player p = (Player) sender;
			if (args.length != 1){
				if (!(sender instanceof Player)) {
					sender.sendMessage("You must be a player to run this command!");
					return true;
				} else {					
					p.sendMessage("OP:" + op(p));
				}
			} else {
				
			}
		}
		
		return true;
	}

}
