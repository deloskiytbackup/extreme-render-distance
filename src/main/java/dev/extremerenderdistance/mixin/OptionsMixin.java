package dev.extremerenderdistance.mixin;

import net.minecraft.client.OptionInstance;
import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Options.class)
public abstract class OptionsMixin {
    @Redirect(
        method = "<init>",
        at = @At(
            value = "NEW",
            target = "(IIZ)Lnet/minecraft/client/OptionInstance$IntRange;"
        )
    )
    private OptionInstance.IntRange uncapVanillaRenderDistance(int min, int max, boolean applyValueImmediately) {
        if (min == 2 && max == 32) {
            return new OptionInstance.IntRange(min, 128, applyValueImmediately);
        }
        return new OptionInstance.IntRange(min, max, applyValueImmediately);
    }
}
