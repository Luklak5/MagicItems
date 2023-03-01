package com.luklak.magicitems.datagen;

import com.luklak.magicitems.setup.Registration;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;

import java.util.function.Consumer;

public class MagRecipes extends RecipeProvider {

    public MagRecipes(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

        ShapelessRecipeBuilder.shapeless(Registration.AZURITE_INGOT.get(), 9)
                .requires(Registration.AZURITE_BLOCK_ITEM.get())
                .unlockedBy("has_azurite_block", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Registration.AZURITE_BLOCK_ITEM.get()).build()))
                .group("magicitems")
                .save(consumer, "azurite_ingot1");

        ShapelessRecipeBuilder.shapeless(Registration.AZURITE_NUGGET.get(), 9)
                .requires(Registration.AZURITE_INGOT.get())
                .unlockedBy("has_azurite_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Registration.AZURITE_INGOT.get()).build()))
                .group("magicitems")
                .save(consumer, "azurite_nugget1");

        ShapedRecipeBuilder.shaped(Registration.AZURITE_BLOCK_ITEM.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Registration.AZURITE_INGOT.get())
                .unlockedBy("has_azurite_ingot", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Registration.AZURITE_INGOT.get()).build()))
                .group("magicitems")
                .save(consumer, "azurite_block1");

        ShapedRecipeBuilder.shaped(Registration.AZURITE_INGOT.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Registration.AZURITE_NUGGET.get())
                .unlockedBy("has_azurite_nugget", inventoryTrigger(ItemPredicate.Builder.item()
                        .of(Registration.AZURITE_NUGGET.get()).build()))
                .group("magicitems")
                .save(consumer, "azurite_ingot2");
    }
}
