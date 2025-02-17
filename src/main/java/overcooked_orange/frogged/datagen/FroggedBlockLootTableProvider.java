package overcooked_orange.frogged.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import overcooked_orange.frogged.registry.ModBlocks;

public class FroggedBlockLootTableProvider extends FabricBlockLootTableProvider {
    public FroggedBlockLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.COBALT_FROGLIGHT);
        addDrop(ModBlocks.SAFFRON_FROGLIGHT);
        addDrop(ModBlocks.CERULEAN_FROGLIGHT);
        addDrop(ModBlocks.RUSSET_FROGLIGHT);
    }
}
