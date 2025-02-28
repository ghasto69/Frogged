package overcooked_orange.frogged.registry;

import net.minecraft.block.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import overcooked_orange.frogged.Frogged;

import java.util.function.Function;

public class ModBlocks {
    public static final AbstractBlock.Settings FROGLIGHT_SETTINGS = AbstractBlock.Settings.copy(Blocks.VERDANT_FROGLIGHT);

    public static final Block COBALT_FROGLIGHT = block("cobalt_froglight", PillarBlock::new, FROGLIGHT_SETTINGS.mapColor(MapColor.LAPIS_BLUE));
    public static final Block SAFFRON_FROGLIGHT = block("saffron_froglight", PillarBlock::new, FROGLIGHT_SETTINGS.mapColor(MapColor.TERRACOTTA_YELLOW));
    public static final Block RUSSET_FROGLIGHT = block("russet_froglight", PillarBlock::new, FROGLIGHT_SETTINGS.mapColor(MapColor.TERRACOTTA_ORANGE));
    public static final Block CERULEAN_FROGLIGHT = block("cerulean_froglight", PillarBlock::new, FROGLIGHT_SETTINGS.mapColor(MapColor.CYAN));
    public static final Block SCULK_FROGLIGHT = block("sculk_froglight", PillarBlock::new, FROGLIGHT_SETTINGS.mapColor(MapColor.DARK_AQUA).luminance(state -> 10));

    public static void registerBlocks() {}

    private static Block block(String name, Function<AbstractBlock.Settings, Block> blockFunction, AbstractBlock.Settings settings) {
        Identifier id = Frogged.id(name);
        return Registry.register(Registries.BLOCK, id, blockFunction.apply(settings.registryKey(RegistryKey.of(RegistryKeys.BLOCK, id))));
    }
}
