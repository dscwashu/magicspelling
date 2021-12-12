package com.dscwashu.magicspelling;

import com.dscwashu.magicspelling.spellbooks.FireballSpellbook;
import com.dscwashu.magicspelling.spellbooks.LightningSpellbook;
import com.dscwashu.magicspelling.spellbooks.Spellbook;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class MagicSpelling implements ModInitializer {
    public static final String MOD_ID = "magicspelling";
    public static final Spellbook FIREBALL_MAGIC_BOOK = new FireballSpellbook(new FabricItemSettings().group(ItemGroup.MISC));
    public static final Spellbook LIGHTNING_SPELL_BOOK = new LightningSpellbook(new FabricItemSettings().group(ItemGroup.MISC));

    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "fireball_spellbook"), FIREBALL_MAGIC_BOOK);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "lightning_spellbook"), LIGHTNING_SPELL_BOOK);
    }
}
