package io.github.prismahasbeentaken.iworld.listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import io.github.prismahasbeentaken.iworld.invisibility.IWEffect;

public class IWListener implements Listener {
	
	private IWEffect effect;
	
    public IWListener(IWEffect effect) {
	    this.effect = effect;
	}
    
    // Add the effect
    @EventHandler
    public void onJoin(PlayerJoinEvent ev) {
    	if (this.effect.isAffected(ev.getPlayer().getWorld())) {
    		ev.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 999999, 255), true);
    	}
    }
    
    // Remove the effect
    @EventHandler
    public void onQuit(PlayerQuitEvent ev) {
    	if (this.effect.isAffected(ev.getPlayer().getWorld())) {
    		ev.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);
    	}
    }
	
    // Denies if a player tries to drink milk
	@EventHandler
	public void onConsume(PlayerItemConsumeEvent event) {
		if (event.getItem() != null && (event.getItem().getType() == Material.MILK_BUCKET && (this.effect.isAffected(event.getPlayer().getWorld())))) {
			event.setCancelled(true);
		}
	}

}
