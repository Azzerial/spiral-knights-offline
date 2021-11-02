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

package com.github.azzerial.sko.api.items.weapons.components;

import com.github.azzerial.sko.api.items.components.CombatStyle;

public enum HandgunType implements CombatStyle {
    ALCHEMER("Alchemer"),
    ANTIGUA("Antigua"),
    AUTOGUN("Autogun"),
    BLASTER("Blaster"),
    CATALYZER("Catalyzer"),
    MAGNUS("Magnus"),
    MIXMASTER("Mixmaster"),
    PULSAR("Pulsar"),
    SHARD_CANNON("Shard Cannon");

    private final String label;

    /* Constructors */

    HandgunType(String label) {
        this.label = label;
    }

    /* Getters & Setters */

    @Override
    public String getLabel() {
        return label;
    }
}
