package com.dscwashu.magicspelling.spellbooks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public abstract class SpellBook extends Item {
    public SpellBook(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        double accuracy = 1;
        effectSpell(world, playerEntity, accuracy);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    /**
     * Effects the SpellBook's spell.
     * @param power The spell's power, from 0 to 1.
     */
    protected abstract void effectSpell(World world, PlayerEntity playerEntity, double power);

}
