package net.nightmaresmc.potp.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nightmaresmc.potp.PillagersOfThePyre;
import net.nightmaresmc.potp.item.custom.StaffItem;

import java.util.List;

public class ModItems {
    public static final Item RAVAGERITE_INGOT = registerItem("ravagerite_ingot", new Item(new Item.Settings()));
    public static final Item RAW_RAVAGERITE = registerItem("raw_ravagerite", new Item(new Item.Settings()));
    public static final Item RAVAGERITE_SHARD = registerItem("ravagerite_shard", new Item(new Item.Settings()));
    public static final Item RAVAGERITE_GEM = registerItem("ravagerite_gem",new Item(new Item.Settings()));
    public static final Item RAVAGERITE_INFUSED_STICK = registerItem("ravagerite_infused_stick", new Item(new Item.Settings()));
    public static final Item MEAD = registerItem("mead", new Item(new Item.Settings().food(ModFoodComponents.MEAD)));
    public static final Item RAW_GOAT_MEAT = registerItem("raw_goat_meat", new Item(new Item.Settings().food(ModFoodComponents.RAW_GOAT_MEAT)));
    public static final Item COOKED_GOAT_MEAT = registerItem("cooked_goat_meat", new Item(new Item.Settings().food(ModFoodComponents.COOKED_GOAT_MEAT)));
    public static final Item RAW_HORSE_MEAT = registerItem("raw_horse_meat", new Item(new Item.Settings().food(ModFoodComponents.RAW_HORSE_MEAT)));
    public static final Item COOKED_HORSE_MEAT = registerItem("cooked_horse_meat", new Item(new Item.Settings().food(ModFoodComponents.COOKED_HORSE_MEAT)));
    public static final Item PILLAGER_HERB = registerItem("pillager_herb", new Item(new Item.Settings().food(ModFoodComponents.PILLAGER_HERB)) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip.pillagers-of-the-pyre.pillager_herb.tooltip.1"));
            tooltip.add(Text.translatable("tooltip.pillagers-of-the-pyre.pillager_herb.tooltip.2"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item DRAGON_FLAME_EMBERS = registerItem("dragon_flame_embers", new Item(new Item.Settings()) {
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            if (Screen.hasShiftDown()) {
                tooltip.add(Text.translatable("tooltip.pillagers-of-the-pyre.dragon_embers.tooltip.shift_down.1"));
                tooltip.add(Text.translatable("tooltip.pillagers-of-the-pyre.dragon_embers.tooltip.shift_down.2"));
                tooltip.add(Text.translatable("tooltip.pillagers-of-the-pyre.dragon_embers.tooltip.shift_down.3"));
                tooltip.add(Text.translatable("tooltip.pillagers-of-the-pyre.dragon_embers.tooltip.shift_down.4"));
                tooltip.add(Text.translatable("tooltip.pillagers-of-the-pyre.dragon_embers.tooltip.shift_down.5"));
                tooltip.add(Text.translatable("tooltip.pillagers-of-the-pyre.dragon_embers.tooltip.shift_down.6"));
                tooltip.add(Text.translatable("tooltip.pillagers-of-the-pyre.dragon_embers.tooltip.shift_down.7"));
            } else {
                tooltip.add(Text.translatable("tooltip.pillagers-of-the-pyre.dragon_embers.tooltip.1"));
            }

            super.appendTooltip(stack, context, tooltip, type);
        }
    });



    public static final Item STAFF =registerItem("staff", new StaffItem(new Item.Settings().maxDamage(32)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(PillagersOfThePyre.MOD_ID, name), item);
    }

    public static void registerModItems() {
        PillagersOfThePyre.LOGGER.info("Registering Mod Items for " + PillagersOfThePyre.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RAVAGERITE_INGOT);
            entries.add(RAW_RAVAGERITE);
            entries.add(RAVAGERITE_SHARD);
        });
    }
}