package net.qwew.testmod.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;

public class PoopItem extends Item {

    public PoopItem() {
        super(new FabricItemSettings().maxCount(16).food(new FoodComponent.Builder()
                .hunger(4)
                .saturationModifier(0.4f)
                .meat()
                .statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 120, 255), 1)
                .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 120, 255), 1)
                .build()));
    }
}
