package io.github.itskillerluc.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class MiningLight extends Block {
    public MiningLight(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        double d0 = pPos.getX();
        double d1 = pPos.getY();
        double d2 = pPos.getZ();

        pLevel.addParticle(ParticleTypes.GLOW, d0 + pRandom.nextDouble(), d1 + pRandom.nextDouble(), d2 + pRandom.nextDouble(), 0.0, 0.0, 0.0);
    }
}
