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

package com.github.azzerial.sko.util.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public final class TreeNodeImpl<T> implements TreeNode<T> {

    private TreeNodeImpl<T> parent = null;
    private T data;
    private final List<TreeNodeImpl<T>> children = new ArrayList<>();
    private boolean immutable = false;

    /* Constructors */

    public TreeNodeImpl(T data) {
        this.data = data;
    }

    /* Getters & Setters */

    @Override
    public boolean hasParent() {
        return parent != null;
    }

    @Override
    public TreeNodeImpl<T> getParent() {
        return parent;
    }

    public TreeNodeImpl<T> setParent(TreeNodeImpl<T> node) {
        if (immutable) {
            return this;
        }
        if (this.parent != null) {
            this.parent.removeChild(this);
        }
        this.parent = node;
        if (node != null) {
            node.addChild(this);
        }
        return this;
    }

    @Override
    public T getData() {
        return data;
    }

    public TreeNodeImpl<T> setData(T data) {
        if (immutable) {
            return this;
        }
        this.data = data;
        return this;
    }

    @Override
    public boolean hasChildren() {
        return !children.isEmpty();
    }

    @Override
    public int getChildrenSize() {
        return children.size();
    }

    @Override
    @SuppressWarnings("unchecked")
    public TreeNode<T>[] getChildren() {
        return children.toArray(new TreeNode[0]);
    }

    public TreeNodeImpl<T> removeChildren() {
        if (immutable) {
            return this;
        }

        final List<TreeNodeImpl<T>> copy = new ArrayList<>(this.children);

        copy.forEach(node -> node.setParent(null));
        this.children.clear();
        return this;
    }

    @Override
    public TreeNode<T> getChild(int index) {
        return children.size() > index ? children.get(index) : null;
    }

    public TreeNodeImpl<T> addChild(TreeNodeImpl<T> node) {
        if (immutable || node == null || this.children.contains(node)) {
            return this;
        }
        this.children.add(node);
        node.setParent(this);
        return this;
    }

    public TreeNodeImpl<T> removeChild(TreeNodeImpl<T> node) {
        if (immutable || node == null || !this.children.contains(node)) {
            return this;
        }
        this.children.remove(node);
        node.setParent(null);
        return this;
    }

    public TreeNodeImpl<T> setImmutable() {
        this.immutable = true;
        return this;
    }

    /* Methods */

    @Override
    public TreeNode<T> findNode(T t) {
        return findNode(this, t);
    }

    @Override
    @SuppressWarnings("unchecked")
    public TreeNode<T>[] findNodes(Predicate<T> filter) {
        final List<TreeNode<T>> list = new LinkedList<>();

        findNodes(list, this, filter);
        return list.toArray(new TreeNode[0]);
    }

    @Override
    public String toString() {
        return data.toString();
    }

    /* Internal */

    private TreeNode<T> findNode(TreeNode<T> node, T t) {
        if (node.getData().equals(t)) {
            return node;
        }
        for (TreeNode<T> child : node.getChildren()) {
            final TreeNode<T> result = findNode(child, t);

            if (result != null) {
                return result;
            }
        }
        return null;
    }

    private void findNodes(List<TreeNode<T>> list, TreeNode<T> node, Predicate<T> filter) {
        if (filter.test(node.getData())) {
            list.add(node);
        }
        for (TreeNode<T> child : node.getChildren()) {
            findNodes(list, child, filter);
        }
    }
}