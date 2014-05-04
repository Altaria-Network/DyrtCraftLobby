package pl.dyrtcraft.dyrtcraftlobby.shot.listeners;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import pl.dyrtcraft.dyrtcraftlobby.DCLobby;
import pl.dyrtcraft.dyrtcraftlobby.Setting;
import pl.dyrtcraft.dyrtcraftlobby.shot.DyrtCraftLobbyShot;

public class PlayerMoveListener implements Listener {
	
	DyrtCraftLobbyShot plugin;
	
	public PlayerMoveListener(DyrtCraftLobbyShot dyrtCraftLobbyTree) {
		plugin = dyrtCraftLobbyTree;
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent e) {
		if(e.getPlayer().isOp() && DCLobby.getSettings().getValue(Setting.PROTECT) == false) { return; }
		
		if(e.getPlayer().isFlying()) {
			e.getPlayer().setFlying(false);
			e.getPlayer().setAllowFlight(true);
		}
		
		if(e.getTo().getBlockY() < 84 || e.getTo().getBlockY() > 120) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERMAN_TELEPORT, 10, 1);
			DCLobby.getPlayer(e.getPlayer()).reset();
		}
		else if(e.getTo().getBlockX() < -82 || e.getTo().getBlockX() > -2) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERMAN_TELEPORT, 10, 1);
			DCLobby.getPlayer(e.getPlayer()).reset();
		}
		else if(e.getTo().getBlockZ() < -81 || e.getTo().getBlockZ() > -1) {
			e.getPlayer().playSound(e.getPlayer().getLocation(), Sound.ENDERMAN_TELEPORT, 10, 1);
			DCLobby.getPlayer(e.getPlayer()).reset();
		}
	}
	
}
