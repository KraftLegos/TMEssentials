package com.kraftykaleb.cakeessentials.event.player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;


public class PlayerDrop implements Listener {

	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		
		if (p.getGameMode().toString().equals("CREATIVE")) {
			e.setCancelled(true);
			return;
		} else {
			return;
		}
	}
	
}
