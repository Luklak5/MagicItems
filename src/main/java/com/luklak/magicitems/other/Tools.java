package com.luklak.magicitems.other;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.Tag;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.BeaconBlock;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Random;

import static com.luklak.magicitems.setup.Registration.EQUIPMENT;

public class Tools {

    private static final Random random = new Random();
    private static final List<Item> equipList = ForgeRegistries.ITEMS.tags().getTag(EQUIPMENT).stream().toList();

    public static void spawnItem(Level level, BlockPos pos, ItemStack item)
    {
        if(!item.isEmpty())
        {
            ItemEntity itemEntity = new ItemEntity(level, pos.getX() + .5, pos.getY() + 1, pos.getZ() + .5, item);
            itemEntity.setNoPickUpDelay();
            itemEntity.setDeltaMovement(itemEntity.getDeltaMovement().multiply(0, 1, 0));
            level.addFreshEntity(itemEntity);
        }
    }

    public static ItemStack randomEquipment()
    {
        ItemStack item = new ItemStack(equipList.get(random.nextInt(equipList.size())));
        return item;
    }

}
