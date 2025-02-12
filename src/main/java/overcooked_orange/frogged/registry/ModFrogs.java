package overcooked_orange.frogged.registry;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.entity.spawn.BiomeSpawnCondition;
import net.minecraft.entity.spawn.SpawnConditionSelectors;
import net.minecraft.registry.*;
import net.minecraft.util.AssetInfo;
import net.minecraft.world.biome.Biome;
import overcooked_orange.frogged.Frogged;
import overcooked_orange.frogged.datagen.FroggedDynamicRegistryProvider;

import java.util.concurrent.CompletableFuture;

public class ModFrogs extends FroggedDynamicRegistryProvider<FrogVariant> {
    public ModFrogs(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture, RegistryKeys.FROG_VARIANT);
    }

    public static final RegistryKey<FrogVariant> GOLDEN_POISON_DART_FROG = RegistryKey.of(RegistryKeys.FROG_VARIANT, Frogged.id("golden_poison_dart_frog"));
    public static final RegistryKey<FrogVariant> BLUE_POISON_DART_FROG = RegistryKey.of(RegistryKeys.FROG_VARIANT, Frogged.id("blue_poison_dart_frog"));

    public static void generate(Registerable<FrogVariant> context) {
        RegistryEntryLookup<Biome> biomes = context.getRegistryLookup(RegistryKeys.BIOME);

        context.register(GOLDEN_POISON_DART_FROG, frog(GOLDEN_POISON_DART_FROG, SpawnConditionSelectors.createSingle(
                new BiomeSpawnCondition(biomes.getOrThrow(ConventionalBiomeTags.IS_JUNGLE)),
                1
        )));

        context.register(BLUE_POISON_DART_FROG, frog(BLUE_POISON_DART_FROG, SpawnConditionSelectors.createSingle(
                new BiomeSpawnCondition(biomes.getOrThrow(ConventionalBiomeTags.IS_JUNGLE)),
                1
        )));
    }

    private static FrogVariant frog(RegistryKey<FrogVariant> key, SpawnConditionSelectors spawnConditionSelectors) {
        return new FrogVariant(
                new AssetInfo(Frogged.id("entity/frog/" + key.getValue().getPath())),
                spawnConditionSelectors
        );
    }
}
