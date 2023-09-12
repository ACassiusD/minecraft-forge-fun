package com.example.examplemod.client.renderers;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.client.models.UnicornModel;
import com.example.examplemod.entities.Unicorn;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class UnicornRenderer extends MobRenderer<Unicorn, UnicornModel<Unicorn>> {

    // The ResourceLocation is used to tell Minecraft where to find the texture.
    private static final ResourceLocation UNICORN_TEXTURE = new ResourceLocation(ExampleMod.MODID, "textures/entity/unicorn/unicorn.png");

    // Constructor
    public UnicornRenderer(EntityRendererProvider.Context context) {
        super(context, new UnicornModel<>(context.bakeLayer(UnicornModel.UNICORN_MODEL_RESOURCE)), 0.75F);
    }

    // This method is used to tell Minecraft which texture to use for our unicorn.
    @Override
    public ResourceLocation getTextureLocation(Unicorn unicorn) {
        // Return the default horse texture for our unicorn
        return UNICORN_TEXTURE;
    }
}