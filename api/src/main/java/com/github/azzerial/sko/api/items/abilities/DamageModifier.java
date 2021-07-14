/*
 * Copyright 2021 Robin Mercier
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.azzerial.sko.api.items.abilities;

import com.github.azzerial.sko.api.items.abilities.components.AbilityLevel;
import com.github.azzerial.sko.api.items.abilities.components.AbilityType;
import com.github.azzerial.sko.api.items.abilities.components.MonsterType;
import com.github.azzerial.sko.api.items.abilities.components.WeaponType;

public final class DamageModifier implements Ability {

    private final AbilityLevel abilityLevel;
    private final WeaponType weaponType;
    private final MonsterType monsterType;
    private final boolean bonus;

    /* Constructors */

    public DamageModifier(AbilityLevel abilityLevel, WeaponType weaponType, MonsterType monsterType, boolean bonus) {
        this.abilityLevel = abilityLevel;
        this.weaponType = weaponType;
        this.monsterType = monsterType;
        this.bonus = bonus;
    }

    /* Getters & Setters */

    @Override
    public AbilityType getType() {
        return AbilityType.DAMAGE_MODIFIER;
    }

    public AbilityLevel getLevel() {
        return abilityLevel;
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public boolean isBonus() {
        return bonus;
    }

    public boolean isPenalty() {
        return !bonus;
    }
}
