package overcooked_orange.frogged.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import overcooked_orange.frogged.Frogged;

import java.util.function.BiFunction;
import java.util.function.Function;

public class ModItems {
    public static final Item COBALT_FROGLIGHT = blockItem("cobalt_froglight", ModBlocks.COBALT_FROGLIGHT, BlockItem::new, new Item.Settings());
    public static final Item SAFFRON_FROGLIGHT = blockItem("saffron_froglight", ModBlocks.SAFFRON_FROGLIGHT, BlockItem::new, new Item.Settings());
    public static final Item RUSSET_FROGLIGHT = blockItem("russet_froglight", ModBlocks.RUSSET_FROGLIGHT, BlockItem::new, new Item.Settings());
    public static final Item CERULEAN_FROGLIGHT = blockItem("cerulean_froglight", ModBlocks.CERULEAN_FROGLIGHT, BlockItem::new, new Item.Settings());
    public static final Item SCULK_FROGLIGHT = blockItem("sculk_froglight", ModBlocks.SCULK_FROGLIGHT,BlockItem::new, new Item.Settings());

    public static void registerItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addFroglight);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::addFroglight);
    }

    private static Item blockItem(String name, Block block, BiFunction<Block, Item.Settings, Item> itemFunction, Item.Settings settings) {
        return item(name, settings1 -> itemFunction.apply(block, settings), settings);
    }

    private static Item item(String name, Function<Item.Settings, Item> itemFunction, Item.Settings settings) {
        Identifier id = Frogged.id(name);
        return Registry.register(Registries.ITEM, id, itemFunction.apply(settings));
    }

    private static void addFroglight(FabricItemGroupEntries entries) {
        entries.addAfter(
                Items.PEARLESCENT_FROGLIGHT,
                COBALT_FROGLIGHT,
                SAFFRON_FROGLIGHT,
                RUSSET_FROGLIGHT,
                CERULEAN_FROGLIGHT,
                SCULK_FROGLIGHT
        );
    }
}
