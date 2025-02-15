package overcooked_orange.frogged;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import overcooked_orange.frogged.datagen.*;

public class FroggedDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack generator = fabricDataGenerator.createPack();

        generator.addProvider(FroggedBlockLootTableProvider::new);
        generator.addProvider(ModFrogTags::new);
        generator.addProvider(ModBiomeTags::new);
        generator.addProvider(FroggedModelProvider::new);

        generator.addProvider(FroggedEnglishProvider::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
    }
}
