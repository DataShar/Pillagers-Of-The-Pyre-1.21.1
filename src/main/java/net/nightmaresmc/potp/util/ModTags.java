package net.nightmaresmc.potp.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.nightmaresmc.potp.PillagersOfThePyre;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_REINFORCED_RAVAGERITE_TOOL = createTag("needs_reinforced_ravagerite_tool");
        public static final TagKey<Block> INCORRECT_FOR_REINFORCED_RAVAGERITE_TOOL =createTag("incorrect_for_reinforced_ravagerite_tool");
        public static final TagKey<Block> NEEDS_RAVAGERITE_TOOL = createTag("needs_ravagerite_tool");
        public static final TagKey<Block> INCORRECT_FOR_RAVAGERITE_TOOL =createTag("incorrect_for_ravagerite_tool");


        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(PillagersOfThePyre.MOD_ID, name));
        }

    }

    public static class Items {
        public static final TagKey<Item> MAGIC_FORGER_RECIPE_1 = createTag("magic_forger_recipe_1");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(PillagersOfThePyre.MOD_ID, name));
        }
    }
}




