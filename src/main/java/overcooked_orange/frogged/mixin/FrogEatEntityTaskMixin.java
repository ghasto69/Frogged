package overcooked_orange.frogged.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.brain.task.FrogEatEntityTask;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import overcooked_orange.frogged.datagen.ModFrogTags;

@Mixin(FrogEatEntityTask.class)
public abstract class FrogEatEntityTaskMixin {
    @ModifyExpressionValue(
            method = "shouldRun(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/FrogEntity;)Z",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/entity/passive/FrogEntity;isValidFrogFood(Lnet/minecraft/entity/LivingEntity;)Z")
    )
    private boolean mevCheckExtraStartConditions(boolean original, ServerWorld serverWorld, FrogEntity frog, @Local LivingEntity livingEntity) {
        return (
                frog.getVariant().isIn(ModFrogTags.VENOMOUS) &&
                livingEntity instanceof PlayerEntity player &&
                player.getHealth() > 1
        ) || original;
    }

    @Inject(
            method = "eat",
            at = @At("HEAD"),
            cancellable = true
    )
    private void poisonPlayer(ServerWorld serverWorld, FrogEntity frog, CallbackInfo callbackInfo) {
        if (frog.getVariant().isIn(ModFrogTags.VENOMOUS)) {
            frog.getFrogTarget().ifPresent(entity -> {
                if (entity instanceof PlayerEntity player && player.isAlive()) {
                    player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 300, 1));
                    callbackInfo.cancel();
                }
            });
        }
    }
}
