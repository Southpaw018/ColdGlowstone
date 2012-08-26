package com.MoofIT.Minecraft.ColdGlowstone;

import org.bukkit.Material;
import org.bukkit.event.block.BlockFadeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ColdGlowstoneBlockFadeListener implements Listener {
	public ColdGlowstoneBlockFadeListener() {}

	@EventHandler(priority = EventPriority.HIGH)
	public void BlockFadeEvent(BlockFadeEvent event) {
		if (event.getBlock().getType() != Material.GLOWSTONE) return;
		event.setCancelled(true);
		return;
	}
}