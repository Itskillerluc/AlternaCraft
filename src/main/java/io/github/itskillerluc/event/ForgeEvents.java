package io.github.itskillerluc.event;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.init.ArmorMaterials;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.item.ArmorItem;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.living.LivingAttackEvent;
import org.apache.commons.lang3.stream.Streams;

@Mod.EventBusSubscriber(modid = AlternaCraft.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {
    @SubscribeEvent
    public static void fallEvent(final LivingAttackEvent event) {
        if (event.getSource().is(DamageTypes.FALL)) {
            if (Streams.of(event.getEntity().getArmorSlots().iterator()).allMatch(stack ->
                    stack.getItem() instanceof ArmorItem armorItem && (armorItem.getMaterial() == ArmorMaterials.MAGNET || armorItem.getMaterial() == ArmorMaterials.AIO))) {
                event.setCanceled(true);
            }
        }
    }
}
