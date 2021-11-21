package com.dscwashu.magicspelling.spellbooks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LightningSpellBook extends SpellBook {
    public LightningSpellBook(Settings settings) {
        super(settings, "Utinam inundare perniciosa vis, torrens virtutis, perniciosa vis nulla alia!"
                + " Omnem creaturam ad suum fontem mitte!");
    }


    @Override
    protected void effectSpell(World world, PlayerEntity playerEntity, double power) {
        MinecraftClient client = MinecraftClient.getInstance();
        HitResult hit = client.crosshairTarget;

        switch(hit.getType()) {
            case MISS:
                //nothing near enough
                break;
            case BLOCK:
                BlockHitResult blockHit = (BlockHitResult) hit;
                BlockPos blockPos = blockHit.getBlockPos();
                BlockState blockState = client.world.getBlockState(blockPos);
                Block block = blockState.getBlock();
                break;
            case ENTITY:
                EntityHitResult entityHit = (EntityHitResult) hit;
                Entity entity = entityHit.getEntity();
                break;
        }

        ServerWorld serverWorld = (ServerWorld) world;
        LightningEntity lightning = EntityType.LIGHTNING_BOLT.create(world);
        serverWorld.spawnEntity(lightning);
    }
}