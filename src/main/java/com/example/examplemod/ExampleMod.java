package com.example.examplemod;

import com.example.examplemod.client.renderers.UnicornRenderer;
import com.example.examplemod.items.ModItems;
import com.mojang.logging.LogUtils;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import net.minecraft.world.item.CreativeModeTabs;
import com.example.examplemod.init.ModEntities;

/**
 * Main Mod Class
 * The value here should match an entry in the META-INF/mods.toml file
 */
@Mod(ExampleMod.MODID)
public class ExampleMod
{
    public static final String MODID = "examplemod"; // Define mod id in a common place for everything to reference
    private static final Logger LOGGER = LogUtils.getLogger();  // Directly reference a slf4j logger

    /**
     * Main method for mod.
     */
    public ExampleMod() {
        //comment
        doRegistrations();
    }

    /**
     * Registers things to the game.
     */
    private void doRegistrations(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        //Register Custom Mod Items
        ModItems.register(modEventBus);
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);


        // Register the ModEntities class for entity registration
        ModEntities.ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    /**
     * @param event
     */
    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    /**
     * Adds item to vanilla creative item tabs.
     */
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.SAPPHIRE);
            event.accept(ModItems.RAW_SAPPHIRE);
        }
    }

    /**
     *  You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
     */
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
            //Set up the renderer for the unicorn entity
            EntityRenderers.register(ModEntities.UNICORN.get(), UnicornRenderer::new);
        }
    }
}
