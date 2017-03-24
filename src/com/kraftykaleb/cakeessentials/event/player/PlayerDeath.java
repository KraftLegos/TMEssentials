package com.kraftykaleb.cakeessentials.event.player;

import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;

import mkremins.fanciful.FancyMessage;

public class PlayerDeath {

	static HashMap<Player, Location> back = new HashMap<Player, Location>();

	@EventHandler
	public void onDeath(PlayerDeathEvent event) {
		Player p = event.getEntity();
		back.put(p, p.getLocation());
		new FancyMessage("You died! If you would like to teleport back to the point of your death type /back!").color(ChatColor.RED)
		.then("Click here to run this command!").color(ChatColor.GOLD).tooltip("Click to use the command!")
		.suggest("/back").send(p.getPlayer());
	}

}
