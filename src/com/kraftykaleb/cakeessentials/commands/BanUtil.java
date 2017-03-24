package com.kraftykaleb.cakeessentials.commands;

import org.bukkit.configuration.Configuration;

public class BanUtil {
	
	public static final BanUtil INSTANCE;
	
	static {
		INSTANCE = new BanUtil();
	}
	
	public BanUtil setCf(Configuration conf, String key, String value) {
		conf.set(key, value);
		return INSTANCE;
	}

}
