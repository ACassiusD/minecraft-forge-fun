package com.example.examplemod.events;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entities.Unicorn;
import com.example.examplemod.init.ModEntities;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// Annotation tells Forge, class is listening to events for the mod with ID "examplemod" during the mod loading process.
@Mod.EventBusSubscriber(modid = ExampleMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    // The @SubscribeEvent annotation tells Forge that this method should be called when the EntityAttributeCreationEvent occurs.
    // This code is called when the EntityAttributeCreationEvent is fired by Forge during the mod loading process.
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        // Register the Unicorn's attributes with the event. This is how we tell the game what the Unicorn's attributes are.
        event.put(ModEntities.UNICORN.get(), Unicorn.getBaseAttributes());
    }
}

