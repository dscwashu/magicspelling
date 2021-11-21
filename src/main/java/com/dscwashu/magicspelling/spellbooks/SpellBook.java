package com.dscwashu.magicspelling.spellbooks;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.ricecode.similarity.LevenshteinDistanceStrategy;
import net.ricecode.similarity.SimilarityStrategy;
import net.ricecode.similarity.StringSimilarityService;
import net.ricecode.similarity.StringSimilarityServiceImpl;

public abstract class SpellBook extends Item {
    protected final String spellText;

    public SpellBook(Settings settings, String spellText) {
        super(settings);
        this.spellText = spellText;
    }

    /**
     * The right-click action of a SpellBook.
     */
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        String playerSpellInput = getPlayerSpellInput();

        // Find how close the player's input was to the actual spell text.
        // This value is used to prevent the player from spamming spells.
        SimilarityStrategy strategy = new LevenshteinDistanceStrategy();
        StringSimilarityService service = new StringSimilarityServiceImpl(strategy);
        double accuracy = service.score(this.spellText, playerSpellInput);

        effectSpell(world, playerEntity, accuracy);

        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }

    /**
     * Helper method to get the player's input.
     * @return the player's input
     */
    String getPlayerSpellInput() {
        return "Sample Text";
    }

    /**
     * Effects the SpellBook's spell.
     * @param power The spell's power, from 0 to 1.
     */
    protected abstract void effectSpell(World world, PlayerEntity playerEntity, double power);

}
