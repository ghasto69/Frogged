package overcooked_orange.frogged.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import overcooked_orange.frogged.registry.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class FroggedEnglishProvider extends FabricLanguageProvider {
    public FroggedEnglishProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> wrapperLookup) {
        super(dataOutput, wrapperLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translations) {
        translations.add(ModBlocks.COBALT_FROGLIGHT, "Cobalt Froglight");
        translations.add(ModBlocks.SAFFRON_FROGLIGHT, "Saffron Froglight");
        translations.add(ModBlocks.CERULEAN_FROGLIGHT, "Cerulean Froglight");
        translations.add(ModBlocks.RUSSET_FROGLIGHT, "Russet Froglight");
        translations.add(ModBlocks.SCULK_FROGLIGHT, "Sculk Froglight");
    }
}
