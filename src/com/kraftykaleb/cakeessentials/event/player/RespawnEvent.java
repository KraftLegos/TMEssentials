package com.kraftykaleb.cakeessentials.event.player;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.kraftykaleb.cakeessentials.CakeEssentials;

public class RespawnEvent implements Listener {
	
	private CakeEssentials plugin;

	public RespawnEvent(CakeEssentials pl) {
		plugin = pl;
	}
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
        
		World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("spawn.world"));
		double x = plugin.getConfig().getDouble("spawn.x");
		double y = plugin.getConfig().getDouble("spawn.y");
		double z = plugin.getConfig().getDouble("spawn.z");
		float yaw = Float.parseFloat(plugin.getConfig().getString("spawn.yaw"));
		float pitch = Float.parseFloat(plugin.getConfig().getString("spawn.pitch"));
		
		Location spawn = new Location(w, x, y, z, yaw, pitch);
		
        event.setRespawnLocation(spawn);
    }

}
