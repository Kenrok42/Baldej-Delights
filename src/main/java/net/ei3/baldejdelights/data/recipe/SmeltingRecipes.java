package net.ei3.baldejdelights.data.recipe;

import net.ei3.baldejdelights.BaldejDelights;
import net.ei3.baldejdelights.common.registry.ModItems;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.level.ItemLike;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public class SmeltingRecipes {
    public static void register(RecipeOutput consumer) {
        FoodSmelting(consumer,
                Ingredient.of(ModItems.RAW_PANCAKES.get()),
                ModItems.OVERCOOKED_PANCAKES.get(),
                0.35F, 200,
                "overcooked_pancakes", ModItems.RAW_PANCAKES.get());
    }

    private static void FoodSmelting(
            RecipeOutput consumer,
            Ingredient input,
            ItemLike result,
            float xp,
            int cookTime,
            String name,
            ItemLike unlockItem
    ) {
        SimpleCookingRecipeBuilder.smelting(input, RecipeCategory.FOOD, result, xp, cookTime)
                .unlockedBy("has_" + name, hasItems(unlockItem))
                .save(consumer,  ResourceLocation.fromNamespaceAndPath(BaldejDelights.MODID, name + "_from_smelting"));

        SimpleCookingRecipeBuilder.smoking(input, RecipeCategory.FOOD, result, xp, cookTime / 2)
                .unlockedBy("has_" + name, hasItems(unlockItem))
                .save(consumer,  ResourceLocation.fromNamespaceAndPath(BaldejDelights.MODID, name + "_from_smoking"));

        SimpleCookingRecipeBuilder.campfireCooking(input, RecipeCategory.FOOD, result, xp, cookTime * 3)
                .unlockedBy("has_" + name, hasItems(unlockItem))
                .save(consumer,  ResourceLocation.fromNamespaceAndPath(BaldejDelights.MODID, name + "_from_campfire_cooking"));
    }
}
