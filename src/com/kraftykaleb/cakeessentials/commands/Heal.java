package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import mkremins.fanciful.FancyMessage;

public class Heal implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		if (commandLabel.equalsIgnoreCase("heal")) {
			if (sender.hasPermission("essentials.heal")) {
				if (args.length == 0) {
					if (!(sender instanceof Player)) {

						sender.sendMessage("No player specified!");

						return true;
					}

					Player player = (Player) sender;
					player.setHealth(20);
					player.setFoodLevel(20);
					for (PotionEffect effect : player.getActivePotionEffects())
						player.removePotionEffect(effect.getType());
					player.sendMessage(
							ChatColor.GREEN + "You healed " + player.getDisplayName() + ChatColor.GREEN + "!");
					return true;

				}

				else if (args.length == 1) {
					Player target = Bukkit.getServer().getPlayer(args[0]);
					if (target == null) {

						sender.sendMessage(ChatColor.RED + "Could not find the player!");
						new FancyMessage("Click here to try again!").color(ChatColor.RED).style(ChatColor.ITALIC)
								.suggest("/heal").send(sender);

						return true;
					}
					target.setHealth(20);
					target.setFoodLevel(20);
					for (PotionEffect effect : target.getActivePotionEffects())
						target.removePotionEffect(effect.getType());
					sender.sendMessage(
							ChatColor.GREEN + "You healed " + target.getDisplayName() + ChatColor.GREEN + "!");
					target.sendMessage(
							ChatColor.GREEN + "You were healed by " + sender.getName() + ChatColor.GREEN + "!");
					return true;
				} else {
					sender.sendMessage("Use /heal <player>");
				}
				return true;
			} else {
				sender.sendMessage(ChatColor.RED + "You must be of the " + ChatColor.GREEN + "VIP " + ChatColor.RED + "rank to use that command!");
				return true;
			}
			
		}
		return true;
	}
}