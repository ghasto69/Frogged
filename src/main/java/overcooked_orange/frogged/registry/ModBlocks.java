package overcooked_orange.frogged.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import overcooked_orange.frogged.Frogged;
import overcooked_orange.frogged.registry.ModFrogs;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ModBlocks {
    public static final Block OBSIDIAN_FROGLIGHT = block(
            "obsidian_froglight",
            PillarBlock::new,
            AbstractBlock.Settings.create()
                    .mapColor(MapColor.DEEPSLATE_GRAY)
                    .strength(0.3F)
                    .luminance(blockState -> 15)
                    .sounds(BlockSoundGroup.FROGLIGHT),
            BlockItem::new,
            new Item.Settings()
    );

    public static void registerBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Items.PEARLESCENT_FROGLIGHT, ModBlocks.OBSIDIAN_FROGLIGHT);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> {
            entries.addAfter(Items.PEARLESCENT_FROGLIGHT, ModBlocks.OBSIDIAN_FROGLIGHT);
        });
    }

    private static Block block(String name, Function<AbstractBlock.Settings, Block> blockFunction, AbstractBlock.Settings blockSettings, BiFunction<Block, Item.Settings, Item> itemFunction, Item.Settings itemSettings) {
        Block block = Blocks.register(RegistryKey.of(RegistryKeys.BLOCK, Frogged.id(name)), blockFunction, blockSettings);
        Items.register(block, itemFunction, itemSettings);
        return block;
    }
}
