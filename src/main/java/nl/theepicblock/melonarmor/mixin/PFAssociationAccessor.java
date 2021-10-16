package nl.theepicblock.melonarmor.mixin;

import eu.ha3.presencefootsteps.world.Association;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Association.class)
public interface PFAssociationAccessor {
    @Accessor
    String getData();
}
