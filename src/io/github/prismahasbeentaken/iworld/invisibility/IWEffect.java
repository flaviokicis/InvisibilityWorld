package io.github.prismahasbeentaken.iworld.invisibility;

import java.util.HashSet;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class IWEffect {
	
	private transient HashSet<String> worldList = new HashSet<>();
	
	// Add the world to our list and add the effect for everyone
	public void setWorld(World w) {
		worldList.add(w.getName());
		for (Player p : w.getPlayers()) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 255), true);
		}
	}
	
	// Remove the world from our list and remove the effect of everyone
	public void remWorld(World w) {
		worldList.remove(w.getName());
		for (Player p : w.getPlayers()) {
			p.removePotionEffect(PotionEffectType.INVISIBILITY);
		}
	}
	
	// Checks if the specified world is affected by our list
	public boolean isAffected(World w) {
		return worldList.contains(w.getName());
	}
	
	// Returns our list casted into an string array
	public String[] getWorldList() {
		return worldList.toArray(new String[0]);
	}

}
