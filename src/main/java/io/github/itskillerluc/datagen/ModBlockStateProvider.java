package io.github.itskillerluc.datagen;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.init.BlockRegistry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.BlockModelBuilder;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.List;
import java.util.function.Supplier;

public class ModBlockStateProvider extends BlockStateProvider {
    private static final List<Supplier<? extends Block>> EXCLUDED = List.of(
            BlockRegistry.MINING_LIGHT,
            BlockRegistry.CHARRED_BARK,
            BlockRegistry.STRIPPED_CHARRED_BARK,
            BlockRegistry.DEAD_DANDELION,
            BlockRegistry.DEAD_GRASS,
            BlockRegistry.DEAD_POPPY,
            BlockRegistry.COOL_LAVA,
            BlockRegistry.FROZEN_CACTUS
    );

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AlternaCraft.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for (DeferredHolder<Block, ? extends Block> entry : BlockRegistry.BLOCKS.getEntries()) {
            if (EXCLUDED.contains(entry)) continue;
            simpleBlockWithItem(entry.get(), cubeAll(entry.get()));
        }
        BlockModelBuilder miningLight = models().withExistingParent("mining_light","minecraft:block/air");
        simpleBlock(BlockRegistry.MINING_LIGHT.get(), miningLight);
        logBlock(BlockRegistry.CHARRED_BARK.value());
        simpleBlockItem(BlockRegistry.CHARRED_BARK.value(), itemModels().getExistingFile(new ResourceLocation(AlternaCraft.MODID, "block/charred_bark")));
        logBlock(BlockRegistry.STRIPPED_CHARRED_BARK.value());
        simpleBlockItem(BlockRegistry.STRIPPED_CHARRED_BARK.value(), itemModels().getExistingFile(new ResourceLocation(AlternaCraft.MODID, "block/stripped_charred_bark")));

        simpleBlock(BlockRegistry.DEAD_DANDELION.get(), models().cross("dead_dandelion", new ResourceLocation(AlternaCraft.MODID, "item/dead_dandelion")).renderType("minecraft:cutout"));
        itemModels().basicItem(BlockRegistry.DEAD_DANDELION.getId());
        simpleBlock(BlockRegistry.DEAD_GRASS.get(), models().cross("dead_grass", new ResourceLocation(AlternaCraft.MODID, "item/dead_grass")).renderType("minecraft:cutout"));
        itemModels().basicItem(BlockRegistry.DEAD_GRASS.getId());
        simpleBlock(BlockRegistry.DEAD_POPPY.get(), models().cross("dead_poppy", new ResourceLocation(AlternaCraft.MODID, "item/dead_poppy")).renderType("minecraft:cutout"));
        itemModels().basicItem(BlockRegistry.DEAD_POPPY.getId());

        BlockModelBuilder frozenCactus = models().withExistingParent("frozen_cactus", "minecraft:block/cactus")
                .texture("particle", new ResourceLocation(AlternaCraft.MODID, "block/frozen_cactus_side"))
                .texture("bottom", new ResourceLocation(AlternaCraft.MODID, "block/frozen_cactus_bottom"))
                .texture("side", new ResourceLocation(AlternaCraft.MODID, "block/frozen_cactus_side"))
                .texture("top", new ResourceLocation(AlternaCraft.MODID, "block/frozen_cactus_top"));
        simpleBlockWithItem(BlockRegistry.FROZEN_CACTUS.get(), frozenCactus);
    }
}