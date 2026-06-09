package net.ei3.baldejdelights.common.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {

    public static final FoodProperties ONION_FRENZY = new FoodProperties.Builder().nutrition(9).saturationModifier(1f)
            .usingConvertsTo(Items.BOWL)

            .build();

    public static final FoodProperties APPLES_IN_CHICKEN_BROTH = new FoodProperties.Builder().nutrition(10).saturationModifier(1f)
            .usingConvertsTo(Items.BOWL)

            .build();

    public static final FoodProperties EGG_BARBECUE = new FoodProperties.Builder().nutrition(1).saturationModifier(0.2f)
            .usingConvertsTo(Items.STICK)

            .build();

    public static final FoodProperties BOBS = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5f)

            .build();

    public static final FoodProperties FRIED_NAILS = new FoodProperties.Builder().nutrition(6).saturationModifier(0.8f)
            .usingConvertsTo(Items.BOWL)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 0), 0.5f)

            .build();

    public static final FoodProperties SLOP = new FoodProperties.Builder().nutrition(10).saturationModifier(0.7f)
            .usingConvertsTo(Items.BOWL)
            .build();

    public static final FoodProperties SAINT_SLOP = new FoodProperties.Builder().nutrition(20).saturationModifier(0.7f)
            .usingConvertsTo(Items.BOWL)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 3), 1f)
            .effect(() -> new MobEffectInstance(ModEffects.TOMATO_BLESSING, 2400, 0), 1f)
            .build();

    public static final FoodProperties OVERCOOKED_PANCAKES = new FoodProperties.Builder().nutrition(5).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.DISAPPOINTMENT, 600, 0), 0.5f)

            .build();

    public static final FoodProperties TOMATO_WITH_MALTESE_CROSS = new FoodProperties.Builder().nutrition(3).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200, 2), 1f)
            .effect(() -> new MobEffectInstance(ModEffects.TOMATO_BLESSING, 1200, 0), 1f)

            .build();

    public static final FoodProperties FOUR_MEAT_PIE_SLICE = new FoodProperties.Builder().nutrition(4).saturationModifier(0.7f)

            .build();


}
