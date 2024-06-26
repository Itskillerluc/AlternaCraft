package io.github.itskillerluc.event;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.init.ArmorMaterials;
import io.github.itskillerluc.init.ToolTiers;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.TieredItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import net.neoforged.neoforge.event.entity.living.LivingDropsEvent;
import org.apache.commons.lang3.stream.Streams;

@Mod.EventBusSubscriber(modid = AlternaCraft.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    @SubscribeEvent
    public static void livingAttackEvent(final LivingAttackEvent event) {
        if (event.getSource().is(DamageTypes.FALL)) {
            if (Streams.of(event.getEntity().getArmorSlots().iterator()).allMatch(stack ->
                    stack.getItem() instanceof ArmorItem armorItem && (armorItem.getMaterial() == ArmorMaterials.MAGNET || armorItem.getMaterial() == ArmorMaterials.AIO))) {
                event.setCanceled(true);
            }
        }
    }

    @SubscribeEvent
    public static void entityDropEvent(final LivingDropsEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            if (player.getMainHandItem().getItem() instanceof TieredItem tieredItem && (tieredItem.getTier() == ToolTiers.MAGNETIC_TIER || tieredItem.getTier() == ToolTiers.AIO_TIER)) {
                event.setCanceled(true);
                for (ItemEntity drop : event.getDrops()) {
                    if (!player.addItem(drop.getItem())) {
                        player.drop(drop.getItem(), false);
                    }
                }
            }
        }
    }
}
