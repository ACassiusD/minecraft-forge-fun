package com.example.examplemod.client.models;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.items.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

// This class is used to tell Minecraft how to render our items.
public class ModItemModelProvider extends ItemModelProvider {
    // Constructor
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, ExampleMod.MODID, existingFileHelper);
    }

    // This method is used to tell Minecraft which item to render with which model.
    @Override
    protected void registerModels() {
        withExistingParent(ModItems.UNICORN_SPAWN_EGG.getId().getPath(), mcLoc("item/template_spawn_egg"));
    }
}