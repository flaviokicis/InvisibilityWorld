package io.github.prismahasbeentaken.iworld.main;

import org.bukkit.World;

public class IWApi {
	
	private static IWorld base;
	
	// Set the API base
	static void setPluginBase(IWorld base) {
		IWApi.base = base;
	}
	
	// Add a temporary world, in case an arena needs it
	public static void addTempWorld(World w) {
		base.getEffectController().setWorld(w);
	}
	
	// Remove a temporary world, in case an arena needs it
	public static void remTempWorld(World w) {
		base.getEffectController().remWorld(w);
	}
	
	// Checks if a world is affected by this plugin
	public static boolean checkWorld(World w) {
		return base.getEffectController().isAffected(w);
	}
	
	// Returns a list of worlds affected by this plugin
	public static String[] getWorldNameList() {
		return base.getEffectController().getWorldList();
	}

}
