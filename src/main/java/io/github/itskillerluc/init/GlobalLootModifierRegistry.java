package io.github.itskillerluc.init;

import com.mojang.serialization.Codec;
import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.loot.SmeltingLootModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

@SuppressWarnings("unused")
public class GlobalLootModifierRegistry {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> MODIFIERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS.key(), AlternaCraft.MODID);

    public static final Supplier<Codec<SmeltingLootModifier>> SMELTING = MODIFIERS.register("smelting",
            SmeltingLootModifier.CODEC);
}
