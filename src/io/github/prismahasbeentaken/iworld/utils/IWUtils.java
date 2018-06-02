package io.github.prismahasbeentaken.iworld.utils;

import org.bukkit.command.CommandSender;

public class IWUtils {
	
	// Send a list of commands
	public static void sendList(CommandSender sender) {
		sender.sendMessage("§eFor adding a temporary world - /iw add <worldName>");
		sender.sendMessage("§eFor removing a temporary world - /iw delete <worldName>");
		sender.sendMessage("§eFor listing all temporary worlds - /iw list");
	}
	
	// Sent when a world does not exist
	public static void invalidWorldMessage(CommandSender sender) {
		sender.sendMessage("§cInvalid world!");
	}

}
