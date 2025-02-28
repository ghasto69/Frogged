package overcooked_orange.frogged.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import overcooked_orange.frogged.Frogged;

import java.util.concurrent.CompletableFuture;

public class ModBiomeTags extends FabricTagProvider<Biome> {
    public ModBiomeTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BIOME, registriesFuture);
    }

    public static final TagKey<Biome> SPAWNS_POISON_DART_FROGS = TagKey.of(RegistryKeys.BIOME, Frogged.id("spawns_poison_dart_frogs"));
    public static final TagKey<Biome> SPAWNS_SANDY_FROGS = TagKey.of(RegistryKeys.BIOME, Frogged.id("spawns_sandy_frogs"));
    public static final TagKey<Biome> SPAWNS_SCULK_FROGS = TagKey.of(RegistryKeys.BIOME, Frogged.id("spawns_sculk_frogs"));

    public static final TagKey<Biome> HAS_POISON_DART_FROGS = TagKey.of(RegistryKeys.BIOME, Frogged.id("has_poison_dart_frogs"));
    public static final TagKey<Biome> HAS_SANDY_FROGS = TagKey.of(RegistryKeys.BIOME, Frogged.id("has_sandy_frogs"));
    public static final TagKey<Biome> HAS_SCULK_FROGS = TagKey.of(RegistryKeys.BIOME, Frogged.id("has_sculk_frogs"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(SPAWNS_POISON_DART_FROGS)
                .forceAddTag(ConventionalBiomeTags.IS_JUNGLE);
        getOrCreateTagBuilder(SPAWNS_SANDY_FROGS)
                .forceAddTag(ConventionalBiomeTags.IS_BEACH);
        getOrCreateTagBuilder(SPAWNS_SCULK_FROGS);

        getOrCreateTagBuilder(HAS_POISON_DART_FROGS)
                .forceAddTag(SPAWNS_POISON_DART_FROGS);
        getOrCreateTagBuilder(HAS_SANDY_FROGS)
                .forceAddTag(ConventionalBiomeTags.IS_DESERT)
                .forceAddTag(ConventionalBiomeTags.IS_BADLANDS)
                .forceAddTag(SPAWNS_SANDY_FROGS);
        getOrCreateTagBuilder(HAS_SCULK_FROGS)
                .add(BiomeKeys.DEEP_DARK);
    }
}
