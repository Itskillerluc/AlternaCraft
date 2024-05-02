package io.github.itskillerluc.init;

import io.github.itskillerluc.AlternaCraft;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ArmorMaterials implements ArmorMaterial {
    COPPERWOOD("copperwood", 37, new int[] {3, 9, 7, 3}, 15,SoundEvents.ARMOR_EQUIP_DIAMOND,
            2.0F, 0.0F, () -> Ingredient.of(ItemRegistry.COPPERWOOD_CRYSTAL.get())),
    DARK_CRYSTAL("dark_crystal", 39, new int[] {3, 9, 7, 3}, 15,SoundEvents.ARMOR_EQUIP_DIAMOND,
            3.0F, 0.1F, () -> Ingredient.of(ItemRegistry.DARK_CRYSTAL.get())),
    MAGNET("magnet", 40, new int[] {3, 9, 7, 3}, 15,SoundEvents.ARMOR_EQUIP_IRON,
            3.0F, 0.1F, () -> Ingredient.of(ItemRegistry.MAGNETIC_CRYSTAL.get())),
    PAINITE("painite", 44, new int[] {3, 9, 7, 3}, 20,SoundEvents.ARMOR_EQUIP_NETHERITE,
            4.0F, 0.2F, () -> Ingredient.of(ItemRegistry.PAINITE_CRYSTAL.get())),
    AIO("aio", 60, new int[] {3, 9, 7, 3}, 25,SoundEvents.ARMOR_EQUIP_NETHERITE,
            6.0F, 0.5F, () -> Ingredient.of(ItemRegistry.AIO_CRYSTAL.get()));

    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    ArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound,
                   float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public int getDurabilityForType(ArmorItem.Type pType) {
        return BASE_DURABILITY[pType.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionAmounts[pType.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return AlternaCraft.MODID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
