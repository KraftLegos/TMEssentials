package com.kraftykaleb.cakeessentials.commands;


import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Staff implements CommandExecutor {

	static HashMap<Integer, Player> staff = new HashMap<Integer, Player>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			//Integer number = 0;
			
			sender.sendMessage(ChatColor.YELLOW + "Online staff: ");
			
			for (Player s : Bukkit.getOnlinePlayers()) {
				if (s.hasPermission("essentials.staff")) {
					//Integer newnumber = number + 1;
					//staff.put(newnumber, s);
					sender.sendMessage(s.getCustomName() + ChatColor.YELLOW + " - " + ChatColor.WHITE + s.getLocation().getBlockX() + ", " + s.getLocation().getY() + ", " + s.getLocation().getBlockZ());
				}
			}
			
			
			
			//Integer staffnumber = 0;
			
			//for (int i = 0; i < number; i++) {
			//	staffnumber = staffnumber + 1;
			//	getStaff(staffnumber, sender);
			//}
			
			return true;
	}
	
	public void getStaff(Integer i, CommandSender s){
		if (staff.containsValue(i)) {
			
			Player p = staff.get(i);
			
			s.sendMessage(p.getCustomName() + ChatColor.YELLOW + " - " + ChatColor.WHITE + p.getLocation().getBlockX() + ", " + p.getLocation().getY() + ", " + p.getLocation().getBlockZ());
			return;
		}
		return;
	}

}
