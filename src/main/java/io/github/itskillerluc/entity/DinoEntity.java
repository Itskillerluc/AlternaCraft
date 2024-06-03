package io.github.itskillerluc.entity;

import io.github.itskillerluc.entity.ai.SleepingPattern;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.NeutralMob;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public abstract class DinoEntity extends TamableAnimal implements NeutralMob {
    private int hunger = 120000;

    protected DinoEntity(EntityType<? extends TamableAnimal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        pCompound.putInt("hunger", hunger);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        if (pCompound.contains("hunger")) {
            hunger = pCompound.getInt("hunger");
        }
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();

        goalSelector.addGoal(1, new MeleeAttackGoal(this, 1, false));
    }

    public float getHunger() {
        return hunger / 1200f;
    }

    public void feed(float hunger) {
        this.hunger = Math.max(120000, this.hunger + (int) hunger * 1200);
    }

    @Override
    public void tick() {
        super.tick();
        if (hunger > 0) {
            hunger--;
        }
    }

    abstract SleepingPattern getSleepingPattern();
}
