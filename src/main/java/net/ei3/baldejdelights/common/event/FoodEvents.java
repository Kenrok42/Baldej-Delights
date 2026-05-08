package net.ei3.baldejdelights.common.event;

import net.ei3.baldejdelights.common.registry.ModEffects;
import net.ei3.baldejdelights.common.registry.ModFoodProperties;
import net.ei3.baldejdelights.common.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.ServerChatEvent;
import net.neoforged.neoforge.event.entity.living.LivingEntityUseItemEvent;
import net.neoforged.neoforge.event.entity.living.LivingHealEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

import java.util.logging.Level;

@EventBusSubscriber(modid = "baldejdelights")
public class FoodEvents {

    @SubscribeEvent
    public static void onBlockRightClick(PlayerInteractEvent.RightClickBlock event) {

        // Tomato with maltese cross spawn event

        if (!event.getLevel().isClientSide) {
            net.minecraft.world.level.Level level = event.getLevel();
            BlockPos pos = event.getPos();
            BlockState state = level.getBlockState(pos);

            ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(state.getBlock());

            if (blockId.toString().equals("farmersdelight:tomatoes")) {

                int age = state.getValue(BlockStateProperties.AGE_3);
                boolean isMature = age == 3;

                if (isMature) {

                    event.setCancellationResult(InteractionResult.SUCCESS);

                    if (level.random.nextFloat() < 0.01) {
                        level.addFreshEntity(new net.minecraft.world.entity.item.ItemEntity(
                                (net.minecraft.server.level.ServerLevel) level,
                                pos.getX(),
                                pos.getY(),
                                pos.getZ(),
                                new ItemStack(ModItems.TOMATO_WITH_MALTESE_CROSS.get()))
                        );
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onFoodEaten(LivingEntityUseItemEvent.Finish event) {
        ItemStack item = event.getItem();

        if (event.getEntity() instanceof Player player) {

            //Freezing after eating BOBS

            if (item.is(ModItems.BOBS.get())) {
                player.setTicksFrozen(200);
            }

            //Applying damage, creating particles and playing sound after eating Fried Nails

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

                }
            }
            //This script connected to disappointment effect, it makes every type of food less nutritious

            if (player.hasEffect(ModEffects.DISAPPOINTMENT)) {


                var foodProps = item.getFoodProperties(player);


                if (foodProps != null) {
                    int nutrition = foodProps.nutrition();
                    float saturation = foodProps.saturation();

                    float realSaturationRestored = (float) nutrition * saturation;

                    int foodToRemove = nutrition / 4;
                    float satToRemove = realSaturationRestored / 2.0F;

                    if (foodToRemove > 0) {
                        player.getFoodData().eat(-foodToRemove, -satToRemove);
                    }
                }
            }

            if (player.hasEffect(ModEffects.TOMATO_BLESSING)) {
                if (player.getRandom().nextFloat() < 0.5F) {

                    var foodProps = item.getFoodProperties(player);

                    if (foodProps != null) {

                        float saturation = foodProps.saturation();
                        player.getFoodData().setSaturation(player.getFoodData().getSaturationLevel() + (saturation * 2.0F));
                    }


                    try {
                        Item remainderItem = item.getItem().getCraftingRemainingItem();


                        if (remainderItem != null && remainderItem != Items.AIR) {

                            if (!player.getInventory().add(item.copy())) {
                                player.drop(item.copy(), false);
                            }
                            player.setItemInHand(event.getHand(), new ItemStack(remainderItem));
                        } else {

                            player.setItemInHand(event.getHand(), item);
                        }
                    } catch (Exception e) {

                        new Exception("BaldejDelights Error returning food item: " + e.getMessage()).printStackTrace();


                        player.setItemInHand(event.getHand(), item);
                    }
                }
            }
        }
    }
}