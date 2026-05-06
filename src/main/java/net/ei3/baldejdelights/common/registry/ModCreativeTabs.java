package net.ei3.baldejdelights.common.registry;

import net.ei3.baldejdelights.BaldejDelights;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, BaldejDelights.MODID);

    public static final Supplier<CreativeModeTab>  BALDEJDELIGHTS_ITEMS_TAB = CREATIVE_MODE_TAB.register("baldejdelights_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ONION_FRENZY.get()))
                    .title(Component.translatable("creativetab.baldejdelights.baldej_delights"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.ONION_FRENZY);
                        output.accept(ModItems.APPLES_IN_CHICKEN_BROTH);
                        output.accept(ModItems.EGG_BARBECUE);
                        output.accept(ModItems.BOBS);
                        output.accept(ModItems.FRIED_NAILS);
                        output.accept(ModItems.OVERCOOKED_PANCAKES);

                        output.accept(ModItems.RAW_PANCAKES);
                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
