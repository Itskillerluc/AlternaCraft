package io.github.itskillerluc.init;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.block.MiningLight;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegistry {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AlternaCraft.MODID);


    public static final Supplier<Block> MINING_LIGHT = BLOCKS.registerBlock("mining_light", MiningLight::new, BlockBehaviour.Properties.of().lightLevel(state -> 15).replaceable().instabreak().noCollission().noOcclusion());
}
