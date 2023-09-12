package com.example.examplemod.entities;

import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

public class Unicorn extends Horse {

    /**
     * Constructor
     *
     * @param type
     * @param worldIn
     */
    public Unicorn(EntityType<? extends Horse> type, Level worldIn) {
        super(type, worldIn);
    }

    /**
     * Get the base attributes for the Unicorn
     *
     * @return
     */
    public static AttributeSupplier getBaseAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 30.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.3D)
                .add(Attributes.JUMP_STRENGTH, 1.0D).build();
    }
}
