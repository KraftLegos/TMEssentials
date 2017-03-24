package com.kraftykaleb.cakeessentials.event.player;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class EntityDamage implements Listener {
	
	private HashMap<Player, Player> tag = new HashMap<Player, Player>();
	
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			Player hit = (Player) e.getEntity();
			Player damager = (Player) e.getDamager();
			
			if (tag.get(hit) != null) {
				if (tag.get(hit) != e.getDamager()) e.setCancelled(true);
				return;
			} else {
				tag.put(hit, damager);
			}
		}
	}
	
	@EventHandler
	public void onPlayerDeat(PlayerDeathEvent e) {
		if (tag.containsKey(e.getEntity())) {
			tag.remove(e.getEntity());
		}
	}
}
