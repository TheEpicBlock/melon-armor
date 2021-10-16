package nl.theepicblock.melonarmor.mixin;

import com.google.common.collect.Iterators;
import eu.ha3.presencefootsteps.world.Association;
import eu.ha3.presencefootsteps.world.PFSolver;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import nl.theepicblock.melonarmor.MelonArmor;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(PFSolver.class)
public class MixinPresenceFootsteps {
    @Unique private Entity player;

    @Inject(method = "findAssociation(Lnet/minecraft/entity/Entity;Lnet/minecraft/util/math/BlockPos;)Leu/ha3/presencefootsteps/world/Association;", at = @At("HEAD"))
    private void catchPlayer(Entity player, BlockPos pos, CallbackInfoReturnable<Association> cir) {
        this.player = player;

    }

    @Redirect(method = "findAssociation(Lnet/minecraft/world/World;Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/util/math/Box;)Leu/ha3/presencefootsteps/world/Association;", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/World;getBlockState(Lnet/minecraft/util/math/BlockPos;)Lnet/minecraft/block/BlockState;"))
    private BlockState changeBlockStateToMelons(World world, BlockPos pos) {
        if (Iterators.any(player.getArmorItems().iterator(), (v) -> v.getItem() == MelonArmor.MELON_BOOTS)) {
            return Blocks.MELON.getDefaultState();
        } else {
            return world.getBlockState(pos);
        }
    }
}
