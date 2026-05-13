package net.ei3.baldejdelights.datagen;

import net.ei3.baldejdelights.BaldejDelights;
import net.ei3.baldejdelights.common.registry.ModAdvancements;
import net.ei3.baldejdelights.data.recipe.BasicRecipes;
import net.ei3.baldejdelights.data.recipe.CookingRecipes;
import net.ei3.baldejdelights.data.recipe.CuttingRecipes;
import net.ei3.baldejdelights.data.recipe.SmeltingRecipes;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = BaldejDelights.MODID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(
                event.includeServer(),
                new ModAdvancements(packOutput, lookupProvider, existingFileHelper)
        );
        generator.addProvider(event.includeServer(), new RecipeProvider(packOutput, lookupProvider) {
            @Override
            protected void buildRecipes(@NotNull RecipeOutput consumer) {
                CookingRecipes.register(consumer);
                BasicRecipes.register(consumer);
                SmeltingRecipes.register(consumer);
                CuttingRecipes.register(consumer);
            }
        });
    }
}
