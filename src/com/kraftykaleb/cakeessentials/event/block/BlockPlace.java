package com.kraftykaleb.cakeessentials.event.block;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

import net.md_5.bungee.api.ChatColor;

public class BlockPlace implements Listener {
	
	@EventHandler
	public void onBlockBreak(BlockPlaceEvent event) {
		Player player = event.getPlayer();
		
		Block block = event.getBlock();
		Material material = block.getType();
		
		if(material == Material.BEDROCK) {
			event.setCancelled(true);;
			player.sendMessage(ChatColor.RED + "BEDROCK is a banned item!");
		}
		
		if(material == Material.ARMOR_STAND) {
			if (player.getGameMode() == GameMode.CREATIVE) {
				event.setCancelled(true);;
				player.sendMessage(ChatColor.RED + "ARMOR_STAND is a banned item in creative!");
			}
		}
	}
}
