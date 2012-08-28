package com.MoofIT.Minecraft.ColdGlowstone;

import org.bukkit.Material;
import org.bukkit.event.block.BlockPhysicsEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ColdGlowstoneBlockListener implements Listener {
	public ColdGlowstoneBlockListener() {}

	@EventHandler(priority = EventPriority.HIGH)
	public void BlockPhysicsEvent(BlockPhysicsEvent event) {
		if (event.getBlock().getType() != Material.GLOWSTONE) return;
		event.setCancelled(true);
		return;
	}
}
