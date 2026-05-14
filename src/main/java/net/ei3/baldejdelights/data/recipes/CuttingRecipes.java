package net.ei3.baldejdelights.data.recipes;

import net.ei3.baldejdelights.BaldejDelights;
import net.ei3.baldejdelights.common.registry.ModItems;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.ItemAbility;
import net.neoforged.neoforge.common.crafting.CompoundIngredient;
import vectorwing.farmersdelight.common.crafting.ingredient.ItemAbilityIngredient;
import vectorwing.farmersdelight.common.item.KnifeItem;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CuttingBoardRecipeBuilder;

public class CuttingRecipes {
    public static Ingredient KNIVES = matchesTool(KnifeItem.KNIFE_DIG, CommonTags.Items.TOOLS_KNIFE);

    public static void register(RecipeOutput output) {
        cuttingFoods(output);
    }

    public static void cuttingFoods(RecipeOutput output) {
        CuttingBoardRecipeBuilder.cuttingRecipe(Ingredient.of(ModItems.FOUR_MEAT_PIE), KNIVES, ModItems.FOUR_MEAT_PIE_SLICE.get(), 4)
        .saveToFD(output);
    }

    public static Ingredient matchesTool(ItemAbility toolAction, TagKey<Item> fallbackTag) {
        return CompoundIngredient.of(new ItemAbilityIngredient(toolAction).toVanilla(), Ingredient.of(fallbackTag));
    }

    private static ResourceLocation salvagingRecipe(String name) {
        return ResourceLocation.fromNamespaceAndPath(BaldejDelights.MODID, "salvaging/" + name);
    }
}
