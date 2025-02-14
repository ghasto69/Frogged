package overcooked_orange.frogged;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import overcooked_orange.frogged.datagen.FroggedModelProvider;
import overcooked_orange.frogged.datagen.ModFrogTags;
import overcooked_orange.frogged.registry.ModBlocks;
import overcooked_orange.frogged.registry.ModFrogs;

public class FroggedDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack generator = fabricDataGenerator.createPack();

        generator.addProvider(ModFrogTags::new);
        generator.addProvider(FroggedModelProvider::new);

        generator.addProvider((dataOutput, registriesFuture) -> new FabricLanguageProvider(dataOutput) {
            @Override
            public void generateTranslations(TranslationBuilder translations) {
                translations.add(ModBlocks.OBSIDIAN_FROGLIGHT, "Obsidian Froglight");

                translations.add(ModFrogTags.VENOMOUS.id().toTranslationKey("tag"), "Venomous Frogs");

                translations.add(Registries.FROG_VARIANT.getId(ModFrogs.GOLDEN_POISON_DART_FROG).toTranslationKey("frog_variant"), "Golden Poison Frog");
                translations.add(Registries.FROG_VARIANT.getId(ModFrogs.BLUE_POISON_DART_FROG).toTranslationKey("frog_variant"), "Blue Poison Frog");
            }
        });
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
    }
}
