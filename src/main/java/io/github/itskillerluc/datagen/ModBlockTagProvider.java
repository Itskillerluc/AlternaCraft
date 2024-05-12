package io.github.itskillerluc.datagen;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.init.BlockRegistry;
import io.github.itskillerluc.init.Tags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AlternaCraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(Tags.NEEDS_AIO_TOOL)
                .addTag(Tags.NEEDS_DARK_CRYSTAL_TOOL);
        tag(Tags.NEEDS_DARK_CRYSTAL_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(BlockRegistry.CHARRED_BARK.value())
                .add(BlockRegistry.CHARRED_PLANKS.value())
                .add(BlockRegistry.STRIPPED_CHARRED_BARK.value());
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistry.VOLCANIC_ROCK.get())
                .add(BlockRegistry.PAINITE_ORE_SOIL.get())
                .add(BlockRegistry.DEEPSLATE_DARK_CRYSTAL_ORE.value())
                .add(BlockRegistry.DARK_CRYSTAL_ORE.value());
        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(BlockRegistry.VOLCANIC_SOIL.get())
                .add(BlockRegistry.FROZEN_SAND.value());
        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(BlockRegistry.PAINITE_ORE_SOIL.get());
        tag(BlockTags.LOGS_THAT_BURN)
                .add(BlockRegistry.CHARRED_BARK.value())
                .add(BlockRegistry.STRIPPED_CHARRED_BARK.value());
        tag(BlockTags.PLANKS)
                .add(BlockRegistry.CHARRED_PLANKS.value());
        tag(BlockTags.FLOWERS)
                .add(BlockRegistry.DEAD_DANDELION.value())
                .add(BlockRegistry.DEAD_POPPY.value());
        tag(BlockTags.DIRT)
                .add(BlockRegistry.VOLCANIC_SOIL.get());
        tag(BlockTags.SAND)
                .add(BlockRegistry.FROZEN_SAND.value());
    }
}
