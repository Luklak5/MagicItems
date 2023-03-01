package com.luklak.magicitems.datagen;

import com.luklak.magicitems.Magicitems;
import com.luklak.magicitems.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.luklak.magicitems.setup.ModSetup.TAB_NAME;

public class MagLanguageProvider extends LanguageProvider {

    public MagLanguageProvider(DataGenerator gen, String locale) {
        super(gen, Magicitems.MODID, locale);
    }

    @Override
    protected void addTranslations() {
        add("itemGroup." + TAB_NAME, "Magic Items");

        add(Registration.AZURITE_HELMET.get(), "Azurite Helmet");
        add(Registration.AZURITE_BOOTS.get(), "Azurite Boots");
        add(Registration.AZURITE_CHESTPLATE.get(), "Azurite Chestplate");
        add(Registration.AZURITE_LEGGINGS.get(), "Azurite Leggings");

        add(Registration.AZURITE_BLOCK.get(), "Azurite Block");
        add(Registration.AZURITE_INGOT.get(), "Azurite Ingot");
        add(Registration.AZURITE_NUGGET.get(), "Azurite Nugget");
    }
}
