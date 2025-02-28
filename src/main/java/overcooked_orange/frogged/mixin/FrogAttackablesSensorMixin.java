package overcooked_orange.frogged.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.sensor.FrogAttackablesSensor;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import overcooked_orange.frogged.datagen.ModFrogTags;

@Mixin(FrogAttackablesSensor.class)
public abstract class FrogAttackablesSensorMixin {
    @ModifyExpressionValue(
            method = "matches",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/FrogEntity;isValidFrogFood(Lnet/minecraft/entity/LivingEntity;)Z")
    )
    private boolean mevIsMatchingEntity(boolean original, ServerWorld world, LivingEntity entity, LivingEntity target) {
        return (entity instanceof FrogEntity frog && frog.getVariant().isIn(ModFrogTags.VENOMOUS) && target instanceof PlayerEntity player && player.getHealth() > 1) || original;
    }
}
