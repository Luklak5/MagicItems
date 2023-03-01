package com.luklak.magicitems.other;

import net.minecraft.ChatFormatting;

public enum MagicRarity {
    COMMON(0, ChatFormatting.WHITE, 0),
    UNCOMMON(1, ChatFormatting.GREEN, 2),
    RARE(2, ChatFormatting.BLUE, 4),
    EPIC(3, ChatFormatting.LIGHT_PURPLE, 6);

    private final int rarityId;
    private final ChatFormatting color;
    private final int maxAttributes;

    MagicRarity(int rarityId, ChatFormatting color, int maxAttributes) {
        this.rarityId = rarityId;
        this.color = color;
        this.maxAttributes = maxAttributes;
    }

    public static MagicRarity rarityLookup(int value)
    {
        for(MagicRarity rarity : MagicRarity.values())
        {
            if(rarity.getRarityId() == value)
            {
                return rarity;
            }
        }
        return MagicRarity.COMMON;
    }

    public int getRarityId() {
        return rarityId;
    }

    public ChatFormatting getColor() {
        return color;
    }

    public int getMaxAttributes() {
        return maxAttributes;
    }
}
