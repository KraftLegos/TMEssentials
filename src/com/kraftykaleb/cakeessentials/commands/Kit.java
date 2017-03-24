package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Kit implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("kit")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Coming soon!");
			}
			Player p = (Player) sender;
			p.sendMessage("This command is coming soon!");
			p.sendMessage("§e§lADMIN §eKraft");
			p.sendMessage("§6§lMOD §6Kraft");
			p.sendMessage("§c§lHELPER §cKraft");
			p.sendMessage("§a§lBUILDTEAM §aKraft");
			p.sendMessage("§a§lBUILDTEAM §aKraft");
			p.sendMessage("§d§lYT §dKraft");
			p.sendMessage("§4§lMVP+ §4Kraft");
			p.sendMessage("§b§lMVP §bKraft");
			p.sendMessage("§3§lVIP+ §3Kraft");
			p.sendMessage("§9§lVIP §9Kraft");
			
			
		}
		return true;
	}

}
