package com.dscwashu.magicspelling.spellbooks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class FireballSpellBook extends SpellBook {
    public FireballSpellBook(Settings settings) {
        super(settings);
    }

    @Override
    protected void effectSpell(World world, PlayerEntity playerEntity, double power) {
        System.out.println("Explosion!");
    }
}
