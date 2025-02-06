package net.skzEt.EqlanMod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.skzEt.EqlanMod.Eqlan;
import net.skzEt.EqlanMod.block.ModBlocks;
import net.skzEt.EqlanMod.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> TWITCH_SMELTABLES = List.of(
            ModBlocks.TWITCH_ORE.get()
    );
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, TWITCH_SMELTABLES, RecipeCategory.MISC, ModItems.TWITCH_DIAMOND.get(), 0.1f, 200, "twitch");
        oreBlasting(consumer, TWITCH_SMELTABLES, RecipeCategory.MISC, ModItems.TWITCH_DIAMOND.get(), 0.1f, 100, "twitch");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TWITCH_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TWITCH_DIAMOND.get())
                .unlockedBy(getHasName(ModItems.TWITCH_DIAMOND.get()), has(ModItems.TWITCH_DIAMOND.get()))
                .save(consumer);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TWITCH_DIAMOND.get(), 9)
                .requires(ModBlocks.TWITCH_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TWITCH_BLOCK.get()), has(ModBlocks.TWITCH_BLOCK.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DUMPLING.get())
                .pattern(" W ")
                .pattern("WHW")
                .pattern(" W ")
                .define('W', Items.WHEAT)
                .define('H', ModItems.TWITCH_HEART.get())
                .unlockedBy(getHasName(ModItems.TWITCH_HEART.get()), has(ModItems.TWITCH_HEART.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SCHOOL_BOOT.get())
                .pattern("KKK")
                .pattern("KBK")
                .pattern("KKK")
                .define('K', Items.DRIED_KELP)
                .define('B', Items.BLACK_DYE)
                .unlockedBy(getHasName(Items.DRIED_KELP), has(Items.DRIED_KELP))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TWITCH_HEART.get())
                .pattern( " T ")
                .pattern("TGT")
                .pattern(" T ")
                .define('T', ModItems.TWITCH_DIAMOND.get())
                .define('G', Items.GOLD_INGOT)
                .unlockedBy(getHasName(ModItems.TWITCH_DIAMOND.get()), has(ModItems.TWITCH_DIAMOND.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STINTOCOIN.get())
                .pattern(" G ")
                .pattern("GHG")
                .pattern(" G ")
                .define('G', Items.GOLD_INGOT)
                .define('H', ModItems.TWITCH_HEART.get())
                .unlockedBy(getHasName(ModItems.TWITCH_HEART.get()), has(ModItems.TWITCH_HEART.get()))
                .save(consumer);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(new ItemLike[]{itemlike}), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Eqlan.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }

    }
}
