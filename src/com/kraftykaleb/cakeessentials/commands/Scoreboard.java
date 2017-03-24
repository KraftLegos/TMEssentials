package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.Bukkit;

public class Scoreboard {
	@SuppressWarnings("unused")
	private Scoreboard board;
	
	public void loadBoard() {
		board = (Scoreboard) Bukkit.getScoreboardManager().getNewScoreboard();
		
	}
}
