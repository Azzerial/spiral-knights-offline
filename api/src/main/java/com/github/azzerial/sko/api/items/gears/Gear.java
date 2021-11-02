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

package com.github.azzerial.sko.api.items.gears;

import com.github.azzerial.sko.api.items.Equipment;
import com.github.azzerial.sko.api.items.Set;
import com.github.azzerial.sko.api.items.abilities.components.DamageType;
import com.github.azzerial.sko.api.items.abilities.components.StatusType;
import com.github.azzerial.sko.api.items.gears.components.StatusResistance;
import com.github.azzerial.sko.api.items.gears.components.DefenseStat;

public interface Gear extends Equipment {

    DefenseStat[] getDefenseStats();

    default int getNormalDefenseStat() {
        return getDefenseStats()[DamageType.NORMAL.ordinal()] != null ? getDefenseStats()[DamageType.NORMAL.ordinal()].getValue() : 0;
    }

    default int getElementalDefenseStat() {
        return getDefenseStats()[DamageType.ELEMENTAL.ordinal()] != null ? getDefenseStats()[DamageType.ELEMENTAL.ordinal()].getValue() : 0;
    }

    default int getPiercingDefenseStat() {
        return getDefenseStats()[DamageType.PIERCING.ordinal()] != null ? getDefenseStats()[DamageType.PIERCING.ordinal()].getValue() : 0;
    }

    default int getShadowDefenseStat() {
        return getDefenseStats()[DamageType.SHADOW.ordinal()] != null ? getDefenseStats()[DamageType.SHADOW.ordinal()].getValue() : 0;
    }

    StatusResistance[] getStatusResistances();

    default StatusResistance getCurseStatusResistance() {
        return getStatusResistances()[StatusType.CURSE.ordinal()];
    }

    default StatusResistance getFireStatusResistance() {
        return getStatusResistances()[StatusType.FIRE.ordinal()];
    }

    default StatusResistance getFreezeStatusResistance() {
        return getStatusResistances()[StatusType.FREEZE.ordinal()];
    }

    default StatusResistance getPoisonStatusResistance() {
        return getStatusResistances()[StatusType.POISON.ordinal()];
    }

    default StatusResistance getShockStatusResistance() {
        return getStatusResistances()[StatusType.SHOCK.ordinal()];
    }

    default StatusResistance getSleepStatusResistance() {
        return getStatusResistances()[StatusType.SLEEP.ordinal()];
    }

    default StatusResistance getStunStatusResistance() {
        return getStatusResistances()[StatusType.STUN.ordinal()];
    }

    Set getSet();
}