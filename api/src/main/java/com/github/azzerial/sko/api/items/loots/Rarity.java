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

package com.github.azzerial.sko.api.items.loots;

import com.github.azzerial.sko.api.items.Item;
import com.github.azzerial.sko.api.items.components.StarLevel;

public enum Rarity implements Item {
    // Evo Catalyst
    // Fire Crystal
    // Orb of Alchemy
    FLAWED_ORB_OF_ALCHEMY("Flawed Orb of Alchemy", "A rare, encapsulated element used in alchemical transmutation. Though flawed, this orb is still useful in crafting low-powered items.", StarLevel.ONE_STAR),
    SIMPLE_ORB_OF_ALCHEMY("Simple Orb of Alchemy", "A rare, encapsulated element used in alchemical transmutation. While unrefined, this orb can be used to craft more powerful items.", StarLevel.TWO_STAR),
    ADVANCED_ORB_OF_ALCHEMY("Advanced Orb of Alchemy", "A rare, encapsulated element used in alchemical transmutation. This orb is exceptional and can be used to craft very powerful items.", StarLevel.THREE_STAR),
    ELITE_ORB_OF_ALCHEMY("Elite Orb of Alchemy", "A rare, encapsulated element used in alchemical transmutation. Orbs like these are used by elite knights to craft items of exceptional quality and power.", StarLevel.FOUR_STAR),
    ETERNAL_ORB_OF_ALCHEMY("Eternal Orb of Alchemy", "A rare, encapsulated element used in alchemical transmutation. This orb is prized by the most powerful knights and is used to craft items of extraordinary power.", StarLevel.FIVE_STAR)
    // Spark of Life
    // Golden Slime Coin
    ;

    private final String name;
    private final String description;
    private final StarLevel starLevel;

    /* Constructors */

    Rarity(String name, String description, StarLevel starLevel) {
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
}