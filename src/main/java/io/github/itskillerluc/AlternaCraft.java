package io.github.itskillerluc;

import com.mojang.logging.LogUtils;
import io.github.itskillerluc.init.*;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DiggerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;
import java.util.List;

@Mod(AlternaCraft.MODID)
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
