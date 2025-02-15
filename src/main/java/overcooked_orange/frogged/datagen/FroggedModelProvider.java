package overcooked_orange.frogged.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.TexturedModel;
import overcooked_orange.frogged.registry.ModBlocks;

public class FroggedModelProvider extends FabricModelProvider {
    public FroggedModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator generator) {
        generator.registerAxisRotated(ModBlocks.COBALT_FROGLIGHT, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
        generator.registerAxisRotated(ModBlocks.SAFFRON_FROGLIGHT, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
        generator.registerAxisRotated(ModBlocks.RUSSET_FROGLIGHT, TexturedModel.CUBE_COLUMN, TexturedModel.CUBE_COLUMN_HORIZONTAL);
    }

    @Override
    public void generateItemModels(ItemModelGenerator generator) {

    }
}
