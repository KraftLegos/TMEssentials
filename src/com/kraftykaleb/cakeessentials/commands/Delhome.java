package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.kraftykaleb.cakeessentials.CakeEssentials;

public class Delhome implements CommandExecutor {

	private CakeEssentials plugin;

	public Delhome(CakeEssentials pl) {
		plugin = pl;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		return true;
	}

}
