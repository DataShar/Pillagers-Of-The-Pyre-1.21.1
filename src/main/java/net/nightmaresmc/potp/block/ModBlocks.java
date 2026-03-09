package net.nightmaresmc.potp.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.nightmaresmc.potp.PillagersOfThePyre;
import net.nightmaresmc.potp.block.custom.MagicForgerBlock;

public class ModBlocks {
    public static final Block RAVAGERITE_BLOCK = registerBlock("ravagerite_block",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));
    public static final Block RAW_RAVAGERITE_BLOCK = registerBlock("raw_ravagerite_block",
            new Block(AbstractBlock.Settings.create().strength(3f).requiresTool().sounds(BlockSoundGroup.POLISHED_DEEPSLATE)));

    public static final Block RAVAGERITE_DEEPSLATE_ORE = registerBlock("ravagerite_deepslate_ore",
            new ExperienceDroppingBlock(UniformIntProvider.create(2, 3),
                    AbstractBlock.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.ANCIENT_DEBRIS)));



public static final Block MAGIC_FORGER = registerBlock("magic_forger",
        new MagicForgerBlock(AbstractBlock.Settings.create().strength(1f).requiresTool()));

public static final Block REINFORCED_RAVAGERITE_STAIRS = registerBlock("reinforced_ravagerite_stairs",
        new StairsBlock(ModBlocks.RAVAGERITE_BLOCK.getDefaultState(),
                AbstractBlock.Settings.create().strength(4f).requiresTool()));
public static final Block REINFORCED_RAVAGERITE_SLAB = registerBlock("reinforced_ravagerite_slab",
        new SlabBlock(AbstractBlock.Settings.create().strength(4f).requiresTool()));

public static final Block REINFORCED_RAVAGERITE_BUTTON = registerBlock("reinforced_ravagerite_button",
        new ButtonBlock(BlockSetType.IRON, 20, AbstractBlock.Settings.create().strength(4f).requiresTool().noCollision()));
public static final Block REINFORCED_RAVAGERITE_PRESSURE_PLATE = registerBlock("reinforced_ravagerite_pressure_plate",
        new PressurePlateBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(4f).requiresTool()));

public static final Block REINFORCED_RAVAGERITE_FENCE = registerBlock("reinforced_ravagerite_fence",
        new FenceBlock(AbstractBlock.Settings.create().strength(4f).requiresTool()));
public static final Block REINFORCED_RAVAGERITE_FENCE_GATE = registerBlock("reinforced_ravagerite_fence_gate",
        new FenceGateBlock(WoodType.SPRUCE, AbstractBlock.Settings.create().strength(4f).requiresTool()));
public static final Block REINFORCED_RAVAGERITE_WALL = registerBlock("reinforced_ravagerite_wall",
        new WallBlock (AbstractBlock.Settings.create().strength(4f).requiresTool()));


public static final Block REINFORCED_RAVAGERITE_DOOR = registerBlock("reinforced_ravagerite_door",
        new DoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(4f).requiresTool().nonOpaque()));
public static final Block REINFORCED_RAVAGERITE_TRAPDOOR = registerBlock("reinforced_ravagerite_trapdoor",
        new TrapdoorBlock(BlockSetType.IRON, AbstractBlock.Settings.create().strength(4f).requiresTool().nonOpaque()));

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
