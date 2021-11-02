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

package net.azzerial.sko.api.items.abilities;

import net.azzerial.sko.api.items.abilities.components.AbilityLevel;
import net.azzerial.sko.api.items.abilities.components.AbilityType;
import net.azzerial.sko.api.items.abilities.components.DamageType;
import net.azzerial.sko.api.items.abilities.components.DefensiveAbilityLevel;

public final class DamageResistance implements Ability {

    private final DefensiveAbilityLevel abilityLevel;
    private final DamageType damageType;

    /* Constructors */

    public DamageResistance(DefensiveAbilityLevel abilityLevel, DamageType damageType) {
        this.abilityLevel = abilityLevel;
        this.damageType = damageType;
    }

    /* Getters & Setters */

    @Override
    public AbilityType getType() {
        return AbilityType.DAMAGE_RESISTANCE;
    }

    public AbilityLevel getLevel() {
        return abilityLevel;
    }

    public DamageType getDamageType() {
        return damageType;
    }
}