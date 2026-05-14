package net.ei3.baldejdelights.data.recipes;

import net.ei3.baldejdelights.BaldejDelights;
import net.ei3.baldejdelights.common.registry.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import vectorwing.farmersdelight.common.tag.CommonTags;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public class BasicRecipes {
    public static void register(RecipeOutput consumer) {
        shapelessRecipes(consumer);
        shapedRecipes(consumer);
    }

    public static void shapelessRecipes(RecipeOutput consumer) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.EGG_BARBECUE.get(), 1)
                .requires(Items.STICK)
                .requires(Items.EGG)
                .requires(Items.EGG)

                .unlockedBy("has_stick", hasItems(Items.STICK))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(BaldejDelights.MODID, "crafting/egg_barbecue"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BOBS.get(), 3)
                .requires(Items.SNOWBALL)
                .requires(Items.SUGAR)
                .requires(Items.LIME_DYE)

                .unlockedBy("has_snow", hasItems(Items.SNOW))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(BaldejDelights.MODID, "crafting/bobs"));
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.RAW_PANCAKES.get(), 1)
                .requires(Items.EGG)
                .requires(Items.MILK_BUCKET)
                .requires(Items.WHEAT)
                .requires(Items.SUGAR)

                .unlockedBy("has_egg", hasItems(Items.EGG))
                .save(consumer, ResourceLocation.fromNamespaceAndPath(BaldejDelights.MODID, "crafting/raw_pancakes"));
    }
    public static void shapedRecipes(RecipeOutput consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.FOOD, ModItems.FOUR_MEAT_PIE)
                .pattern("#b#")
                .pattern("cmp")
                .pattern("#k#")

                .define('#', Items.WHEAT)
                .define('b', CommonTags.Items.FOODS_COOKED_BEEF)
                .define('c', Ingredient.of(CommonTags.Items.FOODS_COOKED_CHICKEN))
                .define('m', Ingredient.of(CommonTags.Items.FOODS_COOKED_MUTTON))
                .define('p', Ingredient.of(CommonTags.Items.FOODS_COOKED_PORK))
                .define('k', vectorwing.farmersdelight.common.registry.ModItems.PIE_CRUST.get())

                .unlockedBy("has_wheat", InventoryChangeTrigger.TriggerInstance.hasItems(Items.WHEAT))
                .save(consumer);
    }
}