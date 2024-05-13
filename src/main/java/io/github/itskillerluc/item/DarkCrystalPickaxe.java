package io.github.itskillerluc.item;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.init.SoundEventRegistry;
import io.github.itskillerluc.init.ToolActions;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.ToolAction;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DarkCrystalPickaxe extends PickaxeItem {
    public DarkCrystalPickaxe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean canPerformAction(@NotNull ItemStack stack, @NotNull ToolAction toolAction) {
        return super.canPerformAction(stack, toolAction) || toolAction.equals(ToolActions.SONAR);
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level pLevel, @NotNull Player pPlayer, @NotNull InteractionHand pUsedHand) {
        darkCrystalUse(pLevel, pPlayer, pUsedHand);
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    public static void darkCrystalUse(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide) return;
        int range = 15;
        ItemStack stack = pPlayer.getItemInHand(pUsedHand);
        if (stack.getTag() == null || !stack.getTag().contains("distance")) {
            BlockPos closestBlock = null;

            for (int x = -range; x <= range; x++) {
                for (int y = -range; y <= range; y++) {
                    for (int z = -range; z <= range; z++) {
                        var offsetPos = pPlayer.getOnPos().offset(x, y, z);
                        if (pLevel.getBlockState(offsetPos).getBlock().asItem() == pPlayer.getItemInHand(pUsedHand == InteractionHand.MAIN_HAND ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND).getItem()) {
                            if (closestBlock == null || offsetPos.distSqr(pPlayer.getOnPos()) < closestBlock.distSqr(pPlayer.getOnPos())) {
                                closestBlock = offsetPos;
                            }
                        }
                    }
                }
            }
            if (closestBlock != null) {
                stack.getOrCreateTag().putLong("gameTime", pLevel.getGameTime());
                stack.getOrCreateTag().putDouble("distance", Math.sqrt(closestBlock.distSqr(pPlayer.getOnPos())));
            }
            pPlayer.playSound(SoundEventRegistry.SONAR_PING.get());
        }
    }

    @Override
    public void inventoryTick(@NotNull ItemStack pStack, @NotNull Level pLevel, @NotNull Entity pEntity, int pSlotId, boolean pIsSelected) {
        darkCrystalTick(pStack, pLevel, pEntity);
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    @SuppressWarnings("DataFlowIssue")
    public void darkCrystalTick(ItemStack pStack, Level pLevel, Entity pEntity) {
        if (pStack.hasTag() && pLevel.isClientSide()) {
            if (pStack.getTag().contains("gameTime") && pStack.getTag().contains("distance")) {
                if (pLevel.getGameTime() - pStack.getTag().getLong("gameTime") > 20L * pStack.getTag().getInt("distance")) {
                    pStack.removeTagKey("gameTime");
                    pStack.removeTagKey("distance");
                    if (pLevel.isClientSide()) {
                        pEntity.playSound(SoundEventRegistry.SONAR_PONG.get());
                    }
                }
            }
        }
    }

    @Override
    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, @NotNull TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("description." + AlternaCraft.MODID + "." + "dark_crystal_pickaxe").withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
