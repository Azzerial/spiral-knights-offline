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

package net.azzerial.sko.util.tree;

import java.util.function.Predicate;

public interface TreeNode<T> {

    static <T> TreeNode<T> unmodifiableTree(TreeNode<T> root) {
        ((TreeNodeImpl<T>) root).setImmutable();
        for (TreeNode<T> node : root.getChildren()) {
            unmodifiableTree(node);
        }
        return root;
    }

    boolean hasParent();

    TreeNode<T> getParent();

    T getData();

    boolean hasChildren();

    int getChildrenSize();

    TreeNode<T>[] getChildren();

    TreeNode<T> getChild(int index);

    TreeNode<T> findNode(T t);

    TreeNode<T>[] findNodes(Predicate<T> filter);
}