package io.github.itskillerluc.datagen;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.init.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.function.Supplier;

public class ModBlockStateProvider extends BlockStateProvider {
    private static final List<Supplier<? extends Block>> EXCLUDED = List.of(
            BlockRegistry.MINING_LIGHT
    );

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AlternaCraft.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (DeferredHolder<Block, ? extends Block> entry : BlockRegistry.BLOCKS.getEntries()) {
            if (EXCLUDED.contains(entry)) continue;
            simpleBlock(entry.get());
        }
        BlockModelBuilder miningLight = models().withExistingParent("mining_light","minecraft:block/air");
        simpleBlock(BlockRegistry.MINING_LIGHT.get(), miningLight);
    }
}