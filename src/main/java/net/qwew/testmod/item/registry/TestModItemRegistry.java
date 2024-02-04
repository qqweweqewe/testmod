package net.qwew.testmod.item.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

import net.qwew.testmod.TestMod;
import net.qwew.testmod.item.PoopItem;
import net.qwew.testmod.item.ZewaItem;

public class TestModItemRegistry {

    private static final Item POOP = registerItem("poop", new PoopItem());
    private static final Item ZEWA = registerItem("zewa", new ZewaItem());

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        TestMod.LOGGER.info("--REGISTERING TESTMOD ITEMS--");

        //Adding items to item groups
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> entries.add(POOP));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> entries.add(ZEWA));
    }
}
