package net.nightmaresmc.potp.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.nightmaresmc.potp.PillagersOfThePyre;

public class ModBlocks {
    public static final Block RAVAGERITE_BLOCK = registerBlock("ravagerite_block",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));
    public static final Block RAW_RAVAGERITE_BLOCK = registerBlock("raw_ravagerite_block",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));

    public static final Block RAVAGERITE_DEEPSLATE_ORE = registerBlock("ravagerite_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 3),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)));





    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(PillagersOfThePyre.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(PillagersOfThePyre.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        PillagersOfThePyre.LOGGER.info("Registering Mod Blocks for " + PillagersOfThePyre.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.RAVAGERITE_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.RAW_RAVAGERITE_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.RAVAGERITE_DEEPSLATE_ORE);
        });
    }
}
