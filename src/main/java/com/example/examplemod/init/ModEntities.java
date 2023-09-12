package com.example.examplemod.init;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.entities.Unicorn;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {

    // The DeferredRegister is a safe way of registering things at the correct time.
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ExampleMod.MODID);

    // Registering the Unicorn Entity.
    public static final RegistryObject<EntityType<Unicorn>> UNICORN = ENTITY_TYPES.register("unicorn", () ->
            EntityType.Builder.of(Unicorn::new, MobCategory.CREATURE)
                    .sized(EntityType.HORSE.getWidth(), EntityType.HORSE.getHeight())
                    .build("unicorn"));

}
