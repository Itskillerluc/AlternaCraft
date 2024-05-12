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
            BlockRegistry.FROZEN_CACTUS,
            BlockRegistry.ELECTREE_LOG,
            BlockRegistry.STRIPPED_ELECTREE_LOG,
            BlockRegistry.BLUE_BULB,
            BlockRegistry.ELECTREE_LEAVES,
            BlockRegistry.ORANGE_BULB,
            BlockRegistry.GREEN_ROSE_BULB
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
        simpleBlockWithItem(BlockRegistry.ELECTREE_LEAVES.get(), models().cubeAll("electree_leaves", new ResourceLocation(AlternaCraft.MODID, "block/electree_leaves")).renderType("minecraft:cutout"));

        BlockModelBuilder miningLight = models().withExistingParent("mining_light","minecraft:block/air");
        simpleBlock(BlockRegistry.MINING_LIGHT.get(), miningLight);
        logBlock(BlockRegistry.CHARRED_BARK.value());
        simpleBlockItem(BlockRegistry.CHARRED_BARK.value(), itemModels().getExistingFile(new ResourceLocation(AlternaCraft.MODID, "block/charred_bark")));
        logBlock(BlockRegistry.STRIPPED_CHARRED_BARK.value());
        simpleBlockItem(BlockRegistry.STRIPPED_CHARRED_BARK.value(), itemModels().getExistingFile(new ResourceLocation(AlternaCraft.MODID, "block/stripped_charred_bark")));
        logBlock(BlockRegistry.ELECTREE_LOG.value());
        simpleBlockItem(BlockRegistry.ELECTREE_LOG.value(), itemModels().getExistingFile(new ResourceLocation(AlternaCraft.MODID, "block/electree_log")));
        logBlock(BlockRegistry.STRIPPED_ELECTREE_LOG.value());
        simpleBlockItem(BlockRegistry.STRIPPED_ELECTREE_LOG.value(), itemModels().getExistingFile(new ResourceLocation(AlternaCraft.MODID, "block/stripped_electree_log")));

        simpleBlock(BlockRegistry.DEAD_DANDELION.get(), models().cross("dead_dandelion", new ResourceLocation(AlternaCraft.MODID, "item/dead_dandelion")).renderType("minecraft:cutout"));
        itemModels().basicItem(BlockRegistry.DEAD_DANDELION.getId());
        simpleBlock(BlockRegistry.DEAD_GRASS.get(), models().cross("dead_grass", new ResourceLocation(AlternaCraft.MODID, "item/dead_grass")).renderType("minecraft:cutout"));
        itemModels().basicItem(BlockRegistry.DEAD_GRASS.getId());
        simpleBlock(BlockRegistry.DEAD_POPPY.get(), models().cross("dead_poppy", new ResourceLocation(AlternaCraft.MODID, "item/dead_poppy")).renderType("minecraft:cutout"));
        itemModels().basicItem(BlockRegistry.DEAD_POPPY.getId());
        simpleBlock(BlockRegistry.BLUE_BULB.get(), models().cross("blue_bulb", new ResourceLocation(AlternaCraft.MODID, "item/blue_bulb")).renderType("minecraft:cutout"));
        itemModels().basicItem(BlockRegistry.BLUE_BULB.getId());
        simpleBlock(BlockRegistry.GREEN_ROSE_BULB.get(), models().cross("green_rose_bulb", new ResourceLocation(AlternaCraft.MODID, "item/green_rose_bulb")).renderType("minecraft:cutout"));
        itemModels().basicItem(BlockRegistry.GREEN_ROSE_BULB.getId());
        simpleBlock(BlockRegistry.ORANGE_BULB.get(), models().cross("orange_bulb", new ResourceLocation(AlternaCraft.MODID, "item/orange_bulb")).renderType("minecraft:cutout"));
        itemModels().basicItem(BlockRegistry.ORANGE_BULB.getId());


        BlockModelBuilder frozenCactus = models().withExistingParent("frozen_cactus", "minecraft:block/cactus")
                .texture("particle", new ResourceLocation(AlternaCraft.MODID, "block/frozen_cactus_side"))
                .texture("bottom", new ResourceLocation(AlternaCraft.MODID, "block/frozen_cactus_bottom"))
                .texture("side", new ResourceLocation(AlternaCraft.MODID, "block/frozen_cactus_side"))
                .texture("top", new ResourceLocation(AlternaCraft.MODID, "block/frozen_cactus_top"))
                .renderType("minecraft:cutout");
        simpleBlockWithItem(BlockRegistry.FROZEN_CACTUS.get(), frozenCactus);
    }
}