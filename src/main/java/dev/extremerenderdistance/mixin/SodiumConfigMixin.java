package dev.extremerenderdistance.mixin;

import net.caffeinemc.mods.sodium.api.config.structure.IntegerOptionBuilder;
import net.caffeinemc.mods.sodium.client.gui.SodiumConfigBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value = SodiumConfigBuilder.class, remap = false)
public abstract class SodiumConfigMixin {
    @Redirect(
        method = "buildGeneralPage",
        at = @At(
            value = "INVOKE",
            target = "Lnet/caffeinemc/mods/sodium/api/config/structure/IntegerOptionBuilder;setRange(III)Lnet/caffeinemc/mods/sodium/api/config/structure/IntegerOptionBuilder;"
        )
    )
    private IntegerOptionBuilder uncapSodiumRenderDistance(IntegerOptionBuilder builder, int min, int max, int step) {
        if (min == 2 && max == 32) {
            return builder.setRange(min, 128, step);
        }
        return builder.setRange(min, max, step);
    }
}
