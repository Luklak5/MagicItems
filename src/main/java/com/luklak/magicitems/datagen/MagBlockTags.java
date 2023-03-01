package com.luklak.magicitems.datagen;

import com.luklak.magicitems.Magicitems;
import com.luklak.magicitems.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MagBlockTags extends BlockTagsProvider
{
    public MagBlockTags(DataGenerator generator, ExistingFileHelper helper)
    {
        super(generator, Magicitems.MODID, helper);
    }

    @Override
    protected void addTags()
    {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(Registration.AZURITE_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(Registration.AZURITE_BLOCK.get());

        tag(BlockTags.BEACON_BASE_BLOCKS)
                .add(Registration.AZURITE_BLOCK.get());

    }
}
