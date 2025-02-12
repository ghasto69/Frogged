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
import overcooked_orange.frogged.datagen.ModFrogTags;
import overcooked_orange.frogged.registry.*;

public class FroggedDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        FabricDataGenerator.Pack pack = dataGenerator.createPack();

        pack.addProvider((FabricDataGenerator.Pack.Factory<FabricModelProvider>) dataOutput -> new FabricModelProvider(dataOutput) {
            @Override
            public void generateBlockStateModels(BlockStateModelGenerator generator) {
                generator.registerAxisRotated(ModBlocks.OBSIDIAN_FROGLIGHT, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
            }

            @Override
            public void generateItemModels(ItemModelGenerator generator) {

            }
        });

        pack.addProvider((dataOutput, registriesFuture) -> new FabricLanguageProvider(dataOutput, registriesFuture) {
            @Override
            public void generateTranslations(RegistryWrapper.WrapperLookup provider, TranslationBuilder translations) {
                translations.add(ModBlocks.OBSIDIAN_FROGLIGHT, "Obsidian Froglight");
            }
        });

        pack.addProvider(ModFrogs::new);
        pack.addProvider(ModFrogTags::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.FROG_VARIANT, ModFrogs::generate);
    }
}
