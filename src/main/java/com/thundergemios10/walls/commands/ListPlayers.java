package com.thundergemios10.walls.commands;

import org.bukkit.entity.Player;
import com.thundergemios10.walls.GameManager;
import com.thundergemios10.walls.MessageManager;
import com.thundergemios10.walls.SettingsManager;
import com.thundergemios10.walls.MessageManager.PrefixType;



public class ListPlayers implements SubCommand{

	@Override
	public boolean onCommand(Player player, String[] args) {
		int gid = 0;
		try{
			if(args.length == 0){
				gid = GameManager.getInstance().getPlayerGameId(player);
			}
			else{
				gid =  Integer.parseInt(args[0]);
			}

			String[] msg = GameManager.getInstance().getStringList(gid).split("\n");
			player.sendMessage(msg);
			return false;
                } catch (NumberFormatException ex) {
                    MessageManager.getInstance().sendFMessage(MessageManager.PrefixType.ERROR, "error.notanumber", player, "input-Arena");
                } catch (NullPointerException ex) {
                    MessageManager.getInstance().sendMessage(MessageManager.PrefixType.ERROR, "error.gamenoexist", player);
                }
		return false;
	}

	@Override
	public String help(Player p) {
        return "/list - " + SettingsManager.getInstance().getMessageConfig().getString("messages.help.listplayers","List all players in the arena you are playing in");
	}

	@Override
	public String permission() {
		return "";
	}

}