package com.thundergemios10.walls.commands;

import org.bukkit.entity.Player;
import com.thundergemios10.walls.LobbyManager;
import com.thundergemios10.walls.MessageManager;
import com.thundergemios10.walls.SettingsManager;



public class AddLobbyWall implements SubCommand{

    public boolean onCommand(Player player, String[] args) {
        if(!player.hasPermission(permission()) && !player.isOp()){
            MessageManager.getInstance().sendFMessage(MessageManager.PrefixType.ERROR, "error.nopermission", player);
            return true;
        }
        else if(args.length<1){
                MessageManager.getInstance().sendFMessage(MessageManager.PrefixType.ERROR, "error.notspecified", player, "input-Arena");
        	return true;
        }
       LobbyManager.getInstance().setLobbySignsFromSelection(player, Integer.parseInt(args[0]));
       return true;
    }

    public String help(Player p) {
        return "/w addlobbywall <id> - " + SettingsManager.getInstance().getMessageConfig().getString("messages.help.addlobbywall", "Add a lobby stats wall for Arena <id>");
    }

	public String permission() {
		return "walls.admin.addlobbywall";
	}

    //TODO: TAKE A W.E SELECTIONA AND SET THE LOBBY. ALSO SET LOBBY WALL
}
