package overcooked_orange.frogged.frog;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import overcooked_orange.frogged.datagen.ModFrogTags;

public class VenomousFrogAttackHandler implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult entityHitResult) {
        if(world instanceof ServerWorld && entity instanceof FrogEntity frog) {
            if(frog.getVariant().isIn(ModFrogTags.VENOMOUS)) {
                player.addStatusEffect(new StatusEffectInstance(StatusEffects.POISON, 300));
            }
        }
        return ActionResult.PASS;
    }
}
