package net.skzEt.EqlanMod.item;

import jdk.jfr.Registered;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.skzEt.EqlanMod.Eqlan;
import net.skzEt.EqlanMod.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Eqlan.MOD_ID);

    public static final RegistryObject<CreativeModeTab> EQLAN_TAB = CREATIVE_MODE_TABS.register("eqlan_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TWITCH_DIAMOND.get()))
                    .title(Component.translatable("creativetab.eqlan_tab"))
                    .displayItems((itemDisplayParameters, output) -> {

                        // Blocks
                       output.accept(ModBlocks.TWITCH_BLOCK.get());
                       output.accept(ModBlocks.TWITCH_ORE.get());
                        // Items
                        output.accept(ModItems.TWITCH_DIAMOND.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}


