package net.ei3.baldejdelights.data.recipes;

import net.ei3.baldejdelights.BaldejDelights;
import net.ei3.baldejdelights.common.registry.ModItems;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import static vectorwing.farmersdelight.data.recipe.CookingRecipes.MEDIUM_EXP;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.LARGE_EXP;

import static vectorwing.farmersdelight.data.recipe.CookingRecipes.NORMAL_COOKING;
import static vectorwing.farmersdelight.data.recipe.CookingRecipes.SLOW_COOKING;
public class CookingRecipes {
    public static void register(RecipeOutput consumer){
        cookingMeals(consumer);
    }

    private static void cookingMeals(RecipeOutput consumer) {
        // Onion Frenzy / Луковый Угар
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.ONION_FRENZY.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(CommonTags.Items.CROPS_ONION)
                .addIngredient(Tags.Items.CROPS_POTATO)
                .addIngredient(CommonTags.Items.FOODS_PASTA)
                .addIngredient(CommonTags.Items.FOODS_RAW_PORK)
                .unlockedByItems("has_onion", vectorwing.farmersdelight.common.registry.ModItems.ONION.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)

                .save(consumer, ResourceLocation.fromNamespaceAndPath(BaldejDelights.MODID, "cooking/onion_frenzy"));

        // Apples In Chicken Broth / Яблоки в курином бульоне
        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.APPLES_IN_CHICKEN_BROTH.get(), 1, NORMAL_COOKING, MEDIUM_EXP, Items.BOWL)
                .addIngredient(Items.APPLE)
                .addIngredient(Items.APPLE)
                .addIngredient(CommonTags.Items.FOODS_RAW_CHICKEN)
                .unlockedByItems("has_chicken", vectorwing.farmersdelight.common.registry.ModItems.CHICKEN_CUTS.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)

                .save(consumer, ResourceLocation.fromNamespaceAndPath(BaldejDelights.MODID, "cooking/apples_in_chicken_broth"));

        CookingPotRecipeBuilder.cookingPotRecipe(ModItems.FRIED_NAILS.get(), 1, SLOW_COOKING, LARGE_EXP, Items.BOWL)
                .addIngredient(Items.IRON_NUGGET)
                .addIngredient(Items.IRON_INGOT)
                .addIngredient(Items.IRON_NUGGET)

                .unlockedByItems("has_iron", Items.IRON_INGOT)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)

                .save(consumer, ResourceLocation.fromNamespaceAndPath(BaldejDelights.MODID, "cooking/fried_nails"));
    }

}
