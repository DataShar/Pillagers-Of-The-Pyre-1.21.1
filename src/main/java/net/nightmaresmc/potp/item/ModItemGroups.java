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
                        entries.add(ModItems.REINFORCED_RAVAGERITE_INGOT);

                    }).build());

    public static final ItemGroup RAVAGERITE_TOOLS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PillagersOfThePyre.MOD_ID, "ravagerite_tools"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.REINFORCED_RAVAGERITE_AXE))
                    .displayName(Text.translatable("itemgroup.potp.ravagerite_tools"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.RAVAGERITE_SWORD);
                        entries.add(ModItems.RAVAGERITE_AXE);
                        entries.add(ModItems.RAVAGERITE_PICKAXE);
                        entries.add(ModItems.RAVAGERITE_SHOVEL);
                        entries.add(ModItems.RAVAGERITE_HOE);
                        entries.add(ModItems.REINFORCED_RAVAGERITE_SWORD);
                        entries.add(ModItems.REINFORCED_RAVAGERITE_AXE);
                        entries.add(ModItems.REINFORCED_RAVAGERITE_PICKAXE);
                        entries.add(ModItems.REINFORCED_RAVAGERITE_SHOVEL);
                        entries.add(ModItems.REINFORCED_RAVAGERITE_HOE);

                    }).build());

    public static final ItemGroup RAVAGERITE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PillagersOfThePyre.MOD_ID, "ravagerite_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.RAVAGERITE_DEEPSLATE_ORE))
                    .displayName(Text.translatable("itemgroup.potp.ravagerite_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RAVAGERITE_BLOCK);
                        entries.add(ModBlocks.RAW_RAVAGERITE_BLOCK);
                        entries.add(ModBlocks.RAVAGERITE_DEEPSLATE_ORE);

                        entries.add(ModBlocks.REINFORCED_RAVAGERITE_STAIRS);
                        entries.add(ModBlocks.REINFORCED_RAVAGERITE_SLAB);

                        entries.add(ModBlocks.REINFORCED_RAVAGERITE_FENCE);
                        entries.add(ModBlocks.REINFORCED_RAVAGERITE_FENCE_GATE);
                        entries.add(ModBlocks.REINFORCED_RAVAGERITE_WALL);

                        entries.add(ModBlocks.REINFORCED_RAVAGERITE_BUTTON);
                        entries.add(ModBlocks.REINFORCED_RAVAGERITE_PRESSURE_PLATE);

                        entries.add(ModBlocks.REINFORCED_RAVAGERITE_DOOR);
                        entries.add(ModBlocks.REINFORCED_RAVAGERITE_TRAPDOOR);

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
