package net.skzEt.EqlanMod.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skzEt.EqlanMod.Eqlan;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Eqlan.MOD_ID);
    // Custom Items

    // Streamers
    public static final RegistryObject<Item> STINTOCOIN = ITEMS.register("stintocoin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRAKE = ITEMS.register("drake",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DUMPLING = ITEMS.register("dumpling",
            () -> new Item(new Item.Properties().food(ModFoods.DUMPLING)));
    public static final RegistryObject<Item> DUMPLING_SUN = ITEMS.register("dumpling_sun",
            () -> new Item(new Item.Properties().food(ModFoods.DUMPLING_SUN)));
    // Default Items
    public static final RegistryObject<Item> TWITCH_DIAMOND = ITEMS.register("twitch_diamond",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCHOOL_BOOT = ITEMS.register("school_boot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> TWITCH_HEART = ITEMS.register("twitch_heart",
            () -> new Item(new Item.Properties()));
    // Armor
    public static final RegistryObject<Item> GLASSES = ITEMS.register("glasses",
            () -> new ArmorItem(ModArmorMaterials.GLASSES, ArmorItem.Type.HELMET, new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
