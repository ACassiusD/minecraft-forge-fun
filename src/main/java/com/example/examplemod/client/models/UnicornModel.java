package com.example.examplemod.client.models;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entities.Unicorn;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.resources.ResourceLocation;

public class UnicornModel<T extends Unicorn> extends HorseModel<T> {

    // The ModelLayerLocation is used to tell Minecraft where to find the model.
    // I am trying to use the same location as the vanilla horse model.
    public static final ModelLayerLocation UNICORN_MODEL_LAYER = new ModelLayerLocation(new ResourceLocation(ExampleMod.MODID, "unicorn"), "main");

    public UnicornModel(final ModelPart root) {
        super(root);
    }
}
