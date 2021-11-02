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

package com.github.azzerial.sko.api.items.components;

public enum StarLevel {
    ZERO_STAR((byte) 0, "☆☆☆☆☆"),
    ONE_STAR((byte) 1, "★☆☆☆☆"),
    TWO_STAR((byte) 2, "★★☆☆☆"),
    THREE_STAR((byte) 3, "★★★☆☆"),
    FOUR_STAR((byte) 4, "★★★★☆"),
    FIVE_STAR((byte) 5, "★★★★★");

    private final byte level;
    private final String label;

    /* Constructors */

    StarLevel(byte level, String label) {
        this.level = level;
        this.label = label;
    }

    /* Getters & Setters */

    public int getLevel() {
        return level;
    }

    public String getDisplayLevel() {
        return label;
    }
}