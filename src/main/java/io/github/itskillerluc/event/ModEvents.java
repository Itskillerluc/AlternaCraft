package io.github.itskillerluc.event;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.entity.Magmatyrannus;
import io.github.itskillerluc.init.EntityRegistry;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@Mod.EventBusSubscriber(modid = AlternaCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void addEntityAttributes(final EntityAttributeCreationEvent event){
        event.put(EntityRegistry.MAGMATYRANNUS.get(), Magmatyrannus.attributes().build());
    }
}
