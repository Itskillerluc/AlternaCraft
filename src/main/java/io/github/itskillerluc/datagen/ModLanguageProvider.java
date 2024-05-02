package io.github.itskillerluc.datagen;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.init.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ModLanguageProvider extends net.neoforged.neoforge.common.data.LanguageProvider {
    private static final List<Supplier<? extends Item>> EXCLUDED_ITEMS = List.of(
            ItemRegistry.AIO_CRYSTAL,
            ItemRegistry.AIO_HELMET,
            ItemRegistry.AIO_CHESTPLATE,
            ItemRegistry.AIO_LEGGINGS,
            ItemRegistry.AIO_BOOTS,
            ItemRegistry.AIO_HOE,
            ItemRegistry.AIO_AXE,
            ItemRegistry.AIO_PICKAXE,
            ItemRegistry.AIO_SHOVEL,
            ItemRegistry.AIO_SWORD
    );

    public ModLanguageProvider(PackOutput output) {
        super(output, AlternaCraft.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        // Creative mode tabs
        add("ítemGroup." + AlternaCraft.MODID + ".main", "AlternaCraft");

        // Items
        for (DeferredHolder<Item, ? extends Item> entry : ItemRegistry.ITEMS.getEntries()) {
            if (EXCLUDED_ITEMS.contains(entry) || entry.get() instanceof BlockItem) continue;
            var input = entry.getKey().location().getPath();
            addItem(entry, Arrays.stream(input.split("_"))
                    .map(word -> Character.toTitleCase(word.charAt(0)) + word.substring(1))
                    .collect(Collectors.joining(" ")));
        }
        addItem(ItemRegistry.AIO_CRYSTAL, "All In One Crystal");
        addItem(ItemRegistry.AIO_HELMET, "All In One Helmet");
        addItem(ItemRegistry.AIO_CHESTPLATE, "All In One Chestplate");
        addItem(ItemRegistry.AIO_LEGGINGS, "All In One Leggings");
        addItem(ItemRegistry.AIO_BOOTS, "All In One Boots");
        addItem(ItemRegistry.AIO_HOE, "All In One Hoe");
        addItem(ItemRegistry.AIO_PICKAXE, "All In One Pickaxe");
        addItem(ItemRegistry.AIO_SHOVEL, "All In One Shovel");
        addItem(ItemRegistry.AIO_SWORD, "All In One Sword");
        addItem(ItemRegistry.AIO_AXE, "All In One Axe");

        // Item descriptions
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.AIO_HELMET.getId().getPath(), "Prevents fall damage and grants strength 2, regeneration 2 and fire resistance when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.AIO_CHESTPLATE.getId().getPath(), "Prevents fall damage and grants strength 2, regeneration 2 and fire resistance when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.AIO_LEGGINGS.getId().getPath(), "Prevents fall damage and grants strength 2, regeneration 2 and fire resistance when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.AIO_BOOTS.getId().getPath(), "Prevents fall damage and grants strength 2, regeneration 2 and fire resistance when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.DARK_CRYSTAL_HELMET.getId().getPath(), "Grants strength 1 when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.DARK_CRYSTAL_CHESTPLATE.getId().getPath(), "Grants strength 1 when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.DARK_CRYSTAL_LEGGINGS.getId().getPath(), "Grants strength 1 when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.DARK_CRYSTAL_BOOTS.getId().getPath(), "Grants strength 1 when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.COPPERWOOD_HELMET.getId().getPath(), "Grants regeneration 1 when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.COPPERWOOD_CHESTPLATE.getId().getPath(), "Grants regeneration 1 when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.COPPERWOOD_LEGGINGS.getId().getPath(), "Grants regeneration 1 when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.COPPERWOOD_BOOTS.getId().getPath(), "Grants regeneration 1 when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.PAINITE_HELMET.getId().getPath(), "Grants fire resistance 1 when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.PAINITE_CHESTPLATE.getId().getPath(), "Grants fire resistance 1 when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.PAINITE_LEGGINGS.getId().getPath(), "Grants fire resistance 1 when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.PAINITE_BOOTS.getId().getPath(), "Grants fire resistance 1 when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.MAGNETIC_HELMET.getId().getPath(), "Prevents fall damage when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.MAGNETIC_CHESTPLATE.getId().getPath(), "Prevents fall damage when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.MAGNETIC_LEGGINGS.getId().getPath(), "Prevents fall damage when full set is worn.");
        add("description." + AlternaCraft.MODID + "." + ItemRegistry.MAGNETIC_BOOTS.getId().getPath(), "Prevents fall damage when full set is worn.");
    }


}
