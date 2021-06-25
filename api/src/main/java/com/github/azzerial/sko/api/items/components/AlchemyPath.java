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

import com.github.azzerial.sko.api.items.Equipment;
import com.github.azzerial.sko.util.tree.TreeNode;
import com.github.azzerial.sko.util.tree.TreeNodeImpl;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum AlchemyPath {
    ;

    private final TreeNode<Equipment> root;

    /* Constructors */

    AlchemyPath(Node[] nodes) {
        final List<TreeNodeImpl<Equipment>> treeNodes = Arrays.stream(nodes)
            .map(node -> new TreeNodeImpl<>(node.data))
            .collect(Collectors.toList());

        for (int i = 0; i != nodes.length; i++) {
            final TreeNodeImpl<Equipment> treeNode = treeNodes.get(i);

            for (Equipment child : nodes[i].children) {
                treeNodes.stream()
                    .filter(tn -> tn.getData().equals(child))
                    .findFirst()
                    .ifPresent(treeNode::addChild);
            }
        }

        this.root = TreeNode.unmodifiableTree(treeNodes.get(0));
    }

    /* Getters & Setters */

    public TreeNode<Equipment> getRootNode() {
        return root;
    }

    public boolean hasParent(Equipment equipment) {
        final TreeNode<Equipment> node = root.findNode(equipment);
        return node != null && node.hasParent();
    }

    public Equipment getParent(Equipment equipment) {
        final TreeNode<Equipment> node = root.findNode(equipment);

        if (node == null) {
            return null;
        }
        return node.getParent() == null ? null : node.getParent().getData();
    }

    public boolean hasEquipment(Equipment equipment) {
        return root.findNode(equipment) != null;
    }

    public boolean hasEquipments(StarLevel starLevel) {
        return root.findNodes(equipment -> equipment.getStarLevel() == starLevel) != null;
    }

    public Equipment[] getEquipments(StarLevel starLevel) {
        return Arrays.stream(root.findNodes(equipment -> equipment.getStarLevel() == starLevel))
            .map(TreeNode::getData)
            .toArray(Equipment[]::new);
    }

    public Equipment[] getEquipments(Predicate<Equipment> filter) {
        return Arrays.stream(root.findNodes(filter))
            .map(TreeNode::getData)
            .toArray(Equipment[]::new);
    }

    public boolean hasChildren(Equipment equipment) {
        final TreeNode<Equipment> node = root.findNode(equipment);
        return node != null && node.getChildrenSize() != 0;
    }

    public int getChildrenSize(Equipment equipment) {
        final TreeNode<Equipment> node = root.findNode(equipment);
        return node == null ? 0 : node.getChildrenSize();
    }

    public Equipment[] getChildren(Equipment equipment) {
        final TreeNode<Equipment> node = root.findNode(equipment);
        return node == null ? new Equipment[0] : Arrays.stream(node.getChildren()).map(TreeNode::getData).toArray(Equipment[]::new);
    }

    /* Nested Classes */

    private static final class Node {

        private final Equipment data;
        private final Equipment[] children;

        /* Constructors */

        private Node(Equipment data, Equipment... children) {
            this.data = data;
            this.children = children;
        }
    }
}
