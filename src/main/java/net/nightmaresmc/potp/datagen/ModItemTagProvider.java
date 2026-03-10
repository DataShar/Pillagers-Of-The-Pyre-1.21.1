package net.nightmaresmc.potp.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.nightmaresmc.potp.item.ModItems;
import net.nightmaresmc.potp.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ModTags.Items.MAGIC_FORGER_RECIPE_1)
                .add(Items.STICK);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.RAVAGERITE_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.RAVAGERITE_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.RAVAGERITE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.RAVAGERITE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.RAVAGERITE_HOE);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.REINFORCED_RAVAGERITE_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.REINFORCED_RAVAGERITE_AXE);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.REINFORCED_RAVAGERITE_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.REINFORCED_RAVAGERITE_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.REINFORCED_RAVAGERITE_HOE);
    }
}
