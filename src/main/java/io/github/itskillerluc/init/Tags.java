package io.github.itskillerluc.init;

import io.github.itskillerluc.AlternaCraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Tags {
    public static class Blocks {
        public static final TagKey<Block> BLUE_PASTEL_LOGS = BlockTags.create(new ResourceLocation(AlternaCraft.MODID, "blue_pastel_logs"));
        public static final TagKey<Block> CHARRED_LOGS = BlockTags.create(new ResourceLocation(AlternaCraft.MODID, "charred_logs"));
        public static final TagKey<Block> COPPERWOOD_ORES = BlockTags.create(new ResourceLocation(AlternaCraft.MODID, "copperwood_ores"));
        public static final TagKey<Block> DARK_CRYSTAL_ORES = BlockTags.create(new ResourceLocation(AlternaCraft.MODID, "dark_crystal_ores"));
        public static final TagKey<Block> ELECTREE_LOGS = BlockTags.create(new ResourceLocation(AlternaCraft.MODID, "electree_logs"));
        public static final TagKey<Block> NEEDS_AIO_TOOL = BlockTags.create(new ResourceLocation(AlternaCraft.MODID, "needs_aio_tool"));
        public static final TagKey<Block> NEEDS_DARK_CRYSTAL_TOOL = BlockTags.create(new ResourceLocation(AlternaCraft.MODID, "needs_dark_crystal_tool"));
        public static final TagKey<Block> PAINITE_ORES = BlockTags.create(new ResourceLocation(AlternaCraft.MODID, "painite_ores"));
        public static final TagKey<Block> RED_PASTEL_LOGS = BlockTags.create(new ResourceLocation(AlternaCraft.MODID, "red_pastel_logs"));
    }

    public static class Items {
        public static final TagKey<Item> BLUE_PASTEL_LOGS = ItemTags.create(new ResourceLocation(AlternaCraft.MODID, "blue_pastel_logs"));
        public static final TagKey<Item> CHARRED_LOGS = ItemTags.create(new ResourceLocation(AlternaCraft.MODID, "charred_logs"));
        public static final TagKey<Item> COPPERWOOD_ORES = ItemTags.create(new ResourceLocation(AlternaCraft.MODID, "copperwood_ores"));
        public static final TagKey<Item> DARK_CRYSTAL_ORES = ItemTags.create(new ResourceLocation(AlternaCraft.MODID, "dark_crystal_ores"));
        public static final TagKey<Item> ELECTREE_LOGS = ItemTags.create(new ResourceLocation(AlternaCraft.MODID, "electree_logs"));
        public static final TagKey<Item> PAINITE_ORES = ItemTags.create(new ResourceLocation(AlternaCraft.MODID, "painite_ores"));
        public static final TagKey<Item> RED_PASTEL_LOGS = ItemTags.create(new ResourceLocation(AlternaCraft.MODID, "red_pastel_logs"));
    }

    public static class EntityTypes {
        public static final TagKey<EntityType<?>> MINI_DINOS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(AlternaCraft.MODID, "mini_dinos"));
        public static final TagKey<EntityType<?>> SMALL_DINOS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(AlternaCraft.MODID, "small_dinos"));
        public static final TagKey<EntityType<?>> MEDIUM_DINOS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(AlternaCraft.MODID, "medium_dinos"));
        public static final TagKey<EntityType<?>> LARGE_DINOS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(AlternaCraft.MODID, "large_dinos"));
        public static final TagKey<EntityType<?>> DINOS = TagKey.create(Registries.ENTITY_TYPE, new ResourceLocation(AlternaCraft.MODID, "dinos"));
    }
}
