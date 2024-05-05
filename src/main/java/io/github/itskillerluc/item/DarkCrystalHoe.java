package io.github.itskillerluc.item;

import com.mojang.datafixers.util.Pair;
import io.github.itskillerluc.AlternaCraft;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ToolActions;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class DarkCrystalHoe extends HoeItem {
    public DarkCrystalHoe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        darkCrystalUse(pContext);
        return super.useOn(pContext);
    }

    public static void darkCrystalUse(UseOnContext pContext) {
        if (pContext.getPlayer() == null) return;
        for (int x = -1; x < 2; x++) {
            for (int z = -1; z < 2; z++) {
                var vec3 = Vec3.directionFromRotation(pContext.getPlayer().getRotationVector());
                var direction = Direction.getNearestStable(((float) vec3.x), (float) vec3.y, (float) vec3.z);
                if (direction.getAxis().isHorizontal()) {
                    var blockPos = pContext.getClickedPos().relative(direction.getClockWise(), x).relative(Direction.UP, z);
                    if (useHoe(pContext, blockPos)) return;
                } else {
                    var blockPos = pContext.getClickedPos().relative(pContext.getHorizontalDirection(), x).relative(direction, z);
                    if (useHoe(pContext, blockPos)) return;
                }
            }
        }
    }

    private static boolean useHoe(UseOnContext pContext, BlockPos blockPos) {
        BlockState toolModifiedState = pContext.getLevel().getBlockState(blockPos).getToolModifiedState(pContext, ToolActions.HOE_TILL, false);
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, changeIntoState(toolModifiedState));
        if (pair == null) {
            return true;
        } else {
            Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();
            if (predicate.test(pContext)) {
                if (!pContext.getLevel().isClientSide) {
                    consumer.accept(pContext);
                }
            }
        }
        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("description." + AlternaCraft.MODID + "." + "dark_crystal_hoe").withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
