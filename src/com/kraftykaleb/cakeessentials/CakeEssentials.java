package com.kraftykaleb.cakeessentials;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.kraftykaleb.cakeessentials.api.SavingLoading;
import com.kraftykaleb.cakeessentials.commands.Addwarp;
import com.kraftykaleb.cakeessentials.commands.Afk;
import com.kraftykaleb.cakeessentials.commands.Back;
import com.kraftykaleb.cakeessentials.commands.Ban;
import com.kraftykaleb.cakeessentials.commands.Clear;
import com.kraftykaleb.cakeessentials.commands.Coins;
import com.kraftykaleb.cakeessentials.commands.Enderchest;
import com.kraftykaleb.cakeessentials.commands.FakeJoin;
import com.kraftykaleb.cakeessentials.commands.FakeLeave;
import com.kraftykaleb.cakeessentials.commands.Fly;
import com.kraftykaleb.cakeessentials.commands.Freeze;
import com.kraftykaleb.cakeessentials.commands.Gamemode;
import com.kraftykaleb.cakeessentials.commands.Heal;
import com.kraftykaleb.cakeessentials.commands.Help;
import com.kraftykaleb.cakeessentials.commands.Home;
import com.kraftykaleb.cakeessentials.commands.Invsee;
import com.kraftykaleb.cakeessentials.commands.Kick;
import com.kraftykaleb.cakeessentials.commands.Kit;
import com.kraftykaleb.cakeessentials.commands.Msg;
import com.kraftykaleb.cakeessentials.commands.Nick;
import com.kraftykaleb.cakeessentials.commands.NickReset;
import com.kraftykaleb.cakeessentials.commands.Sc;
import com.kraftykaleb.cakeessentials.commands.SetSpawn;
import com.kraftykaleb.cakeessentials.commands.Sethome;
import com.kraftykaleb.cakeessentials.commands.Spawn;
import com.kraftykaleb.cakeessentials.commands.Speed;
import com.kraftykaleb.cakeessentials.commands.Staff;
import com.kraftykaleb.cakeessentials.commands.Sudo;
import com.kraftykaleb.cakeessentials.commands.Tp;
import com.kraftykaleb.cakeessentials.commands.Tpa;
//import com.kraftykaleb.cakeessentials.commands.Tpa;
import com.kraftykaleb.cakeessentials.commands.Tphere;
import com.kraftykaleb.cakeessentials.commands.Unban;
import com.kraftykaleb.cakeessentials.commands.Userinfo;
import com.kraftykaleb.cakeessentials.commands.Vanish;
import com.kraftykaleb.cakeessentials.commands.Warp;
import com.kraftykaleb.cakeessentials.commands.Whois;
import com.kraftykaleb.cakeessentials.economy.EconManager;
import com.kraftykaleb.cakeessentials.event.block.BlockPlace;
import com.kraftykaleb.cakeessentials.event.block.InventoryOpen;
import com.kraftykaleb.cakeessentials.event.player.DeathSounds;
import com.kraftykaleb.cakeessentials.event.player.PlayerChat;
import com.kraftykaleb.cakeessentials.event.player.PlayerChatFormat;
import com.kraftykaleb.cakeessentials.event.player.PlayerDrop;
import com.kraftykaleb.cakeessentials.event.player.PlayerJoin;
import com.kraftykaleb.cakeessentials.event.player.PlayerJoinName;
import com.kraftykaleb.cakeessentials.event.player.PlayerQuit;
import com.kraftykaleb.cakeessentials.event.player.PlayerVote;
import com.kraftykaleb.cakeessentials.event.player.RespawnEvent;

public class CakeEssentials extends JavaPlugin {

	public HashMap<Player, Player> messages = new HashMap<Player, Player>();
	public HashMap<Player, String> gamemode = new HashMap<Player, String>();

	@SuppressWarnings("unused")
	private File warpsf;// , specialf;
	private FileConfiguration warps;// , special;

	// old public HashMap<String, String> nicknames = new HashMap<String,
	// String>();

	// public Scoreboard board;
	// private Score s;

	private FileConfiguration warpsConfig = null;
	private File customWarpsConfig = null;

	public void reloadWarpsConfig() {
		if (customWarpsConfig == null) {
			customWarpsConfig = new File(getDataFolder(), "warps.yml"); // LINE
																			// 24
		}
		warpsConfig = YamlConfiguration.loadConfiguration(customWarpsConfig);

		InputStream defConfigStream = this.getResource("warps.yml");
		if (defConfigStream != null) {
			@SuppressWarnings("deprecation")
			YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
			warpsConfig.setDefaults(defConfig);
		}
	}

	public FileConfiguration getWarpsConfig1() {
		if (warpsConfig == null) {
			reloadWarpsConfig(); // LINE 37
		}
		return warpsConfig;
	}

	public void saveWarpsConfig() {
		if (warpsConfig == null || customWarpsConfig == null) {
			return;
		}
		try {
			getWarpsConfig1().save(customWarpsConfig);
		} catch (IOException ex) {
			getLogger().log(Level.SEVERE, "Could not save config to " + customWarpsConfig, ex);
		}
	}

	public void onEnable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();

		new EconManager(this);
		new SavingLoading(this);

		createFiles();

		// board =
		// Bukkit.getServer().getScoreboardManager().getMainScoreboard();

