package io.github.itskillerluc.init;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.item.ArmorEffectItem;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ItemRegistry {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AlternaCraft.MODID);

    public static final Supplier<Item> COPPERWOOD_CRYSTAL = ITEMS.registerSimpleItem("copperwood_crystal");
    public static final Supplier<Item> DARK_CRYSTAL = ITEMS.registerSimpleItem("dark_crystal");
    public static final Supplier<Item> MAGNETIC_CRYSTAL = ITEMS.registerSimpleItem("magnetic_crystal");
    public static final Supplier<Item> AIO_CRYSTAL = ITEMS.registerSimpleItem("aio_crystal");
    public static final Supplier<Item> MINI_STAR = ITEMS.registerSimpleItem("mini_star");
    public static final Supplier<Item> PAINITE_CRYSTAL = ITEMS.registerSimpleItem("painite_crystal");
    public static final Supplier<Item> PRISAMOND_SHARD = ITEMS.registerSimpleItem("prisamond_shard");
    public static final Supplier<Item> prisma_stick = ITEMS.registerSimpleItem("prisma_stick");

    public static final DeferredHolder<Item, ArmorItem> COPPERWOOD_BOOTS = registerArmorWithDescription("copperwood_boots",
            ArmorMaterials.COPPERWOOD, ArmorItem.Type.BOOTS, new Item.Properties());
    public static final DeferredHolder<Item, ArmorEffectItem> COPPERWOOD_CHESTPLATE = ITEMS.register("copperwood_chestplate",
            () -> new ArmorEffectItem("copperwood_chestplate", ArmorMaterials.COPPERWOOD, ArmorItem.Type.CHESTPLATE, new Item.Properties(), new MobEffectInstance(MobEffects.REGENERATION)));
    public static final DeferredHolder<Item, ArmorItem> COPPERWOOD_LEGGINGS = registerArmorWithDescription("copperwood_leggings",
            ArmorMaterials.COPPERWOOD, ArmorItem.Type.LEGGINGS, new Item.Properties());
    public static final DeferredHolder<Item, ArmorItem> COPPERWOOD_HELMET = registerArmorWithDescription("copperwood_helmet",
            ArmorMaterials.COPPERWOOD, ArmorItem.Type.HELMET, new Item.Properties());
    public static final DeferredHolder<Item, ArmorItem> DARK_CRYSTAL_BOOTS = registerArmorWithDescription("dark_crystal_boots",
            ArmorMaterials.DARK_CRYSTAL, ArmorItem.Type.BOOTS, new Item.Properties());
    public static final DeferredHolder<Item, ArmorEffectItem> DARK_CRYSTAL_CHESTPLATE = ITEMS.register("dark_crystal_chestplate",
            () -> new ArmorEffectItem("dark_crystal_chestplate", ArmorMaterials.DARK_CRYSTAL, ArmorItem.Type.CHESTPLATE, new Item.Properties(), new MobEffectInstance(MobEffects.DAMAGE_BOOST)));
    public static final DeferredHolder<Item, ArmorItem> DARK_CRYSTAL_LEGGINGS = registerArmorWithDescription("dark_crystal_leggings",
            ArmorMaterials.DARK_CRYSTAL, ArmorItem.Type.LEGGINGS, new Item.Properties());
    public static final DeferredHolder<Item, ArmorItem> DARK_CRYSTAL_HELMET = registerArmorWithDescription("dark_crystal_helmet",
            ArmorMaterials.DARK_CRYSTAL, ArmorItem.Type.HELMET, new Item.Properties());
    public static final DeferredHolder<Item, ArmorItem> MAGNETIC_BOOTS = registerArmorWithDescription("magnetic_boots",
            ArmorMaterials.MAGNET, ArmorItem.Type.BOOTS, new Item.Properties());
    public static final DeferredHolder<Item, ArmorItem> MAGNETIC_CHESTPLATE = registerArmorWithDescription("magnetic_chestplate",
            ArmorMaterials.MAGNET, ArmorItem.Type.CHESTPLATE, new Item.Properties());
    public static final DeferredHolder<Item, ArmorItem> MAGNETIC_LEGGINGS = registerArmorWithDescription("magnetic_leggings",
            ArmorMaterials.MAGNET, ArmorItem.Type.LEGGINGS, new Item.Properties());
    public static final DeferredHolder<Item, ArmorItem> MAGNETIC_HELMET = registerArmorWithDescription("magnetic_helmet",
            ArmorMaterials.MAGNET, ArmorItem.Type.HELMET, new Item.Properties());
    public static final DeferredHolder<Item, ArmorItem> AIO_BOOTS = registerArmorWithDescription("aio_boots",
            ArmorMaterials.AIO, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant());
    public static final DeferredHolder<Item, ArmorEffectItem> AIO_CHESTPLATE = ITEMS.register("aio_chestplate",
            () -> new ArmorEffectItem("aio_chestplate", ArmorMaterials.AIO, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant(), new MobEffectInstance(MobEffects.DAMAGE_BOOST, 1, 1, false, false), new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1, 0, false, false), new MobEffectInstance(MobEffects.REGENERATION, 1, 1, false, false)));
    public static final DeferredHolder<Item, ArmorItem> AIO_LEGGINGS = registerArmorWithDescription("aio_leggings",
            ArmorMaterials.AIO, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant());
    public static final DeferredHolder<Item, ArmorItem> AIO_HELMET = registerArmorWithDescription("aio_helmet",
            ArmorMaterials.AIO, ArmorItem.Type.HELMET, new Item.Properties().fireResistant());
    public static final DeferredHolder<Item, ArmorItem> PAINITE_BOOTS = registerArmorWithDescription("painite_boots",
            ArmorMaterials.PAINITE, ArmorItem.Type.BOOTS, new Item.Properties().fireResistant());
    public static final DeferredHolder<Item, ArmorEffectItem> PAINITE_CHESTPLATE = ITEMS.register("painite_chestplate",
            () -> new ArmorEffectItem("painite_chestplate", ArmorMaterials.PAINITE, ArmorItem.Type.CHESTPLATE, new Item.Properties().fireResistant(), new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 1, 0, false, false)));
    public static final DeferredHolder<Item, ArmorItem> PAINITE_LEGGINGS = registerArmorWithDescription("painite_leggings",
            ArmorMaterials.PAINITE, ArmorItem.Type.LEGGINGS, new Item.Properties().fireResistant());
    public static final DeferredHolder<Item, ArmorItem> PAINITE_HELMET = registerArmorWithDescription("painite_helmet",
            ArmorMaterials.PAINITE, ArmorItem.Type.HELMET, new Item.Properties().fireResistant());

    private static DeferredHolder<Item, ArmorItem> registerArmorWithDescription(String name, ArmorMaterial material, ArmorItem.Type type, Item.Properties properties) {
        return ITEMS.register(name, () -> new ArmorItem(material, type, properties) {
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
                pTooltipComponents.add(Component.translatable("description." + AlternaCraft.MODID + "." + name).withStyle(ChatFormatting.GOLD, ChatFormatting.ITALIC));
                super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
            }
        });
    }
}
