package io.github.itskillerluc.init;

import io.github.itskillerluc.AlternaCraft;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.StreamCodec;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class DataComponentRegistry {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, AlternaCraft.MODID);

    public static final Supplier<DataComponentType<Double>> DISTANCE = DATA_COMPONENTS.register("distance",
            () -> new DataComponentType.Builder<Double>().networkSynchronized(StreamCodec.unit(0D)).build());

    public static final Supplier<DataComponentType<Long>> GAMETIME = DATA_COMPONENTS.register("gametime",
            () -> new DataComponentType.Builder<Long>().networkSynchronized(StreamCodec.unit(0L)).build());
}
