package net.skzEt.EqlanMod.item;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.RecordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.skzEt.EqlanMod.Eqlan;
import net.skzEt.EqlanMod.item.custom.CactusPlushItem;
import net.skzEt.EqlanMod.item.custom.FuelItem;
import net.skzEt.EqlanMod.item.custom.OmNomItem;
import net.skzEt.EqlanMod.sound.ModSounds;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Eqlan.MOD_ID);
    // Custom Items
    public static final RegistryObject<Item> OM_NOM = ITEMS.register("om_nom",
            () -> new OmNomItem(new Item.Properties().durability(600)));
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
    public static final RegistryObject<Item> MZLFF_MICROPHONE = ITEMS.register("mzlff_microphone",
            () -> new Item(new Item.Properties()));
    // Default Items
    public static final RegistryObject<Item> TWITCH_DIAMOND = ITEMS.register("twitch_diamond",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> SCHOOL_BOOT = ITEMS.register("school_boot",
            () -> new FuelItem(new Item.Properties(), 400));
    public static final RegistryObject<Item> TWITCH_HEART = ITEMS.register("twitch_heart",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COIN_ALLOY = ITEMS.register("coin_alloy",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> EBLAN_ALLOY = ITEMS.register("eqlan_alloy",
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
    // Music Disk
    // Чтобы получить длину музыку берешь секунды всей музыки и умножаешь на 20
    public static final RegistryObject<Item> BASELINE_BUSINESS_DISK = ITEMS.register("baseline_business_disk",
            () -> new RecordItem(6, ModSounds.BASELINE_BUSINESS, new Item.Properties().stacksTo(1), 2260));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
