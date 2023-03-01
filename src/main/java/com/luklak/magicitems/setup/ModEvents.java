package com.luklak.magicitems.setup;

import com.luklak.magicitems.Magicitems;
import com.luklak.magicitems.commands.GenerateItemCommand;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = Magicitems.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event)
    {
        new GenerateItemCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }
}
