package net.skzEt.EqlanMod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties DUMPLING = new FoodProperties.Builder().nutrition(3)
            .saturationMod(0.1f).effect(new MobEffectInstance(MobEffects.DARKNESS, 200), 0.5f).build();
    public static final FoodProperties DUMPLING_SUN = new FoodProperties.Builder().nutrition(4)
            .saturationMod(0.1f).effect(new MobEffectInstance(MobEffects.REGENERATION, 300), 1f).build();

}
