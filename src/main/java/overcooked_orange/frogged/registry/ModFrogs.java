package overcooked_orange.frogged.registry;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import overcooked_orange.frogged.Frogged;
import overcooked_orange.frogged.datagen.FroggedDynamicRegistryProvider;

import java.util.concurrent.CompletableFuture;

public class ModFrogs {
    public static final RegistryEntry<FrogVariant> GOLDEN_POISON_DART_FROG = frog("golden_poison_dart_frog");
    public static final RegistryEntry<FrogVariant> BLUE_POISON_DART_FROG = frog("blue_poison_dart_frog");

    private static RegistryEntry<FrogVariant> frog(String name) {
        return Registry.registerReference(Registries.FROG_VARIANT, Frogged.id(name), new FrogVariant(Frogged.id("textures/entity/frog/" + name + ".png")));
    }

    public static void registerFrogs() {}
}
