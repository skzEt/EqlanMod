package net.skzEt.EqlanMod.item;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.skzEt.EqlanMod.Eqlan;

import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    GLASSES("glasses", 26, new int[]{0, 3, 2, 1}, 25,
            SoundEvents.ARMOR_EQUIP_ELYTRA, 0f, 0f, () -> Ingredient.of(ModItems.SCHOOL_BOOT.get())),
    PENDANT("pendant", 26, new int[]{0, 6, 0, 0}, 25,
            SoundEvents.ARMOR_STAND_PLACE, 1f, 0f, () -> Ingredient.of(ModItems.TWITCH_DIAMOND.get())),
    STINT("stint", 26, new int[]{8, 0, 0, 0}, 25,
            SoundEvents.ANVIL_PLACE, 0.5f, 0f, () -> Ingredient.of(ModItems.COIN_ALLOY.get())),
    BOXERS("boxers", 26, new int[]{0, 0, 6, 0}, 25,
    SoundEvents.ARMOR_EQUIP_GOLD, 0.1f, 0.2f, () -> Ingredient.of(ModItems.SCHOOL_BOOT.get()));
    private final String name;
    private final int durabilityMultiplier;
    private final int[] protectionAmounts;
    private final int enchantmentValue;
    private final SoundEvent equipSound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    private static final int[] BASE_DURABILITY = { 11, 16, 16, 13 };

    ModArmorMaterials(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantmentValue = enchantmentValue;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredient = repairIngredient;
    }


    @Override
    public int getDurabilityForType(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForType(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public String getName() {
        return Eqlan.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
