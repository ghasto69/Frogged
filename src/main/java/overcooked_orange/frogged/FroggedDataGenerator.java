package overcooked_orange.frogged;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;
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

        generator.addProvider(ModFrogs::new);
        generator.addProvider(ModFrogTags::new);
        generator.addProvider(FroggedModelProvider::new);

        generator.addProvider((dataOutput, registriesFuture) -> new FabricLanguageProvider(dataOutput, registriesFuture) {
            @Override
            public void generateTranslations(RegistryWrapper.WrapperLookup provider, TranslationBuilder translations) {
                translations.add(ModBlocks.OBSIDIAN_FROGLIGHT, "Obsidian Froglight");
            }
        });
    }
}
