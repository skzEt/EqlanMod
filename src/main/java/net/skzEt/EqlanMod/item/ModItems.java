package net.skzEt.EqlanMod.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skzEt.EqlanMod.Eqlan;
import net.skzEt.EqlanMod.item.custom.CactusPlushItem;
import net.skzEt.EqlanMod.item.custom.OmNomItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Eqlan.MOD_ID);
    // Custom Items
    public static final RegistryObject<Item> OM_NOM = ITEMS.register("om_nom",
            () -> new OmNomItem(new Item.Properties().durability(1)));
    public static final RegistryObject<Item> CACTUS_PLUSH = ITEMS.register("cactus_plush",
            () -> new CactusPlushItem(new Item.Properties().durability(100)));

    // Streamers
    public static final RegistryObject<Item> STINTOCOIN = ITEMS.register("stintocoin",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DRAKE_PENDANT = ITEMS.register("drake_pendant",
            () -> new ArmorItem(ModArmorMaterials.PENDANT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
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
    public static final RegistryObject<Item> COIN_ALLOY = ITEMS.register("coin_alloy",
            () -> new Item(new Item.Properties()));
    // Armor
    public static final RegistryObject<Item> GLASSES = ITEMS.register("glasses",
            () -> new ArmorItem(ModArmorMaterials.GLASSES, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> STINT_HELMET = ITEMS.register("stint_helmet",
            () -> new ArmorItem(ModArmorMaterials.STINT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BOXERS = ITEMS.register("boxers",
            () -> new ArmorItem(ModArmorMaterials.BOXERS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    // Food
    public static final RegistryObject<Item> OVERCOOKED_DUMPLING = ITEMS.register("overcooked_dumpling",
            () -> new Item(new Item.Properties().food(ModFoods.OVERCOOKED_DUMPLING)));
    public static final RegistryObject<Item> LARVA = ITEMS.register("larva",
            () -> new Item(new Item.Properties().food(ModFoods.LARVA)));
    public static final RegistryObject<Item> COOKED_LARVA = ITEMS.register("cooked_larva",
            () -> new Item(new Item.Properties().food(ModFoods.COOKED_LARVA)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
