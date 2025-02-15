package overcooked_orange.frogged.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import overcooked_orange.frogged.Frogged;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ModBlocks {
    public static final Block COBALT_FROGLIGHT = block(
            "cobalt_froglight",
            PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.LAPIS_BLUE)
                    .strength(0.3F)
                    .luminance(blockState -> 15)
                    .sounds(BlockSoundGroup.FROGLIGHT),
            BlockItem::new,
            new Item.Settings()
    );

    public static final Block SAFFRON_FROGLIGHT = block(
            "saffron_froglight",
            PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_YELLOW)
                    .strength(0.3F)
                    .luminance(blockState -> 15)
                    .sounds(BlockSoundGroup.FROGLIGHT),
            BlockItem::new,
            new Item.Settings()
    );

    public static final Block RUSSET_FROGLIGHT = block(
            "russet_froglight",
            PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.TERRACOTTA_ORANGE)
                    .strength(0.3F)
                    .luminance(blockState -> 15)
                    .sounds(BlockSoundGroup.FROGLIGHT),
            BlockItem::new,
            new Item.Settings()
    );

    public static void registerBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addFroglight);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::addFroglight);
    }

    private static Block block(String name, Function<AbstractBlock.Settings, Block> blockFunction, AbstractBlock.Settings blockSettings, BiFunction<Block, Item.Settings, Item> itemFunction, Item.Settings itemSettings) {
        Identifier id = Frogged.id(name);
        Block block = Registry.register(Registries.BLOCK, id, blockFunction.apply(blockSettings));
        Registry.register(Registries.ITEM, id, itemFunction.apply(block, itemSettings));
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
