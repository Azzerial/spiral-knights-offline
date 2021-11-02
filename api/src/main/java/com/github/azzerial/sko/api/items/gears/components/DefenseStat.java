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

package com.github.azzerial.sko.api.items.gears.components;

import com.github.azzerial.sko.api.items.abilities.components.DamageType;
import com.github.azzerial.sko.api.items.components.CombatStat;

public final class DefenseStat implements CombatStat {

    private final DamageType type;
    private final short value;

    /* Constructors */

    public DefenseStat(DamageType type, short value) {
        this.type = type;
        this.value = value;
    }

    /* Getters & Setters */

    @Override
    public DamageType getDamageType() {
        return type;
    }

    @Override
    public int getValue() {
        return value;
    }
}