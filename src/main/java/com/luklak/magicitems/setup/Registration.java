package com.luklak.magicitems.setup;

import com.luklak.magicitems.armor.ModArmor;
import com.luklak.magicitems.armor.ModArmorMaterial;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static com.luklak.magicitems.Magicitems.MODID;

public class Registration {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static void init()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
    }

    public static final BlockBehaviour.Properties BLOCK_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops();
    public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);

    public static final RegistryObject<Block> AZURITE_BLOCK = BLOCKS.register("azurite_block", () -> new Block(BLOCK_PROPERTIES));
    public static final RegistryObject<Item> AZURITE_BLOCK_ITEM = fromBlock(AZURITE_BLOCK);

    public static final RegistryObject<Item> AZURITE_INGOT = ITEMS.register("azurite_ingot", () -> new Item(ITEM_PROPERTIES));
    public static final RegistryObject<Item> AZURITE_NUGGET = ITEMS.register("azurite_nugget", () -> new Item(ITEM_PROPERTIES));

    public static final RegistryObject<Item> AZURITE_HELMET = ITEMS.register("azurite_helmet", () -> new ModArmor(ModArmorMaterial.AZURITE, EquipmentSlot.HEAD, new Item.Properties().tab(ModSetup.ITEM_GROUP)));
    public static final RegistryObject<Item> AZURITE_CHESTPLATE = ITEMS.register("azurite_chestplate", () -> new ModArmor(ModArmorMaterial.AZURITE, EquipmentSlot.CHEST, new Item.Properties().tab(ModSetup.ITEM_GROUP)));
    public static final RegistryObject<Item> AZURITE_LEGGINGS = ITEMS.register("azurite_leggings", () -> new ModArmor(ModArmorMaterial.AZURITE, EquipmentSlot.LEGS, new Item.Properties().tab(ModSetup.ITEM_GROUP)));
    public static final RegistryObject<Item> AZURITE_BOOTS = ITEMS.register("azurite_boots", () -> new ModArmor(ModArmorMaterial.AZURITE, EquipmentSlot.FEET, new Item.Properties().tab(ModSetup.ITEM_GROUP)));

    public static final TagKey<Item> EQUIPMENT = TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation(MODID, "equipment"));

    public static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
        return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
    }
}
