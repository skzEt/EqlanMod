package net.skzEt.EqlanMod.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.skzEt.EqlanMod.Eqlan;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> OM_NOM_VALUABLES = tag("om_nom_valuables");
        public static final TagKey<Block> OM_NOM_ORE = tag("om_nom_ore");
        public static final TagKey<Block> NEEDS_TWITCH_TOOLS = tag("needs_twitch_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(Eqlan.MOD_ID, name));
        }
    }
    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(new ResourceLocation(Eqlan.MOD_ID, name));
        }
    }
}
