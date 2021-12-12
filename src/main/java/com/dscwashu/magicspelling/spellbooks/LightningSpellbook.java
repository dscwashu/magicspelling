package com.dscwashu.magicspelling.spellbooks;

import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;

public class LightningSpellbook extends Spellbook {
    public LightningSpellbook(Settings settings) {
        super(settings, "Utinam inundare perniciosa vis, torrens virtutis, perniciosa vis nulla alia!"
                + " Omnem creaturam ad suum fontem mitte!");
    }

    @Override
    protected void effectSpell(World world, PlayerEntity playerEntity, double power) {
        MinecraftClient client = MinecraftClient.getInstance();
        HitResult hit = client.crosshairTarget;

        switch(hit.getType()) {
            case BLOCK:
                BlockHitResult blockHit = (BlockHitResult) hit;

                LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world);
                lightning.updatePosition(blockHit.getPos().getX(),blockHit.getPos().getY(), blockHit.getPos().getZ());
                world.spawnEntity(lightning);

                break;
            case ENTITY:
                EntityHitResult entityHit = (EntityHitResult) hit;

                LightningEntity lightningE = EntityType.LIGHTNING_BOLT.create(world);
                lightningE.updatePosition(entityHit.getPos().getX(),entityHit.getPos().getY(), entityHit.getPos().getZ());
                world.spawnEntity(lightningE);

                break;
            default:
                //nothing near enough

                break;
        }

    }
}
