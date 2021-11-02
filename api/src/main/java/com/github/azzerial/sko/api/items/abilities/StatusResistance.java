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
import com.github.azzerial.sko.api.items.abilities.components.DefensiveAbilityLevel;
import com.github.azzerial.sko.api.items.abilities.components.StatusType;

public final class StatusResistance implements Ability {

    private final DefensiveAbilityLevel abilityLevel;
    private final StatusType statusType;

    /* Constructors */

    public StatusResistance(DefensiveAbilityLevel abilityLevel, StatusType statusType) {
        this.abilityLevel = abilityLevel;
        this.statusType = statusType;
    }

    /* Getters & Setters */

    @Override
    public AbilityType getType() {
        return AbilityType.STATUS_RESISTANCE;
    }

    public AbilityLevel getLevel() {
        return abilityLevel;
    }

    public StatusType getStatusType() {
        return statusType;
    }
}