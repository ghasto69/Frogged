package overcooked_orange.frogged;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import overcooked_orange.frogged.frog.FrogEatingLootTableHandler;
import overcooked_orange.frogged.frog.VenomousFrogAttackHandler;
import overcooked_orange.frogged.registry.ModBlocks;
import overcooked_orange.frogged.registry.ModFrogs;
import overcooked_orange.frogged.registry.ModItems;

public class Frogged implements ModInitializer {
    public static final String MOD_ID = "frogged";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModFrogs.registerFrogs();
        ModItems.registerItems();
        ModBlocks.registerBlocks();

        BiomeModifications.addSpawn(
                context -> context.hasTag(ConventionalBiomeTags.IS_JUNGLE),
                SpawnGroup.CREATURE,
                EntityType.FROG,
                8,
                2,
                5
        );

        AttackEntityCallback.EVENT.register(new VenomousFrogAttackHandler());
        LootTableEvents.MODIFY.register(new FrogEatingLootTableHandler());
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path.toLowerCase());
    }
}