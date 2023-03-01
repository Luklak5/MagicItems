package com.luklak.magicitems.datagen;

import com.luklak.magicitems.Magicitems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Magicitems.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        if(event.includeServer())
        {
            MagBlockTags blockTags = new MagBlockTags(generator, event.getExistingFileHelper());
            generator.addProvider(blockTags);
            generator.addProvider(new MagItemTags(generator,blockTags,event.getExistingFileHelper()));
            generator.addProvider(new MagRecipes(generator));
            generator.addProvider(new MagLootTableProvider(generator));
        }
        if(event.includeClient())
        {
            generator.addProvider(new MagLanguageProvider(generator, "en_us"));
            generator.addProvider(new MagBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new MagItemModels(generator, event.getExistingFileHelper()));
        }
    }
}
