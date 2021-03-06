package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mkremins.fanciful.FancyMessage;

public class FakeJoin implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("fakejoin")) {	
			if (args.length == 0) {

				if (!(sender instanceof Player)) {
					Bukkit.broadcastMessage(ChatColor.GOLD + "[MOJANG] Notch" + ChatColor.YELLOW + " left.");
					return true;
				}
				Player player = (Player) sender;
				Bukkit.broadcastMessage(player.getCustomName() + ChatColor.YELLOW + " joined.");
				return true;

			}

			else if (args.length == 1) {
				Player target = Bukkit.getServer().getPlayer(args[0]);
				if (target instanceof Player) {
					Bukkit.broadcastMessage(target.getCustomName() + ChatColor.YELLOW + " joined.");
				} else {
					Bukkit.broadcastMessage(ChatColor.GREEN + "[VIP] " + args[0] + ChatColor.YELLOW + " joined.");
					return true;
				}
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "Use /fakejoin <name>");
				new FancyMessage("Click here to try again!").color(ChatColor.RED).style(ChatColor.ITALIC)
						.suggest("/fakejoin").send(sender);;
			}
			return true;
		}
		return true;
	}
}
