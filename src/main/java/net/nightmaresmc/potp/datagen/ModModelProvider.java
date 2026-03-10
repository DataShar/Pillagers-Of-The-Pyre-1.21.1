package net.nightmaresmc.potp.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.nightmaresmc.potp.block.ModBlocks;
import net.nightmaresmc.potp.item.ModItems;
import net.minecraft.data.client.TextureMap;
import net.minecraft.data.client.TextureKey;
import net.minecraft.data.client.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_RAVAGERITE_BLOCK);
        BlockStateModelGenerator.BlockTexturePool ravageritePool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RAVAGERITE_BLOCK);
        blockStateModelGenerator.registerSingleton(
                ModBlocks.RAVAGERITE_DEEPSLATE_ORE,
                TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerSingleton(
                ModBlocks.MAGIC_FORGER,
                TexturedModel.CUBE_BOTTOM_TOP);

        ravageritePool.stairs(ModBlocks.REINFORCED_RAVAGERITE_STAIRS);
        ravageritePool.slab(ModBlocks.REINFORCED_RAVAGERITE_SLAB);
        ravageritePool.fence(ModBlocks.REINFORCED_RAVAGERITE_FENCE);
        ravageritePool.fenceGate(ModBlocks.REINFORCED_RAVAGERITE_FENCE_GATE);
        ravageritePool.button(ModBlocks.REINFORCED_RAVAGERITE_BUTTON);
        ravageritePool.pressurePlate(ModBlocks.REINFORCED_RAVAGERITE_PRESSURE_PLATE);
        ravageritePool.wall(ModBlocks.REINFORCED_RAVAGERITE_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.REINFORCED_RAVAGERITE_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.REINFORCED_RAVAGERITE_TRAPDOOR);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RAVAGERITE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RAVAGERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAVAGERITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.REINFORCED_RAVAGERITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAVAGERITE_GEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.MEAD, Models.GENERATED);
        itemModelGenerator.register(ModItems.PILLAGER_HERB, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_GOAT_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_HORSE_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_GOAT_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_HORSE_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.DRAGON_FLAME_EMBERS, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAVAGERITE_INFUSED_STICK, Models.HANDHELD_ROD);
        itemModelGenerator.register(ModItems.STAFF, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RAVAGERITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RAVAGERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RAVAGERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RAVAGERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.RAVAGERITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REINFORCED_RAVAGERITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REINFORCED_RAVAGERITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REINFORCED_RAVAGERITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REINFORCED_RAVAGERITE_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.REINFORCED_RAVAGERITE_HOE, Models.HANDHELD);
    }
}
