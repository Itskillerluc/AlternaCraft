package io.github.itskillerluc.init;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.block.CoolLavaBlock;
import io.github.itskillerluc.block.LogBlock;
import io.github.itskillerluc.block.MiningLight;
import net.minecraft.core.Holder;
import net.minecraft.util.ColorRGBA;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AlternaCraft.MODID);


    public static final Supplier<Block> MINING_LIGHT = BLOCKS.registerBlock("mining_light", MiningLight::new, BlockBehaviour.Properties.of().lightLevel(state -> 15).replaceable().instabreak().noCollission().noOcclusion());
    public static final DeferredBlock<RotatedPillarBlock> CHARRED_BARK = BLOCKS.registerBlock("charred_bark", props -> new LogBlock(props, BlockRegistry.STRIPPED_CHARRED_BARK), BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(block ->  MapColor.STONE));
    public static final Holder<Block> CHARRED_PLANKS = BLOCKS.registerSimpleBlock("charred_planks", BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).mapColor(MapColor.COLOR_GRAY));
    public static final DeferredBlock<LiquidBlock> COOL_LAVA = BLOCKS.registerBlock("cool_lava", CoolLavaBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.LAVA).lightLevel(state -> 12));

    public static final DeferredBlock<Block> DEAD_DANDELION = BLOCKS.registerBlock("dead_dandelion",props -> new FlowerBlock(() ->
            MobEffects.WEAKNESS, 7, props), BlockBehaviour.Properties.ofFullCopy(Blocks.DANDELION));

    public static final DeferredBlock<Block> DEAD_GRASS = BLOCKS.registerBlock("dead_grass",
            TallGrassBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.SHORT_GRASS));

    public static final DeferredBlock<Block> DEAD_POPPY = BLOCKS.registerBlock("dead_poppy",props -> new FlowerBlock(() ->
            MobEffects.WITHER, 4, props), BlockBehaviour.Properties.ofFullCopy(Blocks.POPPY));

    public static final DeferredBlock<Block> PAINITE_ORE_SOIL = BLOCKS.registerSimpleBlock("painite_ore_soil", BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE));
    public static final DeferredBlock<RotatedPillarBlock> STRIPPED_CHARRED_BARK = BLOCKS.registerBlock("stripped_charred_bark", RotatedPillarBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.STRIPPED_OAK_LOG).mapColor(block ->  MapColor.STONE));

    public static final DeferredBlock<Block> VOLCANIC_ROCK = BLOCKS.registerSimpleBlock("volcanic_rock", BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final DeferredBlock<Block> VOLCANIC_SOIL = BLOCKS.registerSimpleBlock("volcanic_soil", BlockBehaviour.Properties.ofFullCopy(Blocks.DIRT));
    public static final Holder<Block> FROZEN_SAND = BLOCKS.registerBlock("frozen_sand", props -> new ColoredFallingBlock(new ColorRGBA(0x6AB9FFFF), props), BlockBehaviour.Properties.ofFullCopy(Blocks.SAND).mapColor(MapColor.COLOR_LIGHT_BLUE));
    public static final DeferredBlock<Block> FROZEN_CACTUS = BLOCKS.registerBlock("frozen_cactus", CactusBlock::new, BlockBehaviour.Properties.ofFullCopy(Blocks.CACTUS).mapColor(MapColor.COLOR_LIGHT_BLUE));
    public static final Holder<Block> DEEPSLATE_DARK_CRYSTAL_ORE = BLOCKS.registerSimpleBlock("deepslate_dark_crystal_ore", BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_DIAMOND_ORE));
    public static final Holder<Block> DARK_CRYSTAL_ORE = BLOCKS.registerSimpleBlock("dark_crystal_ore", BlockBehaviour.Properties.ofFullCopy(Blocks.DIAMOND_ORE));
}
