package net.zamhedonia.alpharizer.util;

import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.zamhedonia.alpharizer.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;

public class ModLootTableModifiers 
{

    private static final Identifier GRASS_BLOCK_ID
            = new Identifier("minecraft", "blocks/grass");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, tableBuilder, source) -> {
            
            if(GRASS_BLOCK_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.075f)) // Drops 7.5% of the time
                        .with(ItemEntry.builder(ModItems.ALPHA_RICE_SEEDS))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
                tableBuilder.pool(poolBuilder.build());
            }
        });
    }
}
