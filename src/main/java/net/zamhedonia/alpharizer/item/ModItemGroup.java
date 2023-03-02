package net.zamhedonia.alpharizer.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.zamhedonia.alpharizer.Alpharizer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup ALPHARIZER;

    public static void registerItemGroups() {
        ALPHARIZER = FabricItemGroup.builder(new Identifier(Alpharizer.MOD_ID, "alpharizer"))
        .displayName(Text.literal("Alpharizer"))
        .icon(() -> new ItemStack(ModItems.ALPHA_RICE_SEEDS)).build();
    }
}
