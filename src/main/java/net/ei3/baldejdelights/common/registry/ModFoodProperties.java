package net.ei3.baldejdelights.common.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Items;

public class ModFoodProperties {

    public static final FoodProperties ONION_FRENZY = new FoodProperties.Builder().nutrition(7).saturationModifier(1f)
            .usingConvertsTo(Items.BOWL)

            .build();

    public static final FoodProperties APPLES_IN_CHICKEN_BROTH = new FoodProperties.Builder().nutrition(8).saturationModifier(1f)
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

    public static final FoodProperties OVERCOOKED_PANCAKES = new FoodProperties.Builder().nutrition(5).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.DISAPPOINTMENT, 600, 0), 0.5f)

            .build();
}
