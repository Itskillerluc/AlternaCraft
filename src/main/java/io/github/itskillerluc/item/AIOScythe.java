package io.github.itskillerluc.item;

import com.mojang.datafixers.util.Pair;
import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.init.ToolActions;
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
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.ToolAction;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class AIOScythe extends HoeItem {
    public AIOScythe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        InteractionResult result = CopperwoodHoe.copperwoodUse(pContext);
        if (result == InteractionResult.SUCCESS) {
            return result;
        }
        DarkCrystalHoe.darkCrystalUse(pContext);
        return super.useOn(pContext);
    }

    @Override
    public boolean canPerformAction(ItemStack stack, ToolAction toolAction) {
        return super.canPerformAction(stack, toolAction) || toolAction.equals(ToolActions.CROP_HARVEST);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("description." + AlternaCraft.MODID + "." + "aio_scythe").withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
