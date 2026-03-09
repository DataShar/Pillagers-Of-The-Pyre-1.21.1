package net.nightmaresmc.potp.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.nightmaresmc.potp.block.ModBlocks;
import net.nightmaresmc.potp.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.RAVAGERITE_BLOCK);
        addDrop(ModBlocks.RAW_RAVAGERITE_BLOCK);
        addDrop(ModBlocks.MAGIC_FORGER);

        addDrop(ModBlocks.REINFORCED_RAVAGERITE_STAIRS);
        addDrop(ModBlocks.REINFORCED_RAVAGERITE_SLAB, slabDrops(ModBlocks.REINFORCED_RAVAGERITE_SLAB));

        addDrop(ModBlocks.REINFORCED_RAVAGERITE_BUTTON);
        addDrop(ModBlocks.REINFORCED_RAVAGERITE_PRESSURE_PLATE);

        addDrop(ModBlocks.REINFORCED_RAVAGERITE_FENCE_GATE);
        addDrop(ModBlocks.REINFORCED_RAVAGERITE_FENCE);
        addDrop(ModBlocks.REINFORCED_RAVAGERITE_WALL);

        addDrop(ModBlocks.REINFORCED_RAVAGERITE_DOOR, doorDrops(ModBlocks.REINFORCED_RAVAGERITE_DOOR));
        addDrop(ModBlocks.REINFORCED_RAVAGERITE_TRAPDOOR);

        addDrop(ModBlocks.RAVAGERITE_DEEPSLATE_ORE, multipleOreDrops(ModBlocks.RAVAGERITE_DEEPSLATE_ORE, ModItems.RAVAGERITE_SHARD, 1, 2));

    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
