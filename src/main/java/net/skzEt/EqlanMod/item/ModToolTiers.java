package net.skzEt.EqlanMod.item;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.skzEt.EqlanMod.Eqlan;
import net.skzEt.EqlanMod.util.ModTags;

import java.util.List;

public class ModToolTiers {
    public static final Tier TWITCH = TierSortingRegistry.registerTier(
            new ForgeTier(5, 1500, 5f, 4f, 25,
                    ModTags.Blocks.NEEDS_TWITCH_TOOLS, () -> Ingredient.of(ModItems.TWITCH_DIAMOND.get())),
            new ResourceLocation(Eqlan.MOD_ID, "twitch"), List.of(Tiers.NETHERITE), List.of());
}
