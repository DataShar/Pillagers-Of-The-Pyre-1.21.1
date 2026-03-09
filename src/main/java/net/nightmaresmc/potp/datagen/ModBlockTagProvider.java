package net.nightmaresmc.potp.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.nightmaresmc.potp.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAVAGERITE_BLOCK)
                .add(ModBlocks.RAW_RAVAGERITE_BLOCK)
                .add(ModBlocks.RAVAGERITE_DEEPSLATE_ORE)
                .add(ModBlocks.MAGIC_FORGER);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAVAGERITE_BLOCK)
                .add(ModBlocks.RAW_RAVAGERITE_BLOCK)
                .add(ModBlocks.RAVAGERITE_DEEPSLATE_ORE)
                .add(ModBlocks.MAGIC_FORGER);

        getOrCreateTagBuilder(BlockTags.FENCES).add(ModBlocks.REINFORCED_RAVAGERITE_FENCE);
        getOrCreateTagBuilder(BlockTags.FENCE_GATES).add(ModBlocks.REINFORCED_RAVAGERITE_FENCE_GATE);
        getOrCreateTagBuilder(BlockTags.WALLS).add(ModBlocks.REINFORCED_RAVAGERITE_WALL);

    }
}
