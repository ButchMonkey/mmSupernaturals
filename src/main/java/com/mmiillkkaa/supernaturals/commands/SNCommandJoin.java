package com.mmiillkkaa.supernaturals.commands;


import org.bukkit.entity.Player;

import com.mmiillkkaa.supernaturals.io.SNConfigHandler;
import com.mmiillkkaa.supernaturals.io.SNWhitelistHandler;

public class SNCommandJoin extends SNCommand {

	public SNCommandJoin() {
		permissions = "";
		senderMustBePlayer = true;
		senderMustBeSupernatural = false;
		helpNameAndParams = "sn join";
		helpDescription = "Join in on the mmSupernatuals fun!";
	}

	@Override
	public void perform() {
		if (!SNConfigHandler.enableJoinCommand) {
			this.sendMessage("This is not enabled, you are automatically in the mmSupernaturals fun!");
			return;
		}
		Player senderPlayer = (Player) sender;
		if (SNWhitelistHandler.playersInWhitelist.contains(senderPlayer.getName())) {
			this.sendMessage("You are already whitelisted!");
			return;
		}
		SNWhitelistHandler.addPlayer(senderPlayer.getName());
	}

}