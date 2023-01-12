
package com.maomao.more_snowballs.effects;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class SlimeStatusEffect extends StatusEffect {
    public SlimeStatusEffect() {
        super(StatusEffectCategory.HARMFUL, 6542418);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
