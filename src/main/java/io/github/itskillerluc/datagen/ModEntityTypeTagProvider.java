package io.github.itskillerluc.datagen;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.init.EntityRegistry;
import io.github.itskillerluc.init.ItemRegistry;
import io.github.itskillerluc.init.Tags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.EntityTypeTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModEntityTypeTagProvider extends EntityTypeTagsProvider {
    public ModEntityTypeTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> holderLookup, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, holderLookup, AlternaCraft.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.@NotNull Provider pProvider) {
        tag(Tags.EntityTypes.MINI_DINOS);
        tag(Tags.EntityTypes.SMALL_DINOS);
        tag(Tags.EntityTypes.MEDIUM_DINOS);
        tag(Tags.EntityTypes.LARGE_DINOS)
                .add(EntityRegistry.MAGMATYRANNUS.get());
        tag(Tags.EntityTypes.DINOS)
                .addTag(Tags.EntityTypes.MINI_DINOS)
                .addTag(Tags.EntityTypes.SMALL_DINOS)
                .addTag(Tags.EntityTypes.MEDIUM_DINOS)
                .addTag(Tags.EntityTypes.LARGE_DINOS);
    }
}
