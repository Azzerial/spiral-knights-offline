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

package com.github.azzerial.sko.api.items.abilities.components;

public enum OffensiveAbilityLevel implements AbilityLevel {
    LOW((byte) 1, "Low", true),
    MEDIUM((byte) 2, "Medium", true),
    HIGH((byte) 3, "High", true),
    VERY_HIGH((byte) 4, "Very High", true),
    ULTRA((byte) 5, "Ultra", false),
    MAXIMUM((byte) 6, "Maximum!", false);

    private final byte level;
    private final String label;
    private final boolean uniqueVariant;

    /* Constructors */

    OffensiveAbilityLevel(byte level, String label, boolean uniqueVariant) {
        this.level = level;
        this.label = label;
        this.uniqueVariant = uniqueVariant;
    }

    /* Getters & Setters */

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public String getDisplayLevel() {
        return label;
    }

    @Override
    public boolean isAcquirableAsUniqueVariant() {
        return uniqueVariant;
    }
}