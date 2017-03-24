package com.kraftykaleb.cakeessentials.event.player;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathSounds implements Listener {
	
	public void onDeathEvent(PlayerDeathEvent e) {
		Player p = (Player) e.getEntity();
		p.getWorld().playSound(e.getEntity().getLocation(), Sound.ENTITY_WITHER_DEATH, 1, 1);
	}
}
