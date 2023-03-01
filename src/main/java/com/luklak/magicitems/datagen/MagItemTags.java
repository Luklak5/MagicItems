package com.luklak.magicitems.datagen;

import com.luklak.magicitems.Magicitems;
import com.luklak.magicitems.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MagItemTags extends ItemTagsProvider
{

    public MagItemTags(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper)
    {
        super(generator, blockTags, Magicitems.MODID, helper);
    }

    @Override
    protected void addTags()
    {
        tag(Registration.EQUIPMENT)
                .add(Registration.AZURITE_BOOTS.get())
                .add(Registration.AZURITE_LEGGINGS.get())
                .add(Registration.AZURITE_CHESTPLATE.get())
                .add(Registration.AZURITE_HELMET.get());

        tag(Tags.Items.INGOTS)
                .add(Registration.AZURITE_INGOT.get());

        tag(Tags.Items.NUGGETS)
                .add(Registration.AZURITE_NUGGET.get());

    }
}
