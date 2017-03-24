package com.kraftykaleb.cakeessentials.event.player;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerTeleportEvent extends Event {
	
	Player p;
	Location l;
	
	public PlayerTeleportEvent(Player p, Location l){
		this.p = p;
		this.l = l;
	}
	
	public Player getPlayer() {
		return p;
	}
	
	public Location getTeleportLocation() {
		return l;
	}
	
	
	private static final HandlerList handlers = new HandlerList();

	public HandlerList getHandlers() {
	    return handlers;
	}

	public static HandlerList getHandlerList() {
	    return handlers;
	}

}
