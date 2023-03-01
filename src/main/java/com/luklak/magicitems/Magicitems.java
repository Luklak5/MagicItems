package com.luklak.magicitems;

import com.luklak.magicitems.setup.ClientSetup;
import com.luklak.magicitems.setup.ModSetup;
import com.luklak.magicitems.setup.Registration;
import com.mojang.logging.LogUtils;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import static com.luklak.magicitems.Magicitems.MODID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MODID)
public class Magicitems {

    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();
    public static final String MODID = "magicitems";

    public Magicitems() {
        // Register the deferred registry
        //ModSetup.setup();
        Registration.init();
        //Config.register();

        // Register the setup method for modloading
        IEventBus modbus = FMLJavaModLoadingContext.get().getModEventBus();
        modbus.addListener(ModSetup::init);
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> modbus.addListener(ClientSetup::init));
    }
}
