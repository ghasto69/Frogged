package overcooked_orange.frogged.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import overcooked_orange.frogged.Frogged;
import overcooked_orange.frogged.registry.ModFrogs;

import java.util.concurrent.CompletableFuture;

public class ModFrogTags extends FabricTagProvider<FrogVariant> {
    public ModFrogTags(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.FROG_VARIANT, registriesFuture);
    }

    public static final TagKey<FrogVariant> VENOMOUS = TagKey.of(RegistryKeys.FROG_VARIANT, Frogged.id("venomous"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup provider) {
        getOrCreateTagBuilder(VENOMOUS)
                .add(ModFrogs.BLUE_POISON_DART_FROG)
                .add(ModFrogs.GOLDEN_POISON_DART_FROG)
                .add(ModFrogs.VARIEGATED_POISON_DART_FROG);
    }
}
