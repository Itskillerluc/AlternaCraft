package io.github.itskillerluc.datagen;

import io.github.itskillerluc.AlternaCraft;
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
    }
}
