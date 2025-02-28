package overcooked_orange.frogged.frog;

import net.fabricmc.fabric.api.event.player.UseEntityCallback;
import net.fabricmc.fabric.api.transfer.v1.transaction.Transaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.potion.PotionUtil;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import overcooked_orange.frogged.datagen.ModFrogTags;

public class VenomousFrogPoisonPotionHandler implements UseEntityCallback {
    @Override
    @SuppressWarnings("UnstableApiUsage")
    public ActionResult interact(PlayerEntity playerEntity, World world, Hand hand, Entity entity, @Nullable EntityHitResult entityHitResult) {
        if(world.isClient() || !(entity instanceof FrogEntity frogEntity) || playerEntity.isCreative() || !hand.equals(Hand.MAIN_HAND))
            return ActionResult.PASS;
        if(!Registries.FROG_VARIANT.getEntry(frogEntity.getVariant()).isIn(ModFrogTags.VENOMOUS))
            return ActionResult.PASS;
        if(!playerEntity.isHolding(Items.GLASS_BOTTLE))
            return ActionResult.PASS;

        try (Transaction t = Transaction.openOuter()) {
            if(playerEntity.giveItemStack(PotionUtil.setPotion(new ItemStack(Items.POTION), Potions.POISON))) {
                playerEntity.getStackInHand(hand).decrement(1);
                ((ServerWorld) world).spawnParticles(ParticleTypes.CRIT, entity.getX(), entity.getY(), entity.getZ(), 2, 0, 0, 0, 1);
                t.commit();
                return ActionResult.SUCCESS;
            } else {
                t.abort();
            }
        }

        return ActionResult.PASS;
    }
}
