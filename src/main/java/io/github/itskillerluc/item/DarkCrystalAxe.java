package io.github.itskillerluc.item;

import io.github.itskillerluc.AlternaCraft;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DarkCrystalAxe extends AxeItem {
    public DarkCrystalAxe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pProperties.attributes(AxeItem.createAttributes(pTier, pAttackDamageModifier, pAttackSpeedModifier)));
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack pStack, @NotNull LivingEntity pTarget, @NotNull LivingEntity pAttacker) {
        darkCrystalHurt(pTarget);
        return super.hurtEnemy(pStack, pTarget, pAttacker);
    }

    public static void darkCrystalHurt(LivingEntity pTarget) {
        pTarget.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 300));
        pTarget.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300));
    }

    @Override
    public void appendHoverText(ItemStack pStack, TooltipContext pContext, List<Component> pTooltipComponents, TooltipFlag pTooltipFlag) {
        pTooltipComponents.add(Component.translatable("description." + AlternaCraft.MODID + "." + "dark_crystal_axe").withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
        super.appendHoverText(pStack, pContext, pTooltipComponents, pTooltipFlag);
    }
}
