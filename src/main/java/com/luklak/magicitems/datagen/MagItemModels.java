package com.luklak.magicitems.datagen;

import com.luklak.magicitems.Magicitems;
import com.luklak.magicitems.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class MagItemModels extends ItemModelProvider {

    public MagItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Magicitems.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(Registration.AZURITE_BLOCK_ITEM.get().getRegistryName().getPath(), modLoc("block/azurite_block"));

        singleTexture(Registration.AZURITE_INGOT.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0", modLoc("item/azurite_ingot"));
        singleTexture(Registration.AZURITE_NUGGET.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0", modLoc("item/azurite_nugget"));

        singleTexture(Registration.AZURITE_BOOTS.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0", modLoc("item/azurite_boots"));
        singleTexture(Registration.AZURITE_LEGGINGS.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0", modLoc("item/azurite_leggings"));
        singleTexture(Registration.AZURITE_CHESTPLATE.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0", modLoc("item/azurite_chestplate"));
        singleTexture(Registration.AZURITE_HELMET.get().getRegistryName().getPath(), mcLoc("item/generated"),
                "layer0", modLoc("item/azurite_helmet"));
    }
}
