package net.zamhedonia.alpharizer.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.zamhedonia.alpharizer.Alpharizer;
import net.zamhedonia.alpharizer.item.ModItemGroup;

public class ModBlocks {
    //Add Blocks here
    public static final Block Alpha_Grass_Block = registerBlock("alpha_grass_block",
        new Block(FabricBlockSettings.of(Material.SOLID_ORGANIC).ticksRandomly().strength(0.6f).sounds(BlockSoundGroup.GRASS)), ModItemGroup.ALPHARIZER);



    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(Alpharizer.MOD_ID, name), block);
    }
    
    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(Alpharizer.MOD_ID, name),
            new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void registerModBlocks() {
        Alpharizer.LOGGER.info("Registering ModBlocks for" + Alpharizer.MOD_ID);
    }
}
