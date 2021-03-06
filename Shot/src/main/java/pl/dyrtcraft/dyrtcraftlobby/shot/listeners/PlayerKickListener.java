package pl.dyrtcraft.dyrtcraftlobby.shot.listeners;

import me.confuser.barapi.BarAPI;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.inventory.meta.FireworkMeta;

import pl.dyrtcraft.dyrtcraftlobby.shot.DyrtCraftLobbyShot;

public class PlayerKickListener implements Listener {

	DyrtCraftLobbyShot plugin;
	
	public PlayerKickListener(DyrtCraftLobbyShot dyrtCraftLobbyTree) {
		plugin = dyrtCraftLobbyTree;
	}
	
	@EventHandler
	public void onPlayerKick(PlayerKickEvent e) {
		//e.setLeaveMessage("�f<> �a" + e.getPlayer().getName() + " �awyszedl z Lobby�f <>");
		e.setLeaveMessage("");
		
		Firework fw = (Firework) e.getPlayer().getWorld().spawn(e.getPlayer().getLocation(), Firework.class);
		
		FireworkMeta fwMeta = fw.getFireworkMeta();
		fwMeta.addEffect(FireworkEffect.builder()
						.flicker(true)
						.trail(true)
						.with(Type.CREEPER)
						.withColor(Color.GREEN)
						.withFade(Color.ORANGE)
						.build());
		fwMeta.setPower(1);
		fw.setFireworkMeta(fwMeta);
		
		//Bar.removeBar(e.getPlayer());
		BarAPI.removeBar(e.getPlayer());
	}
	
}
