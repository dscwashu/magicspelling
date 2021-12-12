package com.dscwashu.magicspelling.spellbooks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.world.World;

public class FireballSpellbook extends Spellbook {
    public FireballSpellbook(Settings settings) {
        super(settings, "Utinam inundare perniciosa vis, torrens virtutis, perniciosa vis nulla alia!"
                + " Omnem creaturam ad suum fontem mitte!");
    }

    @Override
    protected void effectSpell(World world, PlayerEntity playerEntity, double power) {

        double x = playerEntity.getRotationVector().x;
        double y = playerEntity.getRotationVector().y;
        double z = playerEntity.getRotationVector().z;

        //x,y,z are coordinates of direction camera is facing. i controls the power of the spell.
        FireballEntity fireball = new FireballEntity(world,playerEntity,x,y,z,10);
        world.spawnEntity(fireball);
    }
}
