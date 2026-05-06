package net.ei3.baldejdelights.data.recipe;

import net.ei3.baldejdelights.BaldejDelights;
import net.ei3.baldejdelights.common.registry.ModItems;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import vectorwing.farmersdelight.common.tag.CommonTags;

import static net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance.hasItems;

public class BasicRecipes {
    public static void register(RecipeOutput consumer) {
        shapelessRecipes(consumer);
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
}}