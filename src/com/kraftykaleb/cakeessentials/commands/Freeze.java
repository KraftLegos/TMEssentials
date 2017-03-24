package com.kraftykaleb.cakeessentials.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import mkremins.fanciful.FancyMessage;

//import mkremins.fanciful.FancyMessage;

public class Freeze implements Listener, CommandExecutor {

	ArrayList<String> frozen = new ArrayList<String>();

	@EventHandler
	public void onSprint(PlayerToggleSprintEvent e) {
		Player p = e.getPlayer();
		if (frozen.contains(p.getName().toLowerCase())) {
			p.setSprinting(false);
			if (e.getPlayer().isSprinting()) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();

		if (frozen.contains(p.getName().toLowerCase())) {
			Location from = e.getFrom(), to = e.getTo();
			if (from.getX() < to.getX() || from.getY() < from.getY()) { // OBS:
																		// care
																		// on
																		// what
																		// you
																		// do
																		// with
																		// this
				e.getPlayer().teleport(new Location(from.getWorld(), from.getX(), from.getY(), from.getZ(), to.getYaw(),
						to.getPitch()));
				e.setCancelled(true); // I always have an issue with cancelling
										// this, so I just teleport them
			}
			e.setCancelled(true);
			p.sendMessage(ChatColor.RED + "You are frozen solid!");
		}
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (label.equalsIgnoreCase("freeze")) {
			if (sender.hasPermission("essentials.freeze")) {
				if (args.length == 0) {
					sender.sendMessage(ChatColor.RED + "Invalid Arguments! Usage: /freeze <player>");
					return true;
				}
				// if (args.length == 1) {
				Player target = Bukkit.getPlayer(args[0]);
				if (target == null) {
					new FancyMessage("Could not find '" + args[0] + "'").color(ChatColor.RED)
							.then(" Click here to try again!").color(ChatColor.RED).style(ChatColor.ITALIC)
							.suggest("/freeze").send(sender);
					return true;

				} else if (frozen.contains(target.getName().toLowerCase())) {
					frozen.remove(target.getName().toLowerCase());
					target.removePotionEffect(PotionEffectType.JUMP);
					target.setWalkSpeed(0.2f);
					sender.sendMessage(target.getCustomName() + ChatColor.GREEN + " has been unfrozen!");
					return true;
				} else {
					frozen.add(target.getName().toLowerCase());
					target.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000000, 250));
					target.setWalkSpeed(0);
					target.setFlying(false);
					sender.sendMessage(target.getCustomName() + ChatColor.GREEN + " has been frozen!");
					return true;
				}
			} else {
				sender.sendMessage(ChatColor.RED + "You must be of the [ADMIN] rank to use this command!");
				return true;
			}

		}
		return true;
	}

}
