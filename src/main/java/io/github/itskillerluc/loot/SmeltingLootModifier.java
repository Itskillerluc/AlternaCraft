package io.github.itskillerluc.loot;

import com.google.common.base.Suppliers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public class SmeltingLootModifier extends LootModifier {
    public static final Supplier<Codec<SmeltingLootModifier>> CODEC = Suppliers.memoize(() -> RecordCodecBuilder.create(
            inst -> codecStart(inst).apply(inst, SmeltingLootModifier::new)));

    public SmeltingLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    public @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, @NotNull LootContext context) {
        ObjectArrayList<ItemStack> ret = new ObjectArrayList<>();
        generatedLoot.forEach((stack) -> ret.add(smelt(stack, context)));
        return ret;
    }

    private static ItemStack smelt(ItemStack stack, LootContext context) {
        return context.getLevel().getRecipeManager().getRecipeFor(RecipeType.SMELTING, new SimpleContainer(stack), context.getLevel())
                .map(smeltingRecipe -> smeltingRecipe.value().getResultItem(context.getLevel().registryAccess()))
                .filter(itemStack -> !itemStack.isEmpty())
                .map(itemStack -> ItemHandlerHelper.copyStackWithSize(itemStack, stack.getCount() * itemStack.getCount()))
                .orElse(stack);
    }

    @Override
    public @NotNull Codec<SmeltingLootModifier> codec() {
        return CODEC.get();
    }
}
