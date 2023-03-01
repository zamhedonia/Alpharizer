package net.zamhedonia.alpharizer;

import net.fabricmc.api.ModInitializer;
import net.zamhedonia.alpharizer.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Alpharizer implements ModInitializer {
	public static final String MOD_ID = "alpharizer";
	public static final Logger LOGGER = LoggerFactory.getLogger("alpharizer");

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}