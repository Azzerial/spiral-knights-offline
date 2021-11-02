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

import com.github.azzerial.sko.api.items.Set;
import com.github.azzerial.sko.api.items.abilities.Ability;
import com.github.azzerial.sko.api.items.components.AlchemyPath;
import com.github.azzerial.sko.api.items.components.Recipe;
import com.github.azzerial.sko.api.items.components.StarLevel;
import com.github.azzerial.sko.api.items.gears.components.StatusResistance;
import com.github.azzerial.sko.api.items.gears.components.DefenseStat;

public enum Shield implements Gear {
    ;

    private final String name;
    private final String description;
    private final StarLevel starLevel;

    /* Constructors */

    Shield(String name, String description, StarLevel starLevel) {
        this.name = name;
        this.description = description;
        this.starLevel = starLevel;
    }

    /* Getters & Setters */

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public StarLevel getStarLevel() {
        return starLevel;
    }

    @Override
    public Recipe getRecipe() {
        return null;
    }

    @Override
    public AlchemyPath getAlchemyPath() {
        return null;
    }

    @Override
    public Ability[] getAbilities() {
        return new Ability[0];
    }

    @Override
    public DefenseStat[] getDefenseStats() {
        return new DefenseStat[0];
    }

    @Override
    public StatusResistance[] getStatusResistances() {
        return new StatusResistance[0];
    }

    @Override
    public Set getSet() {
        return null;
    }

    public int getBonusHealth() {
        return 0;
    }
}