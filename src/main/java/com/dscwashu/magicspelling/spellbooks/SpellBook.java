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
        castSpell(world, playerEntity);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    protected abstract void castSpell(World world, PlayerEntity playerEntity);
}
