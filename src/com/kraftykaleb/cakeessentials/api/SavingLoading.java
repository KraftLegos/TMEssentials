package com.kraftykaleb.cakeessentials.api;

import com.kraftykaleb.cakeessentials.CakeEssentials;
import com.kraftykaleb.cakeessentials.economy.EconManager;

public class SavingLoading {

private static CakeEssentials plugin;
	
	public SavingLoading(CakeEssentials pl) {
		plugin = pl;
	}

	public static void saveBalances() {
		for (String p : EconManager.getBalanceMap().keySet()) {
			plugin.getConfig().set("balance." + p, EconManager.getBalanceMap().get(p));
		}
		plugin.saveConfig();
	}

	public static void loadBalances() {

		if (!(plugin.getConfig().contains("balance"))) { //ERROR ON THIS LINE
			return;
		} else {
			for (String s : plugin.getConfig().getConfigurationSection("balance").getKeys(false)) {
				EconManager.setBalance(s, plugin.getConfig().getDouble("balance." + s));
			}
		}
	}
}
