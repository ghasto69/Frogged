package overcooked_orange.frogged.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.NotNull;
import overcooked_orange.frogged.Frogged;

import java.util.concurrent.CompletableFuture;

public abstract class FroggedDynamicRegistryProvider<T> extends FabricDynamicRegistryProvider {
    private final RegistryKey<Registry<T>> registry;

    public FroggedDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, RegistryKey<Registry<T>> registry) {
        super(output, registriesFuture);
        this.registry = registry;
    }

    public static <T> RegistryKey<T> key(String id, RegistryKey<Registry<T>> registry) {
        return RegistryKey.of(registry, Frogged.id(id));
    }

    @Override
    public @NotNull String getName() {
        return "Dynamic Registry: " + this.registry.getValue().getPath();
    }
}
