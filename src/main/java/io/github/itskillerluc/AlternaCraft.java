package io.github.itskillerluc;

import com.mojang.logging.LogUtils;
import io.github.itskillerluc.init.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(AlternaCraft.MODID)
@SuppressWarnings("unused")
public class AlternaCraft {
    public static final String MODID = "alternacraft";
    private static final Logger LOGGER = LogUtils.getLogger();
    public AlternaCraft(IEventBus modEventBus, ModContainer modContainer) {
        SoundEventRegistry.SOUND_EVENTS.register(modEventBus);
        BlockRegistry.BLOCKS.register(modEventBus);
        FluidRegistry.FLUIDS.register(modEventBus);
        FluidTypeRegistry.FLUID_TYPES.register(modEventBus);
        ItemRegistry.ITEMS.register(modEventBus);
        CreativeTabRegistry.CREATIVE_TABS.register(modEventBus);
        GlobalLootModifierRegistry.MODIFIERS.register(modEventBus);
    }
}
