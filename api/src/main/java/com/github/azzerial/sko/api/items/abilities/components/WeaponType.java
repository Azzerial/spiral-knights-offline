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

import com.github.azzerial.sko.api.items.weapons.Bomb;
import com.github.azzerial.sko.api.items.weapons.Handgun;
import com.github.azzerial.sko.api.items.weapons.Sword;
import com.github.azzerial.sko.api.items.weapons.Weapon;

public enum WeaponType {
    BOMB("Bomb"),
    HANDGUN("Handgun"),
    SWORD("Sword"),
    UNIFORM("Uniform");

    private final String label;

    /* Constructors */

    WeaponType(String label) {
        this.label = label;
    }

    /* Getters & Setters */

    public String getLabel() {
        return label;
    }

    public boolean isApplicable(Weapon weapon) {
        switch (this) {
            case BOMB: return weapon instanceof Bomb;
            case HANDGUN: return weapon instanceof Handgun;
            case SWORD: return weapon instanceof Sword;
            case UNIFORM: return true;
        }
        return false;
    }
}
