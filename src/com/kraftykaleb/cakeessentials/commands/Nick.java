package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kraftykaleb.cakeessentials.CakeEssentials;

//import me.libraryaddict.disguise.DisguiseAPI;
//import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import mkremins.fanciful.FancyMessage;

@SuppressWarnings("unused")
public class Nick implements CommandExecutor {
	
	private CakeEssentials plugin;

	public Nick(CakeEssentials pl) {
		plugin = pl;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (label.equalsIgnoreCase("nick")) {
			if (sender.hasPermission("essentials.nick")) {
				sender.sendMessage(ChatColor.RED + "This command is currently disabled!");
				/*if (args.length == 1) {
					Player p = (Player) sender;
					//String playerName = p.getName();
					PlayerDisguise playerDisguise = new PlayerDisguise(args[0]);
					DisguiseAPI.disguiseToAll(p, playerDisguise);
					//DisguiseAPI.disguiseIgnorePlayers(p, playerDisguise, );
					p.setCustomName(ChatColor.GREEN + "[VIP] " + args[0]);
					p.setPlayerListName("§a[VIP] " + args[0]);
					p.setCustomNameVisible(true);
					plugin.getConfig().set(p.getName() + ".nickname", args[0]);
					plugin.saveConfig();
					p.sendMessage(ChatColor.GREEN + "You successfully nicked yourself as [VIP] " + args[0]);
					return true;
				} else {
					sender.sendMessage(ChatColor.RED + "Invalid arguments!");
					new FancyMessage("Click here to try again!").color(ChatColor.RED).style(ChatColor.ITALIC)
							.suggest("/nick").send(sender);
					return true;
				}*/

			} else {
				sender.sendMessage(ChatColor.RED + "You must be of the" + ChatColor.GOLD + " [YT] " + ChatColor.RED
						+ "rank or higher to use this command!");
				return true;
			}
		}

		return true;
	}

}
