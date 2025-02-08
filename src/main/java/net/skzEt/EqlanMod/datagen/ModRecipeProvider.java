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
    private static final List<ItemLike> STINT_SMELTABLES = List.of(
            ModItems.STINTOCOIN.get()
    );
    private static final List<ItemLike> DUMPLING_SMELTABLES = List.of(
            ModItems.DUMPLING.get()
    );
    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        oreSmelting(consumer, TWITCH_SMELTABLES, RecipeCategory.MISC, ModItems.TWITCH_DIAMOND.get(), 0.1f, 200, "twitch");
        oreBlasting(consumer, TWITCH_SMELTABLES, RecipeCategory.MISC, ModItems.TWITCH_DIAMOND.get(), 0.1f, 100, "twitch");
        oreSmelting(consumer, STINT_SMELTABLES, RecipeCategory.MISC, ModItems.COIN_ALLOY.get(), 0f, 300, "stint");
        oreBlasting(consumer, STINT_SMELTABLES, RecipeCategory.MISC,ModItems.COIN_ALLOY.get(),0f, 150, "stint");
        oreSmelting(consumer, DUMPLING_SMELTABLES, RecipeCategory.MISC, ModItems.OVERCOOKED_DUMPLING.get(), 0f, 450, "dumpling");
        foodSmoking(consumer, DUMPLING_SMELTABLES, RecipeCategory.MISC, ModItems.OVERCOOKED_DUMPLING.get(), 0f, 200, "dumpling");
        foodCampfireCooking(consumer, DUMPLING_SMELTABLES, RecipeCategory.MISC, ModItems.OVERCOOKED_DUMPLING.get(), 0f, 600, "dumpling");
        // Twitch Block
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TWITCH_BLOCK.get())
                .pattern("TTT")
                .pattern("TTT")
                .pattern("TTT")
                .define('T', ModItems.TWITCH_DIAMOND.get())
                .unlockedBy(getHasName(ModItems.TWITCH_DIAMOND.get()), has(ModItems.TWITCH_DIAMOND.get()))
                .save(consumer);
        // Twitch Diamond
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.TWITCH_DIAMOND.get(), 9)
                .requires(ModBlocks.TWITCH_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.TWITCH_BLOCK.get()), has(ModBlocks.TWITCH_BLOCK.get()))
                .save(consumer);
        // Dumpling
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DUMPLING.get())
                .pattern(" W ")
                .pattern("WHW")
                .pattern(" W ")
                .define('W', Items.WHEAT)
                .define('H', ModItems.TWITCH_HEART.get())
                .unlockedBy(getHasName(ModItems.TWITCH_HEART.get()), has(ModItems.TWITCH_HEART.get()))
                .save(consumer);
        // School Boot
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.SCHOOL_BOOT.get())
                .pattern("KKK")
                .pattern("KBK")
                .pattern("KKK")
                .define('K', Items.DRIED_KELP)
                .define('B', Items.BLACK_DYE)
                .unlockedBy(getHasName(Items.DRIED_KELP), has(Items.DRIED_KELP))
                .save(consumer);
        // Twitch Heart
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.TWITCH_HEART.get())
                .pattern( " T ")
                .pattern("TGT")
                .pattern(" T ")
                .define('T', ModItems.TWITCH_DIAMOND.get())
                .define('G', Items.GOLD_INGOT)
                .unlockedBy(getHasName(ModItems.TWITCH_DIAMOND.get()), has(ModItems.TWITCH_DIAMOND.get()))
                .save(consumer);
        // Stint-o-Coin
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STINTOCOIN.get())
                .pattern(" G ")
                .pattern("GHG")
                .pattern(" G ")
                .define('G', Items.GOLD_NUGGET)
                .define('H', ModItems.TWITCH_HEART.get())
                .unlockedBy(getHasName(ModItems.TWITCH_HEART.get()), has(ModItems.TWITCH_HEART.get()))
                .save(consumer);
        // Drake Pendant
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DRAKE_PENDANT.get())
                .pattern(" T ")
                .pattern("DHD")
                .pattern(" T ")
                .define('T', ModItems.TWITCH_DIAMOND.get())
                .define('D', Items.DIAMOND)
                .define('H', ModItems.TWITCH_HEART.get())
                .unlockedBy(getHasName(ModItems.TWITCH_HEART.get()), has(ModItems.TWITCH_HEART.get()))
                .save(consumer);
        // Glasses
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GLASSES.get())
                .pattern("C C")
                .pattern("GCG")
                .define('C', Items.COAL)
                .define('G', Items.GLASS)
                .unlockedBy(getHasName(Items.COAL), has(ModItems.TWITCH_HEART.get()))
                .save(consumer);
        // Dumpling Sun
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.DUMPLING_SUN.get())
                .pattern("D")
                .pattern("G")
                .define('D', ModItems.DUMPLING.get())
                .define('G', ModItems.GLASSES.get())
                .unlockedBy(getHasName(ModItems.DUMPLING.get()), has(ModItems.DUMPLING.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.STINT_HELMET.get())
                .pattern("CSC")
                .pattern("C C")
                .define('C', ModItems.COIN_ALLOY.get())
                .define('S', ModItems.STINTOCOIN.get())
                .unlockedBy(getHasName(ModItems.STINTOCOIN.get()), has(ModItems.STINTOCOIN.get()))
                .save(consumer);

    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void foodSmoking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory,ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMOKING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smoking");
    }
    protected static void foodCampfireCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory,ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.CAMPFIRE_COOKING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_campfire_cooking");
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
