package net.ei3.baldejdelights.common.registry;


import net.minecraft.advancements.*;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.advancements.AdvancementSubProvider;

import net.minecraft.network.chat.Component;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import net.neoforged.neoforge.common.data.AdvancementProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;


public class ModAdvancements extends AdvancementProvider {
    public ModAdvancements(PackOutput output,
                           CompletableFuture<HolderLookup.Provider> lookupProvider, ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, existingFileHelper, List.of(new ModAdvancementGenerator()));
    }

    private static final class ModAdvancementGenerator implements AdvancementProvider.AdvancementGenerator {
        @Override
        public void generate(HolderLookup.Provider registries, Consumer<AdvancementHolder> saver, ExistingFileHelper existingFileHelper) {
            Advancement.Builder builder = Advancement.Builder.advancement();

            builder.parent(AdvancementSubProvider.createPlaceholder("minecraft:story/root"));

            builder.display(

                    new ItemStack(ModItems.OVERCOOKED_PANCAKES.get()),

                    Component.translatable("advancements.baldejdelights.disappointment_advancement.title"),
                    Component.translatable("advancements.baldejdelights.disappointment_advancement.description"),

                    null,

                    AdvancementType.GOAL,

                    true,

                    true,

                    false
            );

            builder.rewards(
                    AdvancementRewards.Builder.experience(1)


            );

            builder.addCriterion("pickup_overcooked_pancakes", InventoryChangeTrigger.TriggerInstance.hasItems(ModItems.OVERCOOKED_PANCAKES));

            builder.requirements(AdvancementRequirements.allOf(List.of("pickup_overcooked_pancakes")));

            builder.save(saver, ResourceLocation.fromNamespaceAndPath("baldejdelights", "disappointment_advancements"), existingFileHelper);

        }
    }
}
