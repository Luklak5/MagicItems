package com.luklak.magicitems.attributes;

import com.google.common.collect.Multimap;
import com.luklak.magicitems.other.MagicRarity;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.ItemAttributeModifierEvent;

import java.util.Random;

public class ItemModification {

    Random random = new Random();

    public ItemModification() {
    }

    public ItemStack generateStats(ItemStack itemStack)
    {
        CompoundTag nbtData = new CompoundTag();
        nbtData.putInt("magicitems.ilvl",random.nextInt(100));
        int rarityId = random.nextInt(4);
        nbtData.putInt("magicitems.rarity", rarityId);
        MagicRarity rarity = MagicRarity.rarityLookup(rarityId);
        itemStack.setTag(nbtData);
        itemStack.setHoverName(new TextComponent(itemStack.getHoverName().getString()).withStyle(rarity.getColor()));
        return itemStack;
    }

}
