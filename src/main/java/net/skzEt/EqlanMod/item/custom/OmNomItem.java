package net.skzEt.EqlanMod.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.skzEt.EqlanMod.sound.ModSounds;
import net.skzEt.EqlanMod.util.ModTags;

public class OmNomItem extends Item {
    public OmNomItem(Properties pProperties) {
        super(pProperties);
    }
    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if (!pContext.getLevel().isClientSide) {
            BlockPos blockPos = pContext.getClickedPos();
            Level level = pContext.getLevel();
            BlockState state = pContext.getLevel().getBlockState(blockPos);

            if (!isValuableBlock(state)) {
                pContext.getLevel().playSeededSound(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(),
                        ModSounds.OM_NOM_USED.get(), SoundSource.BLOCKS, 1f, 1f, 0);
                level.destroyBlock(blockPos, false);
            } else if (isOreBlock(state)) {
                pContext.getLevel().playSeededSound(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(),
                        ModSounds.OM_NOM_USED.get(), SoundSource.BLOCKS, 1f, 1f, 0);
                level.destroyBlock(blockPos, true);
            } else {
                pContext.getLevel().playSeededSound(null, blockPos.getX(), blockPos.getY(), blockPos.getZ(),
                        ModSounds.OM_NOM_EXPLODED.get(), SoundSource.BLOCKS, 1f, 1f, 0);
                pContext.getPlayer().addEffect(new MobEffectInstance(MobEffects.HARM, 10, 100));
                pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                        player -> player.broadcastBreakEvent(player.getUsedItemHand()));
            }

        }
        return InteractionResult.SUCCESS;
    }
    private boolean isValuableBlock(BlockState state) {
        return state.is(ModTags.Blocks.OM_NOM_VALUABLES);
    }
    private boolean isOreBlock(BlockState state) {
        return state.is(ModTags.Blocks.OM_NOM_ORE);
    }
}
