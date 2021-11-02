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

import com.github.azzerial.sko.api.items.abilities.components.*;
import net.azzerial.sko.api.items.abilities.components.*;

public final class StatusInflicting implements Ability {

    private final StatusChanceModifier statusChanceModifier;
    private final StatusStrengthModifier statusStrengthModifier;
    private final StatusType statusType;
    private final AttackType[] attackTypes;
    private final boolean selfInflicting;

    /* Constructors */

    public StatusInflicting(StatusChanceModifier statusChanceModifier, StatusStrengthModifier statusStrengthModifier, StatusType statusType, AttackType[] attackTypes, boolean selfInflicting) {
        this.statusChanceModifier = statusChanceModifier;
        this.statusStrengthModifier = statusStrengthModifier;
        this.statusType = statusType;
        this.attackTypes = attackTypes;
        this.selfInflicting = selfInflicting;
    }

    /* Getters & Setters */

    @Override
    public AbilityType getType() {
        return AbilityType.STATUS_INFLICTING;
    }

    public StatusChanceModifier getStatusChanceModifier() {
        return statusChanceModifier;
    }

    public StatusStrengthModifier getStatusStrengthModifier() {
        return statusStrengthModifier;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public AttackType[] getAttackTypes() {
        return attackTypes;
    }

    public boolean isSelfInflicting() {
        return selfInflicting;
    }
}