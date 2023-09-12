package com.example.examplemod.client.models;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entities.Unicorn;
import net.minecraft.client.model.HorseModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class UnicornModel<T extends Unicorn> extends HorseModel<T> {

    // The ModelLayerLocation is used to tell Minecraft where to find the model.
    public static final ModelLayerLocation UNICORN_MODEL_RESOURCE = new ModelLayerLocation(new ResourceLocation(ExampleMod.MODID, "unicorn"), "unicorn");

    public UnicornModel(final ModelPart root) {
        super(root);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = HorseModel.createBodyMesh(CubeDeformation.NONE);
        PartDefinition partdefinition = meshdefinition.getRoot();
        // create horn model as child of root in order to render separately
        PartDefinition horn = partdefinition.addOrReplaceChild("horn", CubeListBuilder.create()
                        .texOffs(0, 0).addBox(-0.5F, -21.0F, 0.5F, 1.0F, 5.0F, 1.0F, CubeDeformation.NONE)
                        .texOffs(0, 6).addBox(-1.0F, -16.0F, 0.0F, 2.0F, 5.0F, 2.0F, CubeDeformation.NONE),
                PartPose.offset(0.0F, -4.0F, -11.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }
}
