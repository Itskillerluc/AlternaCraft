package io.github.itskillerluc.init;

import io.github.itskillerluc.AlternaCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.common.TierSortingRegistry;

import java.util.List;

public class ToolTiers {
    public static final Tier AIO_TIER = new SimpleTier(6, 4269, 15, 7, 25, Tags.Blocks.NEEDS_AIO_TOOL, () -> Ingredient.of(ItemRegistry.AIO_CRYSTAL.get()));
    public static final Tier COPPERWOOD_TIER = new SimpleTier(5, 2407, 10, 5, 15, Tags.Blocks.NEEDS_DARK_CRYSTAL_TOOL, () -> Ingredient.of(ItemRegistry.COPPERWOOD_CRYSTAL.get()));
    public static final Tier MAGNETIC_TIER = new SimpleTier(5, 2809, 12, 5, 15, Tags.Blocks.NEEDS_DARK_CRYSTAL_TOOL, () -> Ingredient.of(ItemRegistry.MAGNETIC_CRYSTAL.get()));
    public static final Tier PAINITE_TIER = new SimpleTier(5, 3100, 9, 5, 20, Tags.Blocks.NEEDS_DARK_CRYSTAL_TOOL, () -> Ingredient.of(ItemRegistry.PAINITE_CRYSTAL.get()));
    public static final Tier DARK_CRYSTAL_TIER = new SimpleTier(5, 2600, 10, 6, 15, Tags.Blocks.NEEDS_DARK_CRYSTAL_TOOL, () -> Ingredient.of(ItemRegistry.DARK_CRYSTAL.get()));

    static {
        TierSortingRegistry.registerTier(
                COPPERWOOD_TIER,
                new ResourceLocation(AlternaCraft.MODID, "copperwood"),
                List.of(Tiers.NETHERITE),
                List.of()
        );
        TierSortingRegistry.registerTier(
                PAINITE_TIER,
                new ResourceLocation(AlternaCraft.MODID, "painite"),
                List.of(Tiers.NETHERITE),
                List.of()
        );
        TierSortingRegistry.registerTier(
                MAGNETIC_TIER,
                new ResourceLocation(AlternaCraft.MODID, "magnetic"),
                List.of(Tiers.NETHERITE),
                List.of()
        );
        TierSortingRegistry.registerTier(
                DARK_CRYSTAL_TIER,
                new ResourceLocation(AlternaCraft.MODID, "dark_crystal"),
                List.of(Tiers.NETHERITE),
                List.of()
        );
        TierSortingRegistry.registerTier(
                AIO_TIER,
                new ResourceLocation(AlternaCraft.MODID, "aio"),
                List.of(COPPERWOOD_TIER, MAGNETIC_TIER, PAINITE_TIER, DARK_CRYSTAL_TIER),
                List.of()
        );
    }
}
