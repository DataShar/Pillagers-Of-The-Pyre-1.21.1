package net.nightmaresmc.potp.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nightmaresmc.potp.PillagersOfThePyre;

public class ModItems {
    public static final Item RED_GARNET = registerItem("red_garnet", new Item(new Item.Settings()));
    public static final Item RAW_RED_GARNET = registerItem("raw_red_garnet", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PillagersOfThePyre.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PillagersOfThePyre.LOGGER.info("Registering Mod Items for " + PillagersOfThePyre.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RED_GARNET);
            entries.add(RAW_RED_GARNET);
        });
    }
}