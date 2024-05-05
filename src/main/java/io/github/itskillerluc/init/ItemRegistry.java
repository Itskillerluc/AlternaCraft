package io.github.itskillerluc.init;

import io.github.itskillerluc.AlternaCraft;
import io.github.itskillerluc.item.*;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
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

    public static final Supplier<PickaxeItem> AIO_PICKAXE = ITEMS.registerItem("aio_pickaxe",
            properties -> new PickaxeItem(ToolTiers.AIO_TIER, 5, -3, properties.fireResistant()));
    public static final Supplier<AxeItem> AIO_AXE = ITEMS.registerItem("aio_axe",
            properties -> new AxeItem(ToolTiers.AIO_TIER, 34, -2.7f, properties.fireResistant()));
    public static final Supplier<SwordItem> AIO_SWORD = ITEMS.registerItem("aio_sword",
            properties -> new SwordItem(ToolTiers.AIO_TIER, 27, -2, properties.fireResistant()));
    public static final Supplier<HoeItem> AIO_HOE = ITEMS.registerItem("aio_scythe",
            properties -> new HoeItem(ToolTiers.AIO_TIER, 22, 0, properties.fireResistant()));
    public static final Supplier<ShovelItem> AIO_SHOVEL = ITEMS.registerItem("aio_shovel",
            properties -> new ShovelItem(ToolTiers.AIO_TIER, 3, -3, properties.fireResistant()));
    public static final Supplier<PickaxeItem> DARK_CRYSTAL_PICKAXE = ITEMS.registerItem("dark_crystal_pickaxe",
            properties -> new PickaxeItem(ToolTiers.DARK_CRYSTAL_TIER, 1, -2.8f, properties));
    public static final Supplier<AxeItem> DARK_CRYSTAL_AXE = ITEMS.registerItem("dark_crystal_axe",
            properties -> new AxeItem(ToolTiers.DARK_CRYSTAL_TIER, 14, -3.3f, properties));
    public static final Supplier<SwordItem> DARK_CRYSTAL_SWORD = ITEMS.registerItem("dark_crystal_sword",
            properties -> new SwordItem(ToolTiers.DARK_CRYSTAL_TIER, 7, -2.4f, properties));
    public static final Supplier<HoeItem> DARK_CRYSTAL_HOE = ITEMS.registerItem("dark_crystal_hoe",
            properties -> new HoeItem(ToolTiers.DARK_CRYSTAL_TIER, 0, 0, properties));
    public static final Supplier<ShovelItem> DARK_CRYSTAL_SHOVEL = ITEMS.registerItem("dark_crystal_shovel",
            properties -> new ShovelItem(ToolTiers.DARK_CRYSTAL_TIER, 1, -3, properties));
    public static final DeferredHolder<Item, PickaxeItem> PAINITE_PICKAXE = ITEMS.registerItem("painite_pickaxe",
            properties -> new PainitePickaxe(ToolTiers.PAINITE_TIER, 1, -2.8f, properties.fireResistant()));
    public static final DeferredHolder<Item, AxeItem> PAINITE_AXE = ITEMS.registerItem("painite_axe",
            properties -> new PainiteAxe(ToolTiers.PAINITE_TIER, 9, -3.3f, properties.fireResistant()));
    public static final Supplier<SwordItem> PAINITE_SWORD = ITEMS.registerItem("painite_sword",
            properties -> new SwordItem(ToolTiers.PAINITE_TIER, 7, -2.4f, properties.fireResistant()));
    public static final DeferredHolder<Item, HoeItem> PAINITE_HOE = ITEMS.registerItem("painite_scythe",
            properties -> new PainiteScythe(ToolTiers.PAINITE_TIER, 3, 0, properties.fireResistant()));
    public static final DeferredHolder<Item, ShovelItem> PAINITE_SHOVEL = ITEMS.registerItem("painite_shovel",
            properties -> new PainiteShovel(ToolTiers.PAINITE_TIER, 1, -3, properties.fireResistant()));
    public static final Supplier<PickaxeItem> COPPERWOOD_PICKAXE = ITEMS.registerItem("copperwood_pickaxe",
            properties -> new PickaxeItem(ToolTiers.COPPERWOOD_TIER, 1, -2.8f, properties));
    public static final Supplier<AxeItem> COPPERWOOD_AXE = ITEMS.registerItem("copperwood_axe",
            properties -> new AxeItem(ToolTiers.COPPERWOOD_TIER, 9, -3.0f, properties));
    public static final Supplier<SwordItem> COPPERWOOD_SWORD = ITEMS.registerItem("copperwood_sword",
            properties -> new SwordItem(ToolTiers.COPPERWOOD_TIER, 4, -1.8f, properties));
    public static final Supplier<HoeItem> COPPERWOOD_HOE = ITEMS.registerItem("copperwood_hoe",
            properties -> new HoeItem(ToolTiers.COPPERWOOD_TIER, 0, 0, properties));
    public static final Supplier<ShovelItem> COPPERWOOD_SHOVEL = ITEMS.registerItem("copperwood_shovel",
            properties -> new ShovelItem(ToolTiers.COPPERWOOD_TIER, 1, -3, properties));
    public static final Supplier<PickaxeItem> MAGNETIC_PICKAXE = ITEMS.registerItem("magnetic_pickaxe",
            properties -> new PickaxeItem(ToolTiers.MAGNETIC_TIER, 1, -2.8f, properties));
    public static final Supplier<AxeItem> MAGNETIC_AXE = ITEMS.registerItem("magnetic_axe",
            properties -> new AxeItem(ToolTiers.MAGNETIC_TIER, 9, -3.0f, properties));
    public static final Supplier<SwordItem> MAGNETIC_SWORD = ITEMS.registerItem("magnetic_sword",
            properties -> new SwordItem(ToolTiers.MAGNETIC_TIER, 6, -2.4f, properties));
    public static final Supplier<HoeItem> MAGNETIC_HOE = ITEMS.registerItem("magnetic_hoe",
            properties -> new HoeItem(ToolTiers.MAGNETIC_TIER, 0, 0, properties));
    public static final Supplier<ShovelItem> MAGNETIC_SHOVEL = ITEMS.registerItem("magnetic_shovel",
            properties -> new ShovelItem(ToolTiers.MAGNETIC_TIER, 1, -3, properties));

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
