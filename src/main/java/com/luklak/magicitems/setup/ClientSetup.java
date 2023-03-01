package com.luklak.magicitems.setup;

import com.luklak.magicitems.Magicitems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = Magicitems.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup
{

    public static void init(FMLClientSetupEvent event)
    {

    }
}
