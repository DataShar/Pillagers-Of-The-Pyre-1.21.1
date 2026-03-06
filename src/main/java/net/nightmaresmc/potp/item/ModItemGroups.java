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

                    }).build());

    public static final ItemGroup RAVAGERITE_BLOCKS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(PillagersOfThePyre.MOD_ID, "ravagerite_blocks"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.RAVAGERITE_DEEPSLATE_ORE))
                    .displayName(Text.translatable("itemgroup.potp.ravagerite_blocks"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.RAVAGERITE_BLOCK);
                        entries.add(ModBlocks.RAW_RAVAGERITE_BLOCK);
                        entries.add(ModBlocks.RAVAGERITE_DEEPSLATE_ORE);

                    }).build());



    public static void registerItemGroups() {
        PillagersOfThePyre.LOGGER.info("Registering Item Groups for " + PillagersOfThePyre.MOD_ID);
    }
}
