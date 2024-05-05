package io.github.itskillerluc.item;

import io.github.itskillerluc.AlternaCraft;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DarkCrystalShovel extends ShovelItem {
    public DarkCrystalShovel(Tier pTier, float pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean mineBlock(ItemStack pStack, Level pLevel, BlockState pState, BlockPos pPos, LivingEntity pEntityLiving) {
        darkCrystalMine(pLevel, pPos, pEntityLiving);
        return super.mineBlock(pStack, pLevel, pState, pPos, pEntityLiving);
    }

    public static void darkCrystalMine(Level pLevel, BlockPos pPos, LivingEntity pEntityLiving) {
        for (int x = -1; x < 2; x++) {
            for (int z = -1; z < 2; z++) {
                var vec3 = Vec3.directionFromRotation(pEntityLiving.getRotationVector());
                var direction = Direction.getNearestStable(((float) vec3.x), (float) vec3.y, (float) vec3.z);
                if (direction.getAxis().isHorizontal()) {
                    pLevel.destroyBlock(pPos.relative(direction.getClockWise(), x).relative(Direction.UP, z), true, pEntityLiving);
                } else {
                    pLevel.destroyBlock(pPos.relative(direction.getClockWise(), x).relative(direction, z), true, pEntityLiving);
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("description." + AlternaCraft.MODID + "." + "dark_crystal_shovel").withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
