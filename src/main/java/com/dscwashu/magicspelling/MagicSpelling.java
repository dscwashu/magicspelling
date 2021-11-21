package com.dscwashu.magicspelling;

import com.dscwashu.magicspelling.spellbooks.FireballSpellBook;
import com.dscwashu.magicspelling.spellbooks.LightningSpellBook;
import com.dscwashu.magicspelling.spellbooks.SpellBook;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MagicSpelling implements ModInitializer {
    public static final String MOD_ID = "magicspelling";
    public static final SpellBook FIREBALL_MAGIC_BOOK = new FireballSpellBook(new FabricItemSettings().group(ItemGroup.MISC));
    public static final SpellBook LIGHTNING_SPELL_BOOK = new LightningSpellBook(new FabricItemSettings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fireball_magic_book"), FIREBALL_MAGIC_BOOK);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lightning_magic_book"), LIGHTNING_SPELL_BOOK);
    }
}
