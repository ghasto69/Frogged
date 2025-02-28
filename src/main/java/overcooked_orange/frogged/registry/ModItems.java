package overcooked_orange.frogged.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import overcooked_orange.frogged.Frogged;

import java.util.function.Function;

public class ModItems {
    public static final Item COBALT_FROGLIGHT = item("cobalt_froglight", settings -> new BlockItem(ModBlocks.COBALT_FROGLIGHT, settings), new Item.Settings().useBlockPrefixedTranslationKey());
    public static final Item SAFFRON_FROGLIGHT = item("saffron_froglight", settings -> new BlockItem(ModBlocks.SAFFRON_FROGLIGHT, settings), new Item.Settings().useBlockPrefixedTranslationKey());
    public static final Item RUSSET_FROGLIGHT = item("russet_froglight", settings -> new BlockItem(ModBlocks.RUSSET_FROGLIGHT, settings), new Item.Settings().useBlockPrefixedTranslationKey());
    public static final Item CERULEAN_FROGLIGHT = item("cerulean_froglight", settings -> new BlockItem(ModBlocks.CERULEAN_FROGLIGHT, settings), new Item.Settings().useBlockPrefixedTranslationKey());
    public static final Item SCULK_FROGLIGHT = item("sculk_froglight", settings -> new BlockItem(ModBlocks.SCULK_FROGLIGHT, settings), new Item.Settings().useBlockPrefixedTranslationKey());

    public static void registerItems() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItems::addFroglight);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::addFroglight);
    }

    private static Item item(String name, Function<Item.Settings, Item> itemFunction, Item.Settings settings) {
        Identifier id = Frogged.id(name);
        return Registry.register(Registries.ITEM, id, itemFunction.apply(settings.registryKey(RegistryKey.of(RegistryKeys.ITEM, id))));
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
