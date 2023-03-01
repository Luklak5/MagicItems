package com.luklak.magicitems.datagen;

import com.luklak.magicitems.Magicitems;
import com.luklak.magicitems.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MagBlockStates extends BlockStateProvider {

    public MagBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, Magicitems.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(Registration.AZURITE_BLOCK.get());
    }
}
