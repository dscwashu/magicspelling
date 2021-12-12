package com.dscwashu.magicspelling;

import com.dscwashu.magicspelling.spellbooks.FireballSpellbook;
import com.dscwashu.magicspelling.spellbooks.LightningSpellbook;
import com.dscwashu.magicspelling.spellbooks.Spellbook;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.loot.v1.FabricLootPoolBuilder;
import net.fabricmc.fabric.api.loot.v1.event.LootTableLoadingCallback;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.BinomialLootNumberProvider;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MagicSpelling implements ModInitializer {
    public static final String MOD_ID = "magicspelling";
    public static final Spellbook FIREBALL_MAGIC_BOOK = new FireballSpellbook(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Spellbook LIGHTNING_SPELL_BOOK = new LightningSpellbook(new FabricItemSettings().group(ItemGroup.MISC));

    //fireball in desert temple, pillager lightning, both in stronghold_library
    private static final Identifier TREASURE_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/buried_treasure");
    private static final Identifier OUTPOST_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/pillager_outpost");
    private static final Identifier STRONGHOLD_LIBRARY_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/stronghold_library");
    private static final Identifier TEMPLE_CHEST_LOOT_TABLE_ID = new Identifier("minecraft", "chests/desert_temple");




    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fireball_spellbook"), FIREBALL_MAGIC_BOOK);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lightning_spellbook"), LIGHTNING_SPELL_BOOK);


        LootTableLoadingCallback.EVENT.register((resourceManager, lootManager, id, supplier, setter) -> {
            if (OUTPOST_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(UniformLootNumberProvider.create(0,1))
                        .withEntry(ItemEntry.builder(LIGHTNING_SPELL_BOOK).build());

                supplier.withPool(poolBuilder.build());
            }
            if (TREASURE_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(UniformLootNumberProvider.create(0,1))
                        .withEntry(ItemEntry.builder(LIGHTNING_SPELL_BOOK).build());

                supplier.withPool(poolBuilder.build());
            }
            if (STRONGHOLD_LIBRARY_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(UniformLootNumberProvider.create(0,1))
                        .withEntry(ItemEntry.builder(FIREBALL_MAGIC_BOOK).build());

                supplier.withPool(poolBuilder.build());
            }
            if (TEMPLE_CHEST_LOOT_TABLE_ID.equals(id)) {
                FabricLootPoolBuilder poolBuilder = FabricLootPoolBuilder.builder()
                        .rolls(UniformLootNumberProvider.create(0,1))
                        .withEntry(ItemEntry.builder(FIREBALL_MAGIC_BOOK).build());

                supplier.withPool(poolBuilder.build());
            }


        });
    }
}
