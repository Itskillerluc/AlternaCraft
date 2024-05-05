package io.github.itskillerluc.item;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.init.ToolActions;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Set;

public class CopperwoodHoe extends HoeItem {
    public CopperwoodHoe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
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

    public static InteractionResult copperwoodUse(UseOnContext pContext) {
        BlockState state = pContext.getLevel().getBlockState(pContext.getClickedPos());
        if (state.getBlock() instanceof CropBlock crop) {
            if (crop.isMaxAge(state)) {
                pContext.getLevel().destroyBlock(pContext.getClickedPos(), true, pContext.getPlayer());
                if (pContext.getPlayer() != null) {
                    int itemSlot = pContext.getPlayer().getInventory().findSlotMatchingItem(new ItemStack(crop.asItem()));
                    if (itemSlot > -1) {
                        pContext.getPlayer().getInventory().removeItem(itemSlot, 1);
                        pContext.getLevel().setBlock(pContext.getClickedPos(), crop.defaultBlockState(), 3);
                    }
                }
                return InteractionResult.SUCCESS;
            } else {
                return InteractionResult.FAIL;
            }
        } else {
            return InteractionResult.PASS;
        }
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return super.canPerformAction(stack, toolAction) || toolAction.equals(ToolActions.CROP_HARVEST);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("description." + AlternaCraft.MODID + "." + "copperwood_hoe").withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
