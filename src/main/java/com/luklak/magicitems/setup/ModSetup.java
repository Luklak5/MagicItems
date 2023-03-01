package com.luklak.magicitems.setup;

import com.luklak.magicitems.Magicitems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = Magicitems.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup
{
    public static final String TAB_NAME = "magicitems";

    public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(TAB_NAME) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.IRON_CHESTPLATE);
        }
    };

    public static void init(FMLCommonSetupEvent event)
    {

    }
}
