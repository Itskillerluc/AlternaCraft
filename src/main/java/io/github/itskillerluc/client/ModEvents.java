package io.github.itskillerluc.client;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.client.model.MagmatyrannusModel;
import io.github.itskillerluc.client.renderer.MagmatyrannusRenderer;
import io.github.itskillerluc.duclib.client.model.BaseDucModel;
import io.github.itskillerluc.entity.Magmatyrannus;
import io.github.itskillerluc.init.EntityRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(modid = AlternaCraft.MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEvents {
    @SubscribeEvent
    public static void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(EntityRegistry.MAGMATYRANNUS.get(), MagmatyrannusRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayers(final EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(MagmatyrannusModel.LAYER_LOCATION, () -> BaseDucModel.getLakeDefinition(Magmatyrannus.LOCATION));
    }
}
