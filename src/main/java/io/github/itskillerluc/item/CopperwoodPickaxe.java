package io.github.itskillerluc.item;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.block.MiningLight;
import io.github.itskillerluc.init.BlockRegistry;
import io.github.itskillerluc.init.ToolActions;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class CopperwoodPickaxe extends PickaxeItem {
    public CopperwoodPickaxe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return super.canPerformAction(stack, toolAction) || toolAction.equals(ToolActions.PLACE_LIGHT);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        InteractionResult result = copperwoodUse(pContext);
        if (result == InteractionResult.PASS) {
            return super.useOn(pContext);
        } else {
            return result;
        }
    }

    public static InteractionResult copperwoodUse(UseOnContext context) {
        BlockPos pos = context.getClickedPos().relative(context.getClickedFace());
        if (context.getLevel().getBlockState(pos).canBeReplaced()) {
            return context.getLevel().setBlockAndUpdate(pos, BlockRegistry.MINING_LIGHT.get().defaultBlockState()) ? InteractionResult.SUCCESS : InteractionResult.FAIL;
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("description." + AlternaCraft.MODID + "." + "copperwood_pickaxe").withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
