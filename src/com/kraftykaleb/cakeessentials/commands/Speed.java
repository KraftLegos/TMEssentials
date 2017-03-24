package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Speed implements CommandExecutor {

	@SuppressWarnings("unused")
	private float defaultSpeed = 0.2f;
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("speed")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("This command is not available yet");
			}
			Player p = (Player) sender;
			if (p.hasPermission("essentials.speed")) {
				if (args.length == 0) {
					p.sendMessage(ChatColor.RED + "You did not specify a speed!");
					//new FancyMessage("You did not specify a speed!").color(ChatColor.RED)
							//.then(" Click here to try again!").color(ChatColor.GOLD)
							//.tooltip("Click to use the command!").suggest("/speed ").send(p.getPlayer());
					return true;
				}
				if (args.length == 1) {
					float f = Float.parseFloat(args[0]);
					if (p.isFlying()) {
						p.setFlySpeed(f);
						p.sendMessage(ChatColor.GREEN + "You set your" + ChatColor.ITALIC + " flying " + ChatColor.RESET
								+ ChatColor.GREEN + "speed to " + ChatColor.ITALIC + f);
					} else {// (!(p.isFlying())) {
						p.setWalkSpeed(f);
						p.sendMessage(ChatColor.GREEN + "You set your" + ChatColor.ITALIC + " walking "
								+ ChatColor.RESET + ChatColor.GREEN + "speed to " + ChatColor.ITALIC + f);
						return true;
					}
				} else {
					p.sendMessage(ChatColor.RED + "Invalid Arguments!");
					return true;
				}
			} else {
				p.sendMessage(ChatColor.RED + "You must be of the [ADMIN] rank to use this command!");
				return true;
			}

		}

		return true;
	}
}
