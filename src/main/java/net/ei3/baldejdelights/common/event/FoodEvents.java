package net.ei3.baldejdelights.common.event;

import net.ei3.baldejdelights.common.registry.ModEffects;
import net.ei3.baldejdelights.common.registry.ModFoodProperties;
import net.ei3.baldejdelights.common.registry.ModItems;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ServerChatEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = "baldejdelights")
public class FoodEvents {


    @SubscribeEvent
    public static void onFoodEaten(LivingEntityUseItemEvent.Finish event) {
        ItemStack item = event.getItem();

        if (event.getEntity() instanceof  Player player) {

            //Freezing after eating BOBS

            if (item.is(ModItems.BOBS.get())) {
                player.setTicksFrozen(200);
            }

            //Applying damage, creating particles after eating Fried Nails

            if (item.is(ModItems.FRIED_NAILS.get())) {
                player.hurt(player.level().damageSources().generic(), 2.0f);

                System.out.println("DEBUG: Player ate food");

                ParticleOptions particle = ParticleTypes.CRIT;
                if (!player.level().isClientSide) {

                    double x = player.getX();
                    double y = player.getY();
                    double z = player.getZ();

                    ServerPlayer serverPlayer = (ServerPlayer) player;
                    serverPlayer.serverLevel().sendParticles(
                            particle,
                            x, y, z,
                            10,
                            1, 1, 1,
                            0.1f
                    );

                    serverPlayer.serverLevel().playSound(
                            null,
                            player,
                            SoundEvents.ANVIL_LAND,
                            SoundSource.PLAYERS,
                            0.6f,
                            1.0f
                    );

                    System.out.println("DEBUG: Sounds And Particles!");
                }
            }
            //This script connected to disappointment effect, it makes every type of food less nutritious

            if (player.hasEffect(ModEffects.DISAPPOINTMENT)) {


                var foodProps = item.getFoodProperties(player);


                if (foodProps != null) {
                    int nutrition = foodProps.nutrition();
                    float saturation = foodProps.saturation();

                    float realSaturationRestored = (float)nutrition * saturation;

                    int foodToRemove = nutrition / 4;
                    float satToRemove = realSaturationRestored / 2.0F;

                    if (foodToRemove > 0) {
                        player.getFoodData().eat(-foodToRemove, -satToRemove);
                    }
                }
            }
        }



    }


}