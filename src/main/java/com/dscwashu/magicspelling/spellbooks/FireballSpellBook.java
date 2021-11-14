package com.dscwashu.magicspelling.spellbooks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class FireballSpellBook extends SpellBook {
    public FireballSpellBook(Settings settings) {
        super(settings);
    }

    @Override
    protected void castSpell(World world, PlayerEntity playerEntity) {
        System.out.println("Explosion!");
    }
}
