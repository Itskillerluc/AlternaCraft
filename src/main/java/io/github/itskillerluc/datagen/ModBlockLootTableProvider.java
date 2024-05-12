package io.github.itskillerluc.datagen;

import io.github.itskillerluc.init.BlockRegistry;
import io.github.itskillerluc.init.ItemRegistry;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.Collections;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider() {
        super(Collections.emptySet(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return BlockRegistry.BLOCKS.getEntries().stream()
                .map(holder -> ((Block) holder.get()))::iterator;
    }

    @Override
    protected void generate() {
        add(BlockRegistry.MINING_LIGHT.get(), noDrop());
        dropSelf(BlockRegistry.CHARRED_BARK.get());
        dropSelf(BlockRegistry.CHARRED_PLANKS.value());
        add(BlockRegistry.PAINITE_ORE_SOIL.get(),createOreDrop(BlockRegistry.PAINITE_ORE_SOIL.get(), ItemRegistry.PAINITE_CRYSTAL.get()));
        dropSelf(BlockRegistry.STRIPPED_CHARRED_BARK.get());
        dropSelf(BlockRegistry.VOLCANIC_ROCK.get());
        dropSelf(BlockRegistry.VOLCANIC_SOIL.get());
        add(BlockRegistry.DEAD_GRASS.get(), createGrassDrops(BlockRegistry.DEAD_GRASS.get()));
        dropSelf(BlockRegistry.DEAD_POPPY.get());
        dropSelf(BlockRegistry.DEAD_DANDELION.get());
        dropSelf(BlockRegistry.FROZEN_CACTUS.value());
        dropSelf(BlockRegistry.FROZEN_SAND.value());
        add(BlockRegistry.DEEPSLATE_DARK_CRYSTAL_ORE.value(), createOreDrop(BlockRegistry.DEEPSLATE_DARK_CRYSTAL_ORE.value(), ItemRegistry.DARK_CRYSTAL.get()));
        add(BlockRegistry.DARK_CRYSTAL_ORE.value(), createOreDrop(BlockRegistry.DARK_CRYSTAL_ORE.value(), ItemRegistry.DARK_CRYSTAL.get()));
        dropSelf(BlockRegistry.BLUE_BULB.get());
        add(BlockRegistry.ELECTREE_LEAVES.get(), createLeavesDrops(BlockRegistry.ELECTREE_LEAVES.value(), Blocks.OAK_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
        dropSelf(BlockRegistry.ELECTREE_LOG.value());
        dropSelf(BlockRegistry.ELECTREE_PLANKS.value());
        dropSelf(BlockRegistry.GREEN_ROSE_BULB.get());
        dropSelf(BlockRegistry.ORANGE_BULB.get());
        dropSelf(BlockRegistry.STRIPPED_ELECTREE_LOG.value());
    }
}
