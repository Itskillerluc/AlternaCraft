package io.github.itskillerluc.init;

import io.github.itskillerluc.AlternaCraft;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.List;
import java.util.function.Supplier;

public class CreativeTabRegistry {
    private static final List<Supplier<Item>> EXCLUDED = List.of(
            // Items that should not be registered to the main creative mode tab.
    );
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(BuiltInRegistries.CREATIVE_MODE_TAB, AlternaCraft.MODID);

    public static final Supplier<CreativeModeTab> ALTERNACRAFT_TAB = CREATIVE_TABS.register("alternacraft_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("ítemGroup." + AlternaCraft.MODID + ".main"))
                    .icon(() -> new ItemStack(ItemRegistry.AIO_CRYSTAL.get()))
                    .displayItems((params, output) -> {
                        for (DeferredHolder<Item, ? extends Item> entry : ItemRegistry.ITEMS.getEntries()) {
                            if (EXCLUDED.contains(entry)) continue;
                            output.accept(entry.get());
                        }
                    })
                    .build());
}
