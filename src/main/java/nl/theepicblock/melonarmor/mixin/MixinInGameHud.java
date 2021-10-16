package nl.theepicblock.melonarmor.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import nl.theepicblock.melonarmor.MelonArmor;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class MixinInGameHud {
    @Shadow @Final private MinecraftClient client;

    @Shadow protected abstract void renderOverlay(Identifier texture, float opacity);

    @Inject(method = "render", at = @At(value = "INVOKE", ordinal = 0, target = "Lnet/minecraft/client/network/ClientPlayerEntity;getInventory()Lnet/minecraft/entity/player/PlayerInventory;"))
    private void inject(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        var helmet = this.client.player.getInventory().getArmorStack(3);
        if (helmet.getItem() == MelonArmor.MELON_HELMET) {
            this.renderOverlay(MelonArmor.MELON_OVERLAY, 1.0f);
        }
    }
}
