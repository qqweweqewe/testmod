package net.qwew.testmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import net.qwew.testmod.TestMod;

public class TestModItemRegistry {

    public static final Item POOP = registerItem("poop", new Item(new FabricItemSettings()));
    public static final Item ZEWA = registerItem("zewa", new Item(new FabricItemSettings()));

    private static void addItemsToFoodDrinkItemGroup(FabricItemGroupEntries entries) {
        entries.add(POOP);
    }

    private static void addItemsToToolsItemGroup(FabricItemGroupEntries entries) {
        entries.add(ZEWA);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("--REGISTERING TESTMOD ITEMS--");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(TestModItemRegistry::addItemsToFoodDrinkItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(TestModItemRegistry::addItemsToToolsItemGroup);
    }
}
