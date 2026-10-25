package dev.extremerenderdistance.mixin;

import net.minecraft.server.level.ChunkMap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(ChunkMap.class)
public abstract class ChunkMapMixin {
    @ModifyConstant(
        method = "setServerViewDistance",
        constant = @Constant(intValue = 32)
    )
    private int uncapServerViewDistance(int value) {
        return 128;
    }
}
