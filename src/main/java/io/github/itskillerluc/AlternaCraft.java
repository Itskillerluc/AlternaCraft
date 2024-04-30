package io.github.itskillerluc;

import com.mojang.logging.LogUtils;
import io.github.itskillerluc.init.CreativeTabRegistry;
import io.github.itskillerluc.init.ItemRegistry;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;

@Mod(AlternaCraft.MODID)
public class AlternaCraft {
    public static final String MODID = "alternacraft";
    private static final Logger LOGGER = LogUtils.getLogger();
    public AlternaCraft(IEventBus modEventBus, ModContainer modContainer) {
        ItemRegistry.ITEMS.register(modEventBus);
        CreativeTabRegistry.CREATIVE_TABS.register(modEventBus);
    }
}
