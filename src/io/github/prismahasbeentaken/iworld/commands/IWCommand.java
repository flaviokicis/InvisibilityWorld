package io.github.prismahasbeentaken.iworld.commands;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import io.github.prismahasbeentaken.iworld.invisibility.IWEffect;
import io.github.prismahasbeentaken.iworld.utils.IWUtils;

public class IWCommand implements CommandExecutor {
	
	private IWEffect effect;
	
	public IWCommand(IWEffect effect) {
		this.effect = effect;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		// Check permissions
		if (!sender.hasPermission(cmd.getPermission())) {
			sender.sendMessage("§cYou do not have sufficient permissions");
			return true;
		}
		if (args.length == 0) {
			// List all commands
			IWUtils.sendList(sender);
		} else {
			if (args[0].equalsIgnoreCase("add")) {
			   if (args.length == 1) {
				   IWUtils.invalidWorldMessage(sender);
			   } else {
				   World w = Bukkit.getWorld(args[1]);
				   if (w == null) {
					   IWUtils.invalidWorldMessage(sender);
				   } else {
					   this.effect.setWorld(w);
					   sender.sendMessage("§aWorld Successfully Added!");
				   }
			   }
			} else if (args[0].equalsIgnoreCase("delete")) {
			if (args.length == 1) {
					   IWUtils.invalidWorldMessage(sender);
			   } else {
				   World w = Bukkit.getWorld(args[1]);
				   if (w == null) {
					   IWUtils.invalidWorldMessage(sender);
				   } else {
					   this.effect.remWorld(w);
					   sender.sendMessage("§aWorld Successfully Removed!");
				   }
			   }
			} else if (args[0].equalsIgnoreCase("list")) {
				sender.sendMessage("§aThese are the affected worlds:");
				for (String s : this.effect.getWorldList()) {
					sender.sendMessage("§e- " + s);
				}
			} else {
            sender.sendMessage("§cInvalid argument! Use:");
    		IWUtils.sendList(sender);
			}
		}
		return true;
	}

}
