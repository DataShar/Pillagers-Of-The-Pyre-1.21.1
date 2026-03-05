package net.nightmaresmc.potp;

import net.fabricmc.api.ModInitializer;

import net.nightmaresmc.potp.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PillagersOfThePyre implements ModInitializer {
	public static final String MOD_ID = "pillagers-of-the-pyre";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}