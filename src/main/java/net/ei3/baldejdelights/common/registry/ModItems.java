package net.ei3.baldejdelights.common.registry;

import net.ei3.baldejdelights.BaldejDelights;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    // Dishes

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(BaldejDelights.MODID);

    public static final DeferredItem<Item> ONION_FRENZY = ITEMS.register("onion_frenzy", () -> new Item(new Item.Properties().food(ModFoodProperties.ONION_FRENZY).stacksTo(16)));

    public static final DeferredItem<Item> APPLES_IN_CHICKEN_BROTH = ITEMS.register("apples_in_chicken_broth", () -> new Item(new Item.Properties().food(ModFoodProperties.APPLES_IN_CHICKEN_BROTH).stacksTo(16)));

    public static final DeferredItem<Item> EGG_BARBECUE = ITEMS.register("egg_barbecue", () -> new Item(new Item.Properties().food(ModFoodProperties.EGG_BARBECUE)));

    public static final DeferredItem<Item> BOBS = ITEMS.register("bobs", () -> new Item(new Item.Properties().food(ModFoodProperties.BOBS)));

    public static final DeferredItem<Item> FRIED_NAILS = ITEMS.register("fried_nails", () -> new Item(new Item.Properties().food(ModFoodProperties.FRIED_NAILS).stacksTo(16)));

    public static final DeferredItem<Item> OVERCOOKED_PANCAKES = ITEMS.register("overcooked_pancakes", () -> new Item(new Item.Properties().food(ModFoodProperties.OVERCOOKED_PANCAKES)));

    //Ingredients/blanks

    public static final DeferredItem<Item> RAW_PANCAKES = ITEMS.register("raw_pancakes", () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
