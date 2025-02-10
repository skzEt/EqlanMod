package net.skzEt.EqlanMod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemConditionType;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import net.skzEt.EqlanMod.Eqlan;
import net.skzEt.EqlanMod.item.ModItems;
import net.skzEt.EqlanMod.loot.AddItemModifier;
import net.skzEt.EqlanMod.loot.AddSusSandItemModifier;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, Eqlan.MOD_ID);
    }

    @Override
    protected void start() {
        add("larva_from_dirt", new AddItemModifier(new LootItemCondition[]{
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DIRT).build(),
                LootItemRandomChanceCondition.randomChance(0.1f).build()}, ModItems.LARVA.get()));

        add("coin_alloy_from_suspicous_sand", new AddSusSandItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaelogy/desert_pyramid")).build()}, ModItems.COIN_ALLOY.get()));

        add("om_nom_from_desert_pyramid", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/desert_pyramid")).build()}, ModItems.OM_NOM.get()));
    }
}
