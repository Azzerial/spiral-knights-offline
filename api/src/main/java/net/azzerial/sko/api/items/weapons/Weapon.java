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

package net.azzerial.sko.api.items.weapons;

import net.azzerial.sko.api.items.Equipment;
import net.azzerial.sko.api.items.abilities.components.DamageType;
import net.azzerial.sko.api.items.components.CombatStyle;
import net.azzerial.sko.api.items.weapons.components.DamageStat;

public interface Weapon extends Equipment {

    CombatStyle getCombatStyle();

    DamageStat[] getDamageStats();

    default int getNormalDamageStat() {
        return getDamageStats()[DamageType.NORMAL.ordinal()] != null ? getDamageStats()[DamageType.NORMAL.ordinal()].getValue() : 0;
    }

    default int getElementalDamageStat() {
        return getDamageStats()[DamageType.ELEMENTAL.ordinal()] != null ? getDamageStats()[DamageType.ELEMENTAL.ordinal()].getValue() : 0;
    }

    default int getPiercingDamageStat() {
        return getDamageStats()[DamageType.PIERCING.ordinal()] != null ? getDamageStats()[DamageType.PIERCING.ordinal()].getValue() : 0;
    }

    default int getShadowDamageStat() {
        return getDamageStats()[DamageType.SHADOW.ordinal()] != null ? getDamageStats()[DamageType.SHADOW.ordinal()].getValue() : 0;
    }

    int getAttackSpeed();
}