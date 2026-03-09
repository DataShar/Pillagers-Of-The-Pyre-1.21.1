package net.nightmaresmc.potp.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.PotionItem;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.ShapelessRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.nightmaresmc.potp.PillagersOfThePyre;
import net.nightmaresmc.potp.block.ModBlocks;
import net.nightmaresmc.potp.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider  extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        List<ItemConvertible> RAVAGERITE_INGOT_SMELTABLES = List.of(ModItems.RAW_RAVAGERITE);
        List<ItemConvertible> PILLAGER_FOOD_1 = List.of(ModItems.RAW_GOAT_MEAT);
        List<ItemConvertible> PILLAGER_FOOD_2 = List.of(ModItems.RAW_HORSE_MEAT);

        offerSmelting(exporter, RAVAGERITE_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.RAVAGERITE_INGOT, 0.35f, 8000, "ravagerite");
        offerBlasting(exporter, RAVAGERITE_INGOT_SMELTABLES, RecipeCategory.MISC, ModItems.RAVAGERITE_INGOT, 0.35f, 8000, "ravagerite");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAVAGERITE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.RAVAGERITE_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.MAGIC_FORGER)
                .pattern("BGB")
                .pattern("GFG")
                .pattern("BGB")
                .input('B', ModBlocks.RAVAGERITE_BLOCK)
                .input('F', ModItems.DRAGON_FLAME_EMBERS)
                .input('G', ModItems.RAVAGERITE_GEM)
                .criterion(hasItem(ModItems.RAVAGERITE_GEM), conditionsFromItem(ModItems.RAVAGERITE_GEM))
                .criterion(hasItem(ModBlocks.RAVAGERITE_BLOCK), conditionsFromItem(ModBlocks.RAVAGERITE_BLOCK))
                .criterion(hasItem(ModItems.DRAGON_FLAME_EMBERS), conditionsFromItem(ModItems.DRAGON_FLAME_EMBERS))
                .offerTo(exporter);

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_RAVAGERITE, RecipeCategory.DECORATIONS, ModBlocks.RAW_RAVAGERITE_BLOCK);

        offerSmelting(exporter, PILLAGER_FOOD_1, RecipeCategory.MISC, ModItems.COOKED_GOAT_MEAT, 0.15f, 600, "food");
        offerSmelting(exporter, PILLAGER_FOOD_2, RecipeCategory.MISC, ModItems.COOKED_HORSE_MEAT, 0.15f, 600, "food");
        offerBlasting(exporter, PILLAGER_FOOD_1, RecipeCategory.MISC, ModItems.COOKED_GOAT_MEAT, 0.15f, 500, "food");
        offerBlasting(exporter, PILLAGER_FOOD_2, RecipeCategory.MISC, ModItems.COOKED_HORSE_MEAT, 0.15f, 500, "food");

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.STAFF)
                .pattern(" G ")
                .pattern(" F ")
                .pattern(" B ")
                .input('B', ModItems.RAVAGERITE_INFUSED_STICK)
                .input('F', ModItems.DRAGON_FLAME_EMBERS)
                .input('G', ModItems.RAVAGERITE_GEM)
                .criterion(hasItem(ModItems.RAVAGERITE_GEM), conditionsFromItem(ModItems.RAVAGERITE_GEM))
                .criterion(hasItem(ModItems.RAVAGERITE_INFUSED_STICK), conditionsFromItem(ModItems.RAVAGERITE_INFUSED_STICK))
                .criterion(hasItem(ModItems.DRAGON_FLAME_EMBERS), conditionsFromItem(ModItems.DRAGON_FLAME_EMBERS))
                .offerTo(exporter);


        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAW_RAVAGERITE)
                .pattern("SSS")
                .pattern("SDS")
                .pattern("SSS")
                .input('S', ModItems.RAVAGERITE_SHARD)
                .input('D', Blocks.DEEPSLATE)
                .criterion(hasItem(ModItems.RAVAGERITE_SHARD), conditionsFromItem(ModItems.RAVAGERITE_SHARD))
                .criterion(hasItem(Blocks.DEEPSLATE), conditionsFromItem(Blocks.DEEPSLATE))
                .offerTo(exporter, Identifier.of(PillagersOfThePyre.MOD_ID, "raw_ravagerite_from_normal"));

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.RAVAGERITE_GEM, 1)
                .input(ModItems.DRAGON_FLAME_EMBERS)
                .input(ModItems.RAVAGERITE_INGOT)
                .criterion(hasItem(ModItems.DRAGON_FLAME_EMBERS), conditionsFromItem(ModItems.DRAGON_FLAME_EMBERS))
                .criterion(hasItem(ModItems.RAVAGERITE_INGOT), conditionsFromItem(ModItems.RAVAGERITE_INGOT))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.REINFORCED_RAVAGERITE_INGOT, 1)
                .input(ModItems.RAVAGERITE_INGOT)
                .input(ModItems.RAVAGERITE_INGOT)
                .criterion(hasItem(ModItems.RAVAGERITE_INGOT), conditionsFromItem(ModItems.RAVAGERITE_INGOT))
                .criterion(hasItem(ModItems.RAVAGERITE_INGOT), conditionsFromItem(ModItems.RAVAGERITE_INGOT))
                .offerTo(exporter);

        createStairsRecipe(ModBlocks.REINFORCED_RAVAGERITE_STAIRS, Ingredient.ofItems(ModItems.REINFORCED_RAVAGERITE_INGOT))
                .criterion(hasItem(ModItems.REINFORCED_RAVAGERITE_INGOT), conditionsFromItem(ModItems.REINFORCED_RAVAGERITE_INGOT))
                .offerTo(exporter);

        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.REINFORCED_RAVAGERITE_SLAB,
                Ingredient.ofItems(ModItems.REINFORCED_RAVAGERITE_INGOT))
                .criterion(hasItem(ModItems.REINFORCED_RAVAGERITE_INGOT), conditionsFromItem(ModItems.REINFORCED_RAVAGERITE_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.REINFORCED_RAVAGERITE_WALL)
                .pattern("   ")
                .pattern("SSS")
                .pattern("SSS")
                .input('S', ModItems.REINFORCED_RAVAGERITE_INGOT)
                .criterion(hasItem(ModItems.REINFORCED_RAVAGERITE_INGOT), conditionsFromItem(ModItems.REINFORCED_RAVAGERITE_INGOT))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.REINFORCED_RAVAGERITE_BUTTON, 1)
                .input(ModItems.REINFORCED_RAVAGERITE_INGOT)
                .criterion(hasItem(ModItems.REINFORCED_RAVAGERITE_INGOT), conditionsFromItem(ModItems.REINFORCED_RAVAGERITE_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.REINFORCED_RAVAGERITE_FENCE)
                .pattern("   ")
                .pattern("SDS")
                .pattern("SDS")
                .input('S', ModItems.REINFORCED_RAVAGERITE_INGOT)
                .input('D', ModItems.RAVAGERITE_INFUSED_STICK)
                .criterion(hasItem(ModItems.REINFORCED_RAVAGERITE_INGOT), conditionsFromItem(ModItems.REINFORCED_RAVAGERITE_INGOT))
                .criterion(hasItem(ModItems.RAVAGERITE_INFUSED_STICK), conditionsFromItem(ModItems.RAVAGERITE_INFUSED_STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.REINFORCED_RAVAGERITE_FENCE_GATE)
                .pattern("   ")
                .pattern("DSD")
                .pattern("DSD")
                .input('S', ModItems.REINFORCED_RAVAGERITE_INGOT)
                .input('D', ModItems.RAVAGERITE_INFUSED_STICK)
                .criterion(hasItem(ModItems.REINFORCED_RAVAGERITE_INGOT), conditionsFromItem(ModItems.REINFORCED_RAVAGERITE_INGOT))
                .criterion(hasItem(ModItems.RAVAGERITE_INFUSED_STICK), conditionsFromItem(ModItems.RAVAGERITE_INFUSED_STICK))
                .offerTo(exporter);

        createDoorRecipe(ModBlocks.REINFORCED_RAVAGERITE_DOOR,
                Ingredient.ofItems(ModItems.REINFORCED_RAVAGERITE_INGOT))
                .criterion(hasItem(ModItems.REINFORCED_RAVAGERITE_INGOT), conditionsFromItem(ModItems.REINFORCED_RAVAGERITE_INGOT))
                .offerTo(exporter);

    }
}
