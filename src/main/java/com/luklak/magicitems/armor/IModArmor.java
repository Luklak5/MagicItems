package com.luklak.magicitems.armor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public interface IModArmor {

    default void onEquip(ItemStack itemStack, LivingEntity entity)
    {
        return;
    }

    default void onUnequip(LivingEntity entity)
    {
        return;
    }
}
