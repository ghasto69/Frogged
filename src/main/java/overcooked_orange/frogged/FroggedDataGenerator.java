package overcooked_orange.frogged;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import overcooked_orange.frogged.datagen.FroggedBlockLootTableProvider;
import overcooked_orange.frogged.datagen.FroggedModelProvider;
import overcooked_orange.frogged.datagen.ModBiomeTags;
import overcooked_orange.frogged.datagen.ModFrogTags;
import overcooked_orange.frogged.registry.ModBlocks;
import overcooked_orange.frogged.registry.ModFrogs;

public class FroggedDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack generator = fabricDataGenerator.createPack();

        generator.addProvider(FroggedBlockLootTableProvider::new);
        generator.addProvider(ModFrogTags::new);
        generator.addProvider(ModBiomeTags::new);
        generator.addProvider(FroggedModelProvider::new);

        generator.addProvider((dataOutput, registriesFuture) -> new FabricLanguageProvider(dataOutput) {
            @Override
            public void generateTranslations(TranslationBuilder translations) {
                translations.add(ModBlocks.COBALT_FROGLIGHT, "Cobalt Froglight");
                translations.add(ModBlocks.SAFFRON_FROGLIGHT, "Saffron Froglight");
            }
        });
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
    }
}
