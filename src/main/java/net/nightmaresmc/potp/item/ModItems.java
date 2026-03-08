package net.nightmaresmc.potp.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nightmaresmc.potp.PillagersOfThePyre;
import net.nightmaresmc.potp.item.custom.StaffItem;

public class ModItems {
    public static final Item RAVAGERITE_INGOT = registerItem("ravagerite_ingot", new Item(new Item.Settings()));
    public static final Item RAW_RAVAGERITE = registerItem("raw_ravagerite", new Item(new Item.Settings()));
    public static final Item RAVAGERITE_SHARD = registerItem("ravagerite_shard", new Item(new Item.Settings()));
    public static final Item RAVAGERITE_GEM = registerItem("ravagerite_gem",new Item(new Item.Settings()));
    public static final Item RAVAGERITE_INFUSED_STICK = registerItem("ravagerite_infused_stick", new Item(new Item.Settings()));
    public static final Item MEAD = registerItem("mead", new Item(new Item.Settings().food(ModFoodComponents.MEAD)));
    public static final Item RAW_GOAT_MEAT = registerItem("raw_goat_meat", new Item(new Item.Settings().food(ModFoodComponents.RAW_GOAT_MEAT)));
    public static final Item COOKED_GOAT_MEAT = registerItem("cooked_goat_meat", new Item(new Item.Settings().food(ModFoodComponents.COOKED_GOAT_MEAT)));
    public static final Item RAW_HORSE_MEAT = registerItem("raw_horse_meat", new Item(new Item.Settings().food(ModFoodComponents.RAW_HORSE_MEAT)));
    public static final Item COOKED_HORSE_MEAT = registerItem("cooked_horse_meat", new Item(new Item.Settings().food(ModFoodComponents.COOKED_HORSE_MEAT)));


    public static final Item STAFF =registerItem("staff", new StaffItem(new Item.Settings().maxDamage(32)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PillagersOfThePyre.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PillagersOfThePyre.LOGGER.info("Registering Mod Items for " + PillagersOfThePyre.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAVAGERITE_INGOT);
            entries.add(RAW_RAVAGERITE);
            entries.add(RAVAGERITE_SHARD);
        });
    }
}