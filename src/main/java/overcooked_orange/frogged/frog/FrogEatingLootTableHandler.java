package overcooked_orange.frogged.frog;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.fabricmc.fabric.api.loot.v2.LootTableSource;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.FrogVariant;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.loot.LootManager;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.DamageSourcePropertiesLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.predicate.entity.DamageSourcePredicate;
import net.minecraft.predicate.entity.EntityPredicate;
import net.minecraft.predicate.entity.TypeSpecificPredicate;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import overcooked_orange.frogged.registry.ModBlocks;
import overcooked_orange.frogged.registry.ModFrogs;

public class FrogEatingLootTableHandler implements LootTableEvents.Modify {
    @Override
    public void modifyLootTable(ResourceManager resourceManager, LootManager lootManager, Identifier identifier, LootTable.Builder builder, LootTableSource lootTableSource) {
        if (identifier == EntityType.MAGMA_CUBE.getLootTableId()) {
            froglight(ModBlocks.COBALT_FROGLIGHT, ModFrogs.BLUE_POISON_DART_FROG, builder);
            froglight(ModBlocks.SAFFRON_FROGLIGHT, ModFrogs.GOLDEN_POISON_DART_FROG, builder);
        }
    }

    private static void froglight(ItemConvertible item, FrogVariant variant, LootTable.Builder builder) {
        LootPool.Builder pool = LootPool.builder()
                .with(
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(ConstantLootNumberProvider.create(1.0F)))
                                .conditionally(DamageSourcePropertiesLootCondition.builder(
                                        DamageSourcePredicate.Builder.create()
                                                .sourceEntity(
                                                        EntityPredicate.Builder.create()
                                                                .type(EntityType.FROG)
                                                                .typeSpecific(TypeSpecificPredicate.frog(variant))
                                                )
                                ))
                );
        builder.pool(pool);
    }
}
