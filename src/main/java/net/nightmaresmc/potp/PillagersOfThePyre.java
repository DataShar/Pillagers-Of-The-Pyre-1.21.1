package net.nightmaresmc.potp;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.nightmaresmc.potp.block.ModBlocks;
import net.nightmaresmc.potp.item.ModItemGroups;
import net.nightmaresmc.potp.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PillagersOfThePyre implements ModInitializer {
	public static final String MOD_ID = "pillagers-of-the-pyre";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.DRAGON_FLAME_EMBERS, 25000);
	}
}