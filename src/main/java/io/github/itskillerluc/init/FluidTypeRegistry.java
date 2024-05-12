package io.github.itskillerluc.init;

import io.github.itskillerluc.AlternaCraft;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PointedDripstoneBlock;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class FluidTypeRegistry {
    public static final DeferredRegister<FluidType> FLUID_TYPES = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, AlternaCraft.MODID);

    public static final Supplier<FluidType> COOL_LAVA = FLUID_TYPES.register("cool_lava",
            () -> new FluidType(FluidType.Properties.create()
                    .descriptionId("block.alternacraft.cool_lava")
                    .canSwim(false)
                    .canDrown(false)
                    .pathType(BlockPathTypes.LAVA)
                    .adjacentPathType(null)
                    .sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL_LAVA)
                    .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY_LAVA)
                    .lightLevel(12)
                    .density(3000)
                    .viscosity(6000)
                    .temperature(500)) {

                public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
                    consumer.accept(new IClientFluidTypeExtensions() {
                        private static final ResourceLocation COOL_LAVA_STILL = new ResourceLocation(AlternaCraft.MODID, "block/cool_lava_still");
                        private static final ResourceLocation COOL_LAVA_FLOWING = new ResourceLocation(AlternaCraft.MODID, "block/cool_lava_flowing");

                        public ResourceLocation getStillTexture() {
                            return COOL_LAVA_STILL;
                        }

                        public ResourceLocation getFlowingTexture() {
                            return COOL_LAVA_FLOWING;
                        }
                    });
                }
            });
    }
