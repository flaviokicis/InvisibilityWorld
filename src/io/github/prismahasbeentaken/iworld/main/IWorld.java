package io.github.prismahasbeentaken.iworld.main;

import org.bukkit.Server;
import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.prismahasbeentaken.iworld.commands.IWCommand;
import io.github.prismahasbeentaken.iworld.invisibility.IWEffect;
import io.github.prismahasbeentaken.iworld.listener.IWListener;

public class IWorld extends JavaPlugin {
	
	private ConsoleCommandSender console;
	
	private IWEffect effectController;
	
	// Initiate the plugin
	public void onEnable() {
		Server server = getServer();
		this.saveDefaultConfig();
		// Set console
		this.console = server.getConsoleSender();
		this.console.sendMessage("§eInvisibilityWorld Enabled");
		// Set the effect controller
		this.effectController = new IWEffect();
		// Set the command
		getCommand("iworld").setExecutor(new IWCommand(effectController));
		// Register events to our listener
		server.getPluginManager().registerEvents(new IWListener(effectController), this);
		// Set the plugin base
		IWApi.setPluginBase(this);
		// Load all the worlds from the config
		loadFromConfig();
	}
	
	// Disables the plugin
	public void onDisable() {
		this.console.sendMessage("§eInvisibilityWorld Disabled");
	}
	
	// Returns the effect class
	public IWEffect getEffectController() {
		return effectController;
	}
	
	// Loads all worlds from config
	public void loadFromConfig() {
		int i = 0;
		// Get through all the strings in the config's list
		for (String s : getConfig().getStringList("worlds")) {
			World w = getServer().getWorld(s);
			// If the world is null, warns the console about it
			if ( w == null ) {
				this.console.sendMessage("§cWorld \"" + s + "\" in config does not exist!");
			} else {
				// If it's not, just get the controller and add the world to the list
				this.getEffectController().setWorld(w);
				// Counts the worlds
				i++;
			}
		}
		this.console.sendMessage("§aLoaded " + i + " worlds from config.");
	}

}
