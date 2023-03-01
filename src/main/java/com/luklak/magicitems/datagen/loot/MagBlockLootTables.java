package com.luklak.magicitems.datagen.loot;

import com.luklak.magicitems.setup.Registration;
import net.minecraft.data.loot.BlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

public class MagBlockLootTables extends BlockLoot {

    @Override
    protected void addTables() {
        this.dropSelf(Registration.AZURITE_BLOCK.get());
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
