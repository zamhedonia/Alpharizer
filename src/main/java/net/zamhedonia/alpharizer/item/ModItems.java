package net.zamhedonia.alpharizer.item;

import net.zamhedonia.alpharizer.Alpharizer;
import net.zamhedonia.alpharizer.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    
    public static final Item ALPHA_RICE_SEEDS = registerItem("alpha_rice_seeds",
        new AliasedBlockItem(ModBlocks.ALPHA_RICE_BLOCK, (new Item.Settings())));
    
    public static final Item ALPHA_RICE = registerItem("alpha_rice",
        new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Alpharizer.MOD_ID, name), item);
    }

    public static void addItemsToItemGroup() {
        addItemsToItemGroup(ModItemGroup.ALPHARIZER, ALPHA_RICE_SEEDS);
        addItemsToItemGroup(ModItemGroup.ALPHARIZER, ALPHA_RICE);
    }

    public static void addItemsToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }

    public static void registerModItems() {
        Alpharizer.LOGGER.info("Registering Mod Items for " + Alpharizer.MOD_ID);

        addItemsToItemGroup();
    }
}
