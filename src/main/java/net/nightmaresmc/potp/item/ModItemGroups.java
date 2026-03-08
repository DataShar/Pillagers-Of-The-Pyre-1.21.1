package net.nightmaresmc.potp.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nightmaresmc.potp.PillagersOfThePyre;
import net.nightmaresmc.potp.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup RAVAGERITE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PillagersOfThePyre.MOD_ID, "ravagerite_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.RAVAGERITE_INGOT))
                    .displayName(Text.translatable("itemgroup.potp.ravagerite_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAVAGERITE_INGOT);
                        entries.add(ModItems.RAW_RAVAGERITE);
                        entries.add(ModItems.RAVAGERITE_SHARD);
                        entries.add(ModItems.STAFF);
                        entries.add(ModItems.RAVAGERITE_GEM);
                        entries.add(ModItems.RAVAGERITE_INFUSED_STICK);

                    }).build());

    public static final ItemGroup RAVAGERITE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PillagersOfThePyre.MOD_ID, "ravagerite_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.RAVAGERITE_DEEPSLATE_ORE))
                    .displayName(Text.translatable("itemgroup.potp.ravagerite_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RAVAGERITE_BLOCK);
                        entries.add(ModBlocks.RAW_RAVAGERITE_BLOCK);
                        entries.add(ModBlocks.RAVAGERITE_DEEPSLATE_ORE);

                        entries.add(ModBlocks.MAGIC_FORGER);

                    }).build());

    public static final ItemGroup PILLAGER_DRINK_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PillagersOfThePyre.MOD_ID, "pillager_drinks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.MEAD))
                    .displayName(Text.translatable("itemgroup.potp.pillager_drinks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.MEAD);


                    }).build());

    public static final ItemGroup PILLAGER_FOOD_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PillagersOfThePyre.MOD_ID, "pillager_foods"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.COOKED_HORSE_MEAT))
                    .displayName(Text.translatable("itemgroup.potp.pillager_foods"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_GOAT_MEAT);
                        entries.add(ModItems.RAW_HORSE_MEAT);
                        entries.add(ModItems.COOKED_GOAT_MEAT);
                        entries.add(ModItems.COOKED_HORSE_MEAT);
                        entries.add(ModItems.PILLAGER_HERB);

                    }).build());

    public static final ItemGroup PILLAGER_FUEL_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PillagersOfThePyre.MOD_ID, "pillager_fuel"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.DRAGON_FLAME_EMBERS))
                    .displayName(Text.translatable("itemgroup.potp.pillager_fuel"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.DRAGON_FLAME_EMBERS);

                    }).build());


    public static void registerItemGroups() {
        PillagersOfThePyre.LOGGER.info("Registering Item Groups for " + PillagersOfThePyre.MOD_ID);
    }
}
