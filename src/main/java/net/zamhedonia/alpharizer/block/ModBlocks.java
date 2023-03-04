package net.zamhedonia.alpharizer.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.zamhedonia.alpharizer.Alpharizer;
import net.zamhedonia.alpharizer.block.custom.AlphaGrassBlock;
import net.zamhedonia.alpharizer.block.custom.AlphaRiceBlock;
import net.zamhedonia.alpharizer.item.ModItemGroup;

public class ModBlocks {
    //Add Blocks here
    public static final Block Alpha_Grass_Block = registerBlock("alpha_grass_block",
    new AlphaGrassBlock(AbstractBlock.Settings.of(Material.SOLID_ORGANIC).ticksRandomly().hardness(0.6f).resistance(0.6f).sounds(BlockSoundGroup.GRASS)), ModItemGroup.ALPHARIZER);

    public static final Block Alpha_Cobblestone = registerBlock("alpha_cobblestone",
    new Block(FabricBlockSettings.of(Material.STONE).hardness(2f).requiresTool().resistance(6f).sounds(BlockSoundGroup.STONE)), ModItemGroup.ALPHARIZER);

    public static final Block Classic_Cobblestone = registerBlock("classic_cobblestone",
    new Block(FabricBlockSettings.of(Material.STONE).hardness(2f).requiresTool().resistance(6f).sounds(BlockSoundGroup.STONE)), ModItemGroup.ALPHARIZER);

    public static final Block Alpha_Stone = registerBlock("alpha_stone",
    new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f).requiresTool().resistance(6f).sounds(BlockSoundGroup.STONE)), ModItemGroup.ALPHARIZER);
    
    public static final Block Alpha_Bricks = registerBlock("alpha_bricks",
    new Block(FabricBlockSettings.of(Material.STONE).hardness(2f).requiresTool().resistance(6f).sounds(BlockSoundGroup.STONE)), ModItemGroup.ALPHARIZER);
    
    public static final Block Classic_Bricks = registerBlock("classic_bricks",
    new Block(FabricBlockSettings.of(Material.STONE).hardness(2f).requiresTool().resistance(6f).sounds(BlockSoundGroup.STONE)), ModItemGroup.ALPHARIZER);

    public static final Block Alpha_Planks = registerBlock("alpha_planks",
    new Block(FabricBlockSettings.of(Material.WOOD).hardness(2f).resistance(3f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.ALPHARIZER);
    
    public static final Block Alpha_Log = registerBlock("alpha_log",
    new Block(FabricBlockSettings.of(Material.WOOD).hardness(2f).resistance(2f).sounds(BlockSoundGroup.WOOD)), ModItemGroup.ALPHARIZER);

    public static final Block ALPHA_RICE_BLOCK = registerBlock("alpha_rice_block",
    new AlphaRiceBlock(AbstractBlock.Settings.of(Material.PLANT).noCollision().ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP)), ItemGroups.SEARCH);
    
    public static final Block ALPHA_LEAVES = registerBlock("alpha_leaves",
    new LeavesBlock(FabricBlockSettings.of(Material.LEAVES).nonOpaque().hardness(0.05f).resistance(0.2f).sounds(BlockSoundGroup.GRASS)), ModItemGroup.ALPHARIZER);
    

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
