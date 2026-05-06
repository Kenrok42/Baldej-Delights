package net.ei3.baldejdelights.common.registry;

import net.ei3.baldejdelights.BaldejDelights;
import net.ei3.baldejdelights.data.effects.disappointment;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(BuiltInRegistries.MOB_EFFECT, BaldejDelights.MODID);

    public static final Holder<MobEffect> DISAPPOINTMENT = MOB_EFFECTS.register("disappointment", () -> new disappointment());

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
