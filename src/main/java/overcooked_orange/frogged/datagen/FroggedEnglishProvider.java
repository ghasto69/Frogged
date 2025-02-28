package overcooked_orange.frogged.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import overcooked_orange.frogged.registry.ModBlocks;

public class FroggedEnglishProvider extends FabricLanguageProvider {
    public FroggedEnglishProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generateTranslations(TranslationBuilder translations) {
        translations.add(ModBlocks.COBALT_FROGLIGHT, "Cobalt Froglight");
        translations.add(ModBlocks.SAFFRON_FROGLIGHT, "Saffron Froglight");
        translations.add(ModBlocks.CERULEAN_FROGLIGHT, "Cerulean Froglight");
        translations.add(ModBlocks.RUSSET_FROGLIGHT, "Russet Froglight");
        translations.add(ModBlocks.SCULK_FROGLIGHT, "Sculk Froglight");
    }
}
