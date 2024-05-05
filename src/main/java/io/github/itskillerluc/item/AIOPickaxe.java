package io.github.itskillerluc.item;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.init.BlockRegistry;
import io.github.itskillerluc.init.ToolActions;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AIOPickaxe extends PickaxeItem {
    public AIOPickaxe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return super.canPerformAction(stack, toolAction) || toolAction.equals(ToolActions.PLACE_LIGHT) || toolAction.equals(ToolActions.SONAR);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (pContext.getPlayer() == null) return InteractionResult.PASS;
        if (!pContext.getPlayer().isShiftKeyDown()) {
            return CopperwoodPickaxe.copperwoodUse(pContext);
        }
        return super.useOn(pContext);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (pPlayer.isShiftKeyDown()) {
            DarkCrystalPickaxe.darkCrystalUse(pLevel, pPlayer, pUsedHand);
        }
        return super.use(pLevel, pPlayer, pUsedHand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("description." + AlternaCraft.MODID + "." + "aio_pickaxe").withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
