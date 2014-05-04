package pl.dyrtcraft.dyrtcraftlobby.shot.listeners;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import pl.dyrtcraft.DyrtCraft;
import pl.dyrtcraft.dyrtcraftlobby.DCLobby;
import pl.dyrtcraft.dyrtcraftlobby.shot.DyrtCraftLobbyShot;

public class PlayerJoinListener implements Listener {

	DyrtCraftLobbyShot plugin;
	private ArrayList<String> players = new ArrayList<String>();
	
	public PlayerJoinListener(DyrtCraftLobbyShot dyrtCraftLobbyTree) {
		plugin = dyrtCraftLobbyTree;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		//e.setJoinMessage("�f<> �a" + e.getPlayer().getName() + " �adolaczyl do Lobby�f <>");
		e.setJoinMessage("");
		
		DCLobby.getPlayer(e.getPlayer()).reset();
	}
	
}
