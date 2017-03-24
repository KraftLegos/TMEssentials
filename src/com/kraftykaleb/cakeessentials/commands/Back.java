package com.kraftykaleb.cakeessentials.commands;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import mkremins.fanciful.FancyMessage;

public class Back implements Listener, CommandExecutor {
	
	static HashMap<Player, Location> back = new HashMap<Player, Location>();
	   
    @EventHandler
    public void onDeath(PlayerDeathEvent event){
    Player player = event.getEntity();
    back.put(player, player.getLocation());
    player.sendMessage(ChatColor.RED + "You died! If you would like to teleport back to the point of your death type /back!");
    player.playSound(player.getLocation(), Sound.ENTITY_GHAST_SCREAM, 1, 1);
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		Player player = (Player) sender;
		if (commandLabel.equalsIgnoreCase("back")) {
			if (player.hasPermission("essentials.back")) {
				if (args.length == 0) {
					if (Back.back.containsKey(player)) {
						player.teleport(Back.back.get(player));
						Back.back.remove(player);
					} else {
						player.sendMessage(ChatColor.RED + "You were not dead.");
						new FancyMessage("Click here to try again!").color(ChatColor.RED).style(ChatColor.ITALIC).suggest("/back").send(sender);
						return true;
					}

				} else {
					player.sendMessage(ChatColor.RED + "There are no arguments to this command, only /back!");
					return true;
				}
			} else {
				player.sendMessage(ChatColor.RED + "You must be of the" + ChatColor.GREEN + " [VIP] " +  ChatColor.RED + "rank to use this command!");
				return true;
			}

		}
		return true;

	}
}
