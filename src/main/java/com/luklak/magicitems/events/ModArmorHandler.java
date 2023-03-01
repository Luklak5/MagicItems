package com.luklak.magicitems.events;

import com.luklak.magicitems.Magicitems;
import com.luklak.magicitems.armor.IModArmor;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Magicitems.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModArmorHandler {

    @SubscribeEvent
    public static void armorEquipHandler(LivingEquipmentChangeEvent event)
    {
        ItemStack to = event.getTo();
        ItemStack from = event.getFrom();
        EquipmentSlot slot = event.getSlot();
        if(slot != EquipmentSlot.MAINHAND && slot != EquipmentSlot.OFFHAND)
        {
            if(!to.isEmpty())
            {
                if(to.getItem() instanceof IModArmor)
                {
                    ((IModArmor)to.getItem()).onEquip(to, event.getEntityLiving());
                }
            }
            else
            {
                if(from.getItem() instanceof IModArmor)
                {
                    ((IModArmor)from.getItem()).onUnequip(event.getEntityLiving());
                }
            }
        }
    }
}
