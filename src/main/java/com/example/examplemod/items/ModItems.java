package com.example.examplemod.items;

import com.example.examplemod.ExampleMod;
import com.example.examplemod.init.ModEntities;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * This Class registers 2 new sapphire items and makes them known to the game.
 */
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MODID);
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_SAPPHIRE = ITEMS.register("raw_sapphire", () -> new Item(new Item.Properties()));

    //Create spawn egg for unicorn
    public static final RegistryObject<Item> UNICORN_SPAWN_EGG = ITEMS.register("unicorn_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntities.UNICORN, 0x000000, 0xFFFFFF, new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
