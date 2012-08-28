package com.MoofIT.Minecraft.ColdGlowstone;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class ColdGlowstone extends JavaPlugin {
	private final ColdGlowstoneBlockListener blockListener = new ColdGlowstoneBlockListener();

	public static Logger log;

	public void onEnable() {
		log = Logger.getLogger("Minecraft");
		versionCheck();

		getServer().getPluginManager().registerEvents(blockListener, this);

		log.info("ColdGlowstone " + getDescription().getVersion() + ": It's all alright, daddio.");
	}

	public void onDisable() {
		log.info("[ColdGlowstone] Shutting down.");
	}

	public void versionCheck() {
		String thisVersion = getDescription().getVersion();
		URL url = null;
		try {
			url = new URL("http://www.moofit.com/minecraft/coldglowstone.ver?v=" + thisVersion);
			BufferedReader in = null;
			in = new BufferedReader(new InputStreamReader(url.openStream()));
			String newVersion = "";
			String line;
			while ((line = in.readLine()) != null) {
				newVersion += line;
			}
			in.close();
			if (!newVersion.equals(thisVersion)) {
				log.warning("[ColdGlowstone] ColdGlowstone is out of date! This version: " + thisVersion + "; latest version: " + newVersion + ".");
			}
			else {
				log.info("[ColdGlowstone] ColdGlowstone is up to date at version " + thisVersion + ".");
			}
		}
		catch (MalformedURLException ex) {
			log.warning("[ColdGlowstone] Error accessing update URL.");
		}
		catch (IOException ex) {
			log.warning("[ColdGlowstone] Error checking for update.");
		}
	}
}