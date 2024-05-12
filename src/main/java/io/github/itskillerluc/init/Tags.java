package io.github.itskillerluc.init;

import io.github.itskillerluc.AlternaCraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class Tags {
    public static final TagKey<Block> NEEDS_AIO_TOOL = BlockTags.create(new ResourceLocation(AlternaCraft.MODID, "needs_aio_tool"));
    public static final TagKey<Block> NEEDS_DARK_CRYSTAL_TOOL = BlockTags.create(new ResourceLocation(AlternaCraft.MODID, "needs_dark_crystal_tool"));

    public static final TagKey<Item> CHARRED_LOGS = ItemTags.create(new ResourceLocation(AlternaCraft.MODID, "charred_logs"));
    public static final TagKey<Item> ELECTREE_LOGS = ItemTags.create(new ResourceLocation(AlternaCraft.MODID, "electree_logs"));
}
