package overcooked_orange.frogged.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.CompletableFuture;

public abstract class FroggedDynamicRegistryProvider<T> extends FabricDynamicRegistryProvider {
    private final RegistryKey<Registry<T>> registry;

    public FroggedDynamicRegistryProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture, RegistryKey<Registry<T>> registry) {
        super(output, registriesFuture);
        this.registry = registry;
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup provider, Entries entries) {
        entries.addAll(provider.getOrThrow(this.registry));
    }

    @Override
    public @NotNull String getName() {
        return "Dynamic Registry: " + this.registry.getValue().getPath();
    }
}
