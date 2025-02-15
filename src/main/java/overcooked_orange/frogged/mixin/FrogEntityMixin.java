package overcooked_orange.frogged.mixin;

import net.fabricmc.fabric.api.tag.convention.v1.ConventionalBiomeTags;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.FrogEntity;
import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import overcooked_orange.frogged.datagen.ModBiomeTags;
import overcooked_orange.frogged.registry.ModFrogs;

import java.util.random.RandomGenerator;

@Mixin(FrogEntity.class)
public abstract class FrogEntityMixin extends AnimalEntity {
    @Shadow public abstract void setVariant(FrogVariant variant);

    protected FrogEntityMixin(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(
            method = "initialize",
            at = @At("TAIL")
    )
    private void variant(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData, NbtCompound entityNbt, CallbackInfoReturnable<EntityData> cir) {
        RegistryEntry<Biome> biome = world.getBiome(this.getBlockPos());
        if (biome.isIn(ModBiomeTags.HAS_POISON_DART_FROGS)) {
            this.setVariant(world.getRandom().nextBoolean() ? ModFrogs.GOLDEN_POISON_DART_FROG : ModFrogs.BLUE_POISON_DART_FROG);
        }
        if(biome.isIn(ModBiomeTags.HAS_SANDY_FROGS)) {
            this.setVariant(ModFrogs.SANDY_FROG);
        }
    }
}
