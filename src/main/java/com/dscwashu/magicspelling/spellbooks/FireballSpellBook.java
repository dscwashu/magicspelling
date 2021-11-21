package com.dscwashu.magicspelling.spellbooks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.world.World;

public class FireballSpellBook extends SpellBook {
    public FireballSpellBook(Settings settings) {
        super(settings, "Utinam inundare perniciosa vis, torrens virtutis, perniciosa vis nulla alia!"
                + " Omnem creaturam ad suum fontem mitte!");
    }

    @Override
    protected void effectSpell(World world, PlayerEntity playerEntity, double power) {
        FireballEntity fireball = new FireballEntity(world,playerEntity,0d,0d,0d,100);
        fireball.setVelocity(playerEntity.getPos().normalize().x,playerEntity.getPos().normalize().y,playerEntity.getPos().normalize().z);
        world.spawnEntity(fireball);

        System.out.println("Explosion!");
    }
}
