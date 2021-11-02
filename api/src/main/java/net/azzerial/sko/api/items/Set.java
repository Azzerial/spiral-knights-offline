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

package net.azzerial.sko.api.items;

import net.azzerial.sko.api.items.components.StarLevel;

import java.util.Arrays;

public enum Set {
    ;

    private final Equipment[] equipments;

    /* Constructors */

    Set(Equipment[] equipments) {
        this.equipments = equipments;
    }

    /* Getters & Setters */

    public boolean hasEquipment(Equipment equipment) {
        return Arrays.asList(equipments).contains(equipment);
    }

    public Equipment[] getEquipments() {
        return equipments;
    }

    public StarLevel getStarLevel() {
        return equipments.length == 0 ? null : equipments[0].getStarLevel();
    }
}