		// SavingLoading.loadBalances();
		registerConfig();
		registerCommands();
		registerEvents();
		registerConfig();
		getWarpsConfig();
		saveWarpsConfig();
		// saveNickname();

		logger.info(pdfFile.getName() + " has been enabled! Version: " + pdfFile.getVersion());

		Bukkit.getServer().broadcastMessage(ChatColor.RED
				+ "The server has just been reloaded! If you experience any new bugs, please report them in #guild-reports on slack.");
	}

	public void onDisable() {
		PluginDescriptionFile pdfFile = getDescription();
		Logger logger = getLogger();
		// SavingLoading.saveBalances();
		logger.info(pdfFile.getName() + " has been disabled! Version: " + pdfFile.getVersion());
		saveDefaultConfig();
	}

	public void registerCommands() {

		getCommand("help").setExecutor(new Help());
		getCommand("fly").setExecutor(new Fly());
		getCommand("spawn").setExecutor(new Spawn(this));
		getCommand("clear").setExecutor(new Clear());
		getCommand("heal").setExecutor(new Heal());
		getCommand("fakejoin").setExecutor(new FakeJoin());
		getCommand("tp").setExecutor(new Tp());
		getCommand("setspawn").setExecutor(new SetSpawn(this));
		getCommand("tphere").setExecutor(new Tphere());
		getCommand("back").setExecutor(new Back());
		getCommand("kit").setExecutor(new Kit());
		getCommand("speed").setExecutor(new Speed());
		getCommand("fakeleave").setExecutor(new FakeLeave());
		getCommand("freeze").setExecutor(new Freeze());
		getCommand("afk").setExecutor(new Afk(this));
		getCommand("tpa").setExecutor(new Tpa(this));
		getCommand("tpdeny").setExecutor(new Tpa(this));
		getCommand("tpaccept").setExecutor(new Tpa(this));
		// getCommand("tpdebug").setExecutor(new Tpa(this));
		getCommand("nick").setExecutor(new Nick(this));
		getCommand("nickreset").setExecutor(new NickReset(this));
		getCommand("vanish").setExecutor(new Vanish(this));
		getCommand("coins").setExecutor(new Coins());
		getCommand("whois").setExecutor(new Whois());
		getCommand("home").setExecutor(new Home(this));
		getCommand("sethome").setExecutor(new Sethome(this));
		getCommand("gamemode").setExecutor(new Gamemode());
		getCommand("msg").setExecutor(new Msg(this));
		getCommand("r").setExecutor(new Msg(this));
		getCommand("invsee").setExecutor(new Invsee());
		getCommand("userinfo").setExecutor(new Userinfo(this));
		getCommand("ban").setExecutor(new Ban(this));
		getCommand("unban").setExecutor(new Unban(this));
		getCommand("sc").setExecutor(new Sc());
		getCommand("sudo").setExecutor(new Sudo());
		getCommand("staff").setExecutor(new Staff());
		getCommand("kick").setExecutor(new Kick(this));
		getCommand("warp").setExecutor(new Warp(this));
		getCommand("addwarp").setExecutor(new Addwarp(this));
		getCommand("enderchest").setExecutor(new Enderchest());
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();

		pm.registerEvents(new PlayerDrop(), this);
		pm.registerEvents(new BlockPlace(), this);
		pm.registerEvents(new PlayerChat(this), this);
		pm.registerEvents(new PlayerJoin(this), this);
		pm.registerEvents(new PlayerJoinName(this), this);
		pm.registerEvents(new PlayerChatFormat(this), this);
		pm.registerEvents(new PlayerQuit(this), this);
		pm.registerEvents(new RespawnEvent(this), this);
		pm.registerEvents(new Back(), this);
		pm.registerEvents(new Freeze(), this);
		pm.registerEvents(new Afk(this), this);
		pm.registerEvents(new PlayerVote(), this);
		pm.registerEvents(new DeathSounds(), this);
		pm.registerEvents(new Vanish(this), this);
		//pm.registerEvents(new InventoryOpen(), this);

	}

	public void registerConfig() {
		/*
		 * try { File f = new File(this.getDataFolder() + File.separator +
		 * "config.yml"); if (f.exists()) { return; } else { FileConfiguration
		 * config = YamlConfiguration.loadConfiguration(f); InputStream
		 * defConfigStream = this.getResource("config.yml");
		 * 
		 * @SuppressWarnings("deprecation") FileConfiguration defconf =
		 * YamlConfiguration.loadConfiguration(defConfigStream);
		 * config.addDefaults(defconf); config.setDefaults(defconf);
		 * this.saveDefaultConfig(); } } catch (Exception e) {
		 * e.printStackTrace(); }
		 */
	}

	private void createFiles() {
		File warpsf = new File(getDataFolder(), "warps.yml");

		FileConfiguration warps = YamlConfiguration.loadConfiguration(warpsf);

		if (!warpsf.exists()) {
			try {
				warpsf.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			warps.save(warpsf);
		} catch (IOException e) {
			// Handle any IO exception here
			e.printStackTrace();
		}

		// warps = new YamlConfiguration();
		// try {
		// warps.load(warpsf);
		// } catch (IOException e) {
		// e.printStackTrace();
		// } catch (InvalidConfigurationException e) {
		// e.printStackTrace();
		// }
	}

	public FileConfiguration getWarpsConfig() {
		return this.warps;
	}

}
