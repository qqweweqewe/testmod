package net.qwew.testmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

import net.minecraft.registry.Registries;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.qwew.testmod.TestMod;

import java.util.Random;

public class ZewaItem extends Item {

    private double recoil;
    private int load;

    public ZewaItem() {
        super(new FabricItemSettings());
        this.recoil = 1;
        this.load = 1;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        // Drop the load
        ItemStack poopStack = new ItemStack(
                Registries.ITEM.get(new Identifier(TestMod.MOD_ID, "poop")),
                new Random().nextInt(2)+load
        );

        player.dropItem(poopStack, true);

        // Yeet upwards
        player.addVelocity(0d, recoil, 0d);

        // Remove one zewa roll on use
        ItemStack zewaStack = player.getStackInHand(hand);
        zewaStack.decrement(1);

        // Return the whatever
        return TypedActionResult.success(zewaStack);
    }

}
