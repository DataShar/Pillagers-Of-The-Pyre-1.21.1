package net.nightmaresmc.potp.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent RAW_GOAT_MEAT = new FoodComponent.Builder().nutrition(5).saturationModifier(0.75f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600), 0.3f).build();
    public static final FoodComponent COOKED_GOAT_MEAT = new FoodComponent.Builder().nutrition(4).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 1.0f).build();
    public static final FoodComponent MEAD = new FoodComponent.Builder().snack().saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 1000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1000), 1.0f)
            .alwaysEdible().build();
    public static final FoodComponent PILLAGER_HERB = new FoodComponent.Builder().snack().saturationModifier(0.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 1000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 1000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 1000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 1000), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1000), 1.0f)
            .alwaysEdible().build();

    public static final FoodComponent RAW_HORSE_MEAT = new FoodComponent.Builder().nutrition(5).saturationModifier(0.75f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 600), 0.3f).build();
    public static final FoodComponent COOKED_HORSE_MEAT = new FoodComponent.Builder().nutrition(4).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 1.0f).build();
}



