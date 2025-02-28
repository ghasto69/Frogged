package overcooked_orange.frogged.frog;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.item.ItemConvertible;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.DamageSourcePropertiesLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.entity.DamageSourcePredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.EntitySubPredicateTypes;
import net.minecraft.predicate.entity.EntityTypePredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.entry.RegistryEntry;
import overcooked_orange.frogged.registry.ModBlocks;
import overcooked_orange.frogged.registry.ModFrogs;

public class FrogEatingLootTableHandler implements LootTableEvents.Modify {
    @Override
    public void modifyLootTable(RegistryKey<LootTable> registryKey, LootTable.Builder builder, LootTableSource lootTableSource, RegistryWrapper.WrapperLookup wrapperLookup) {
        if (EntityType.MAGMA_CUBE.getLootTableKey().orElseThrow().equals(registryKey)) {
            froglight(ModBlocks.COBALT_FROGLIGHT, ModFrogs.BLUE_POISON_DART_FROG, builder, wrapperLookup);
            froglight(ModBlocks.SAFFRON_FROGLIGHT, ModFrogs.GOLDEN_POISON_DART_FROG, builder, wrapperLookup);
            froglight(ModBlocks.CERULEAN_FROGLIGHT, ModFrogs.VARIEGATED_POISON_DART_FROG, builder, wrapperLookup);
            froglight(ModBlocks.RUSSET_FROGLIGHT, ModFrogs.SANDY_FROG, builder, wrapperLookup);
            froglight(ModBlocks.SCULK_FROGLIGHT, ModFrogs.SCULK_FROG, builder, wrapperLookup);
        }
    }

    private static void froglight(ItemConvertible item, RegistryEntry<FrogVariant> variant, LootTable.Builder builder, RegistryWrapper.WrapperLookup wrapperLookup) {
        LootPool.Builder pool = LootPool
                .builder()
                .with(ItemEntry.builder(item)
                        .apply(SetCountLootFunction.builder(
                                ConstantLootNumberProvider.create(1.0F))
                        )
                        .conditionally(
                                DamageSourcePropertiesLootCondition.builder(
                                        DamageSourcePredicate.Builder
                                                .create()
                                                .sourceEntity(
                                                        EntityPredicate.Builder.create().type(EntityTypePredicate.create(wrapperLookup.getOrThrow(RegistryKeys.ENTITY_TYPE), EntityType.MAGMA_CUBE)).typeSpecific(EntitySubPredicateTypes.frogVariant(variant))
                                                )
                                )
                        )
                );
        builder.pool(pool);
    }
}
