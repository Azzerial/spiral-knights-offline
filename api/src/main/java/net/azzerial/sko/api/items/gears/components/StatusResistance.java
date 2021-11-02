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

package net.azzerial.sko.api.items.gears.components;


import net.azzerial.sko.api.items.abilities.components.StatusType;

public final class StatusResistance {

    private final StatusType statusType;
    private final ResistanceType resistanceType;
    private final ResistanceLevel resistanceLevel;

    /* Constructors */

    public StatusResistance(StatusType statusType, ResistanceType resistanceType, ResistanceLevel resistanceLevel) {
        this.statusType = statusType;
        this.resistanceType = resistanceType;
        this.resistanceLevel = resistanceLevel;
    }

    /* Getters & Setters */

    public StatusType getStatusType() {
        return statusType;
    }

    public ResistanceType getResistanceType() {
        return resistanceType;
    }

    public ResistanceLevel getResistanceLevel() {
        return resistanceLevel;
    }

    /* Methods */

    public boolean isStatusType(StatusType statusType) {
        return this.statusType == statusType;
    }

    public boolean isResistanceType(ResistanceType resistanceType) {
        return this.resistanceType == resistanceType;
    }

    public boolean isResistanceLevel(ResistanceLevel resistanceLevel) {
        return this.resistanceLevel == resistanceLevel;
    }
}