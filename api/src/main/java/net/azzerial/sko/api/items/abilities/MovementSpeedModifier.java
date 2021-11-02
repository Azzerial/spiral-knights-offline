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
import net.azzerial.sko.api.items.abilities.components.OffensiveAbilityLevel;

public final class MovementSpeedModifier implements Ability {

    private final OffensiveAbilityLevel abilityLevel;
    private final boolean increase;

    /* Constructors */

    public MovementSpeedModifier(OffensiveAbilityLevel abilityLevel, boolean increase) {
        this.abilityLevel = abilityLevel;
        this.increase = increase;
    }

    /* Getters & Setters */

    @Override
    public AbilityType getType() {
        return AbilityType.MOVEMENT_SPEED_MODIFIER;
    }

    public AbilityLevel getLevel() {
        return abilityLevel;
    }

    public boolean isIncrease() {
        return increase;
    }

    public boolean isDecrease() {
        return !increase;
    }
}