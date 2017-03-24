package com.kraftykaleb.cakeessentials.economy;

import java.util.HashMap;

import com.kraftykaleb.cakeessentials.CakeEssentials;

public class EconManager {
	
	private CakeEssentials plugin;
	
	public EconManager(CakeEssentials pl) {
		plugin = pl;
	}
	
	public static HashMap<String, Double> bal = new HashMap<>();
	
	public static void setBalance(String uuid, double amount) {
		bal.put(uuid, amount);
	}
	
	public static Double getBalance(String uuid) {
		return bal.get(uuid);
	}
	
	public static boolean hasAccount(String uuid) {
		return bal.containsKey(uuid);
	}
	
	public static HashMap<String, Double> getBalanceMap() {
		return bal;
	}
	
	public CakeEssentials getPlugin() {
		return plugin;
	}
}
