package io.github.itskillerluc.item;

import io.github.itskillerluc.AlternaCraft;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ArmorEffectItem extends ArmorItem {
    private final MobEffectInstance[] effect;
    private final String name;
    public ArmorEffectItem(String name, ArmorMaterial pMaterial, Type pType, Properties pProperties, MobEffectInstance... effect) {
        super(pMaterial, pType, pProperties);
        this.effect = effect;
        this.name = name;
    }

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (pEntity instanceof LivingEntity livingEntity) {
            if (!pLevel.isClientSide()) {
                if (hasFullSuitOfArmorOn(livingEntity)) {
                    evaluateArmorEffects(livingEntity);
                }
            }
        }
    }

    private void evaluateArmorEffects(LivingEntity pEntity) {
        if(hasFullSuitOfArmorOn(pEntity)) {
            for (MobEffectInstance mobEffectInstance : effect) {
                pEntity.addEffect(new MobEffectInstance(mobEffectInstance));
            }
        }
    }

    private boolean hasFullSuitOfArmorOn(LivingEntity pEntity) {
        for (ItemStack armorSlot : pEntity.getArmorSlots()) {
            if (armorSlot.isEmpty()) return false;
            ArmorItem armorItem = ((ArmorItem) armorSlot.getItem());
            if (armorItem.getMaterial() != getMaterial()) return false;
        }
        return true;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("description." + AlternaCraft.MODID + "." + name).withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}
