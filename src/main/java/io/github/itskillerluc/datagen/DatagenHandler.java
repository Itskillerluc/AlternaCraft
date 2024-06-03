package io.github.itskillerluc.datagen;

import io.github.itskillerluc.AlternaCraft;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;

@Mod.EventBusSubscriber(modid = AlternaCraft.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DatagenHandler {
    @SubscribeEvent
    public static void gatherData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(event.includeClient(), new ModLanguageProvider(output));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(output, existingFileHelper));
        ModBlockTagProvider modBlockTagProvider = new ModBlockTagProvider(output, event.getLookupProvider(), existingFileHelper);
        generator.addProvider(event.includeServer(), modBlockTagProvider);
        generator.addProvider(event.includeServer(), new ModDataMapProvider(output, event.getLookupProvider()));
        generator.addProvider(event.includeServer(), new ModItemTagProvider(output, event.getLookupProvider(), modBlockTagProvider.contentsGetter(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModEntityTypeTagProvider(output, event.getLookupProvider(), existingFileHelper));
        generator.addProvider(event.includeServer(), new ModLootModifierProvider(output));
        generator.addProvider(event.includeServer(), new ModRecipeProvider(output));
        generator.addProvider(event.includeClient(), new ModSoundProvider(output, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(output, existingFileHelper));
        generator.addProvider(event.includeServer(), new LootTableProvider(output, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK))));
    }
}
