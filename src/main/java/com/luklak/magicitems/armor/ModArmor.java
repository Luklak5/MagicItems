package com.luklak.magicitems.armor;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.LinkedHashMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModArmor extends ArmorItem implements IModArmor {

    public ModArmor(ArmorMaterial pMaterial, EquipmentSlot pSlot, Properties pProperties) {
        super(pMaterial, pSlot, pProperties);
    }

    @Override
    public boolean isEnchantable(ItemStack pStack) {
        return false;
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return false;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(pStack.hasTag())
        {
            int ilvl = pStack.getTag().getInt("magicitems.ilvl");
            String itemLevel = "Item Level: " + ilvl;
            pTooltipComponents.add(new TextComponent(itemLevel).withStyle(ChatFormatting.GRAY));
        }
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlot slot, ItemStack stack) {
        if(slot != stack.getEquipmentSlot())
        {
            return super.getAttributeModifiers(slot, stack);
        }
        ImmutableMultimap.Builder<Attribute, AttributeModifier> attributes = ImmutableMultimap.builder();
        attributes.put(Attributes.MAX_HEALTH, new AttributeModifier("Health", 5, AttributeModifier.Operation.ADDITION));
        return attributes.build();
    }

    /*
    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        if(!level.isClientSide())
        {
            CompoundTag nbt = stack.getTag();
            if(nbt.contains("magicitems.attHealth"))
            {
                player.setHealth();
            }
        }
    }
    */

    @Override
    public void onEquip(ItemStack itemStack, LivingEntity entity) {
        if(entity instanceof Player)
        {
            entity.sendMessage(new TextComponent("Equipped"),entity.getUUID());
        }
    }

    @Override
    public void onUnequip(LivingEntity entity) {
        if(entity instanceof Player)
        {
            entity.sendMessage(new TextComponent("Unequipped"),entity.getUUID());
        }
    }
}
