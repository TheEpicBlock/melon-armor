package nl.theepicblock.melonarmor.mixin;

import com.google.common.collect.Iterators;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MelonBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldEvents;
import nl.theepicblock.melonarmor.MelonArmor;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MelonBlock.class)
public abstract class MixinMelonBlock extends Block{
    public MixinMelonBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float fallDistance) {
        if (Iterators.any(entity.getArmorItems().iterator(), (v) -> v.getItem() == MelonArmor.MELON_BOOTS)) {
            entity.handleFallDamage(fallDistance, 0.0F, DamageSource.FALL);
            world.syncWorldEvent(WorldEvents.BLOCK_BROKEN, pos, Block.getRawIdFromState(state));
        } else {
            super.onLandedUpon(world, state, pos, entity, fallDistance);
        }
    }
}
