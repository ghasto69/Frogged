package overcooked_orange.frogged.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import overcooked_orange.frogged.Frogged;

public class ModBlocks {
    public static final Block COBALT_FROGLIGHT = froglight("cobalt_froglight", MapColor.LAPIS_BLUE);
    public static final Block SAFFRON_FROGLIGHT = froglight("saffron_froglight", MapColor.TERRACOTTA_YELLOW);
    public static final Block RUSSET_FROGLIGHT = froglight("russet_froglight", MapColor.TERRACOTTA_ORANGE);
    public static final Block CERULEAN_FROGLIGHT = froglight("cerulean_froglight", MapColor.CYAN);

    public static void registerBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addFroglight);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::addFroglight);
    }

    private static Block froglight(String name, MapColor mapColor) {
        Identifier id = Frogged.id(name);
        Block block = Registry.register(Registries.BLOCK, id, new PillarBlock(AbstractBlock.Settings.create()
                .mapColor(mapColor)
                .strength(0.3F)
                .luminance(blockState -> 15)
                .sounds(BlockSoundGroup.FROGLIGHT)
        ));
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
        return block;
    }

    private static void addFroglight(FabricItemGroupEntries entries) {
        entries.addAfter(
                Items.PEARLESCENT_FROGLIGHT,
                COBALT_FROGLIGHT,
                SAFFRON_FROGLIGHT,
                RUSSET_FROGLIGHT
        );
    }
}
