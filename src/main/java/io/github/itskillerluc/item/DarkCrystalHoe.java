package io.github.itskillerluc.item;

import com.mojang.datafixers.util.Pair;
import io.github.itskillerluc.AlternaCraft;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
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
        return InteractionResult.SUCCESS;
        //return super.useOn(pContext);
    }

    public static void darkCrystalUse(UseOnContext pContext) {
        if (pContext.getPlayer() == null) return;
        for (int x = -1; x < 2; x++) {
            for (int z = -1; z < 2; z++) {
                var blockPos = pContext.getClickedPos().north(x).east(z);
                useHoe(new UseOnContext(pContext.getPlayer(), pContext.getHand(), new BlockHitResult(pContext.getClickLocation(), pContext.getClickedFace(), blockPos, pContext.isInside())));
            }
        }
    }

    public static InteractionResult useHoe(UseOnContext pContext) {
        Level level = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        BlockState toolModifiedState = level.getBlockState(blockpos).getToolModifiedState(pContext, net.neoforged.neoforge.common.ToolActions.HOE_TILL, false);
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, changeIntoState(toolModifiedState));
        if (pair == null) {
            return InteractionResult.PASS;
        } else {
            Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();
            if (predicate.test(pContext)) {
                Player player = pContext.getPlayer();
                level.playSound(player, blockpos, SoundEvents.HOE_TILL, SoundSource.BLOCKS, 1.0F, 1.0F);
                if (!level.isClientSide) {
                    consumer.accept(pContext);
                    level.updateNeighborsAt(pContext.getClickedPos(), toolModifiedState.getBlock());
                    if (player != null) {
                        pContext.getItemInHand().hurtAndBreak(1, player, p_150845_ -> p_150845_.broadcastBreakEvent(pContext.getHand()));
                    }
                }

                return InteractionResult.sidedSuccess(level.isClientSide);
            } else {
                return InteractionResult.PASS;
            }
        }
    }

    private static void useHoe(UseOnContext pContext, BlockPos blockPos) {
        BlockState toolModifiedState = pContext.getLevel().getBlockState(blockPos).getToolModifiedState(pContext, ToolActions.HOE_TILL, false);
        Pair<Predicate<UseOnContext>, Consumer<UseOnContext>> pair = toolModifiedState == null ? null : Pair.of(ctx -> true, changeIntoState(toolModifiedState));
        if (pair != null) {
            Predicate<UseOnContext> predicate = pair.getFirst();
            Consumer<UseOnContext> consumer = pair.getSecond();
            if (predicate.test(pContext)) {
                if (!pContext.getLevel().isClientSide) {
                    pContext.getLevel().setBlock(blockPos, toolModifiedState, 11);
                    pContext.getLevel().gameEvent(GameEvent.BLOCK_CHANGE, blockPos, GameEvent.Context.of(pContext.getPlayer(), toolModifiedState));
                }
            }
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("description." + AlternaCraft.MODID + "." + "dark_crystal_hoe").withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
