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

package net.azzerial.sko.api.items.components;

import net.azzerial.sko.api.items.loots.Material;
import net.azzerial.sko.api.items.loots.Rarity;

import java.util.Arrays;

public final class Recipe {

    private final StarLevel starLevel;
    private final Standard standard;
    private final Component<Material>[] materials;
    private final Component<Rarity> orbOfAlchemy;

    /* Constructors */

    public Recipe(StarLevel starLevel, Component<Material>[] materials) {
        this.starLevel = starLevel;
        this.standard = Standard.fromStarLevel(starLevel);
        this.materials = materials;
        this.orbOfAlchemy = new Component<>(standard.getOrbOfAlchemy(), (byte) standard.getOrbOfAlchemyQuantity());
    }

    /* Getters & Setters */

    public StarLevel getStarLevel() {
        return starLevel;
    }

    public Standard getStandard() {
        return standard;
    }

    public int getRecipeCost() {
        return standard.getRecipeCost();
    }

    public int getCraftingCost() {
        return standard.getCraftingCost();
    }

    public boolean requireHeatLevel() {
        return standard.requireHeatLevel();
    }

    public int getRequiredHeatLevel() {
        return standard.getRequiredHeatLevel();
    }

    public boolean requireMaterial(Material material) {
        if (material == null) {
            return false;
        }
        return Arrays.stream(materials).anyMatch(c -> c.item.equals(material));
    }

    public int getMaterialQuantity(Material material) {
        if (material == null) {
            return 0;
        }
        return Arrays.stream(materials)
            .filter(c -> c.item.equals(material))
            .map(c -> c.quantity)
            .findFirst()
            .orElse((byte) 0);
    }

    public Component<Material>[] getMaterials() {
        return materials;
    }

    public Component<Rarity> getOrbOfAlchemy() {
        return orbOfAlchemy;
    }

    /* Nested Classes */

    public static final class Component<T> {

        private final T item;
        private final byte quantity;

        /* Constructors */

        public Component(T item, byte quantity) {
            this.item = item;
            this.quantity = quantity;
        }

        /* Getters & Setters */

        public T getItem() {
            return item;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    public enum Standard {
        ONE_STAR_RECIPE(StarLevel.ONE_STAR, (short) 250, (short) 200, (byte) 0, new byte[] { 3, 2, 0, 0, 0, 0 }, Rarity.FLAWED_ORB_OF_ALCHEMY),
        TWO_STAR_RECIPE(StarLevel.TWO_STAR, (short) 1000, (short) 400, (byte) 0, new byte[] { 5, 2, 2, 0, 0, 0 }, Rarity.SIMPLE_ORB_OF_ALCHEMY),
        THREE_STAR_RECIPE(StarLevel.THREE_STAR, (short) 4000, (short) 1000, (byte) 0, new byte[] { 10, 3, 2, 1, 0, 0 }, Rarity.ADVANCED_ORB_OF_ALCHEMY),
        FOUR_STAR_RECIPE(StarLevel.FOUR_STAR, (short) 10000, (short) 2500, (byte) 5, new byte[] { 15, 4, 3, 2, 1, 0 }, Rarity.ELITE_ORB_OF_ALCHEMY),
        FIVE_STAR_RECIPE(StarLevel.FIVE_STAR, (short) 25000, (short) 5000, (byte) 10, new byte[] { 20, 5, 4, 3, 2, 1 }, Rarity.ETERNAL_ORB_OF_ALCHEMY);

        private static final byte ORB_OF_ALCHEMY_QUANTITY = 3;

        private final StarLevel starLevel;
        private final short recipeCost;
        private final short craftingCost;
        private final byte requiredHeatLevel;
        private final byte[] materials;
        private final Rarity orbOfAlchemy;

        /* Constructors */

        Standard(StarLevel starLevel, short recipeCost, short craftingCost, byte requiredHeatLevel, byte[] materials, Rarity orbOfAlchemy) {
            this.starLevel = starLevel;
            this.recipeCost = recipeCost;
            this.craftingCost = craftingCost;
            this.requiredHeatLevel = requiredHeatLevel;
            this.materials = materials;
            this.orbOfAlchemy = orbOfAlchemy;
        }

        /* Getters & Setters */

        public StarLevel getStarLevel() {
            return starLevel;
        }

        public int getRecipeCost() {
            return recipeCost;
        }

        public int getCraftingCost() {
            return craftingCost;
        }

        public boolean requireHeatLevel() {
            return requiredHeatLevel != 0;
        }

        public int getRequiredHeatLevel() {
            return requiredHeatLevel;
        }

        public boolean requireMaterial(StarLevel starLevel) {
            return materials[starLevel.ordinal()] != 0;
        }

        public int getMaterialQuantity(StarLevel starLevel) {
            return materials[starLevel.ordinal()];
        }

        public Rarity getOrbOfAlchemy() {
            return orbOfAlchemy;
        }

        public int getOrbOfAlchemyQuantity() {
            return ORB_OF_ALCHEMY_QUANTITY;
        }

        /* Methods */

        public static Standard fromStarLevel(StarLevel starLevel) {
            switch (starLevel) {
                case ONE_STAR: return ONE_STAR_RECIPE;
                case TWO_STAR: return TWO_STAR_RECIPE;
                case THREE_STAR: return THREE_STAR_RECIPE;
                case FOUR_STAR: return FOUR_STAR_RECIPE;
                case FIVE_STAR: return FIVE_STAR_RECIPE;
                default: throw new IllegalArgumentException("Invalid star level");
            }
        }
    }
}