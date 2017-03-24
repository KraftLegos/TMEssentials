package com.kraftykaleb.cakeessentials.event.block;

import org.bukkit.GameMode;
import org.bukkit.block.Chest;
import org.bukkit.block.Dispenser;
import org.bukkit.block.DoubleChest;
import org.bukkit.block.Dropper;
import org.bukkit.block.EnderChest;
import org.bukkit.block.Hopper;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.minecart.HopperMinecart;
import org.bukkit.entity.minecart.StorageMinecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.InventoryHolder;

public class InventoryOpen implements Listener {

	@EventHandler
	public void onInventoryOpenEvent(InventoryOpenEvent e) {
		InventoryHolder inv = e.getInventory().getHolder();
		if (inv instanceof Chest || inv instanceof DoubleChest || inv instanceof Dispenser || inv instanceof Hopper
				|| inv instanceof Dropper 
				|| inv instanceof HopperMinecart || inv instanceof StorageMinecart) {
			if (e.getPlayer().getGameMode() == GameMode.CREATIVE) {
				e.setCancelled(true);
			}
		}
	}

}
