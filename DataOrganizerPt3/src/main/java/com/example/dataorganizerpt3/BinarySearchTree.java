package com.example.dataorganizerpt3;

public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public void insert(T data) {
        root = insertRec(root, data);
    }

    public boolean contains(T data) {
        return containsRec(root, data);
    }

    private TreeNode<T> insertRec(TreeNode<T> node, T data) {
        if (node == null) {
            return new TreeNode<>(data);
        }

        if (data.compareTo(node.data) < 0) {
            node.left = insertRec(node.left, data);
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertRec(node.right, data);
        }
        return node;
    }

    private boolean containsRec(TreeNode<T> node, T data) {
        if (node == null) {
            return false;
        }

        if (data.equals(node.data)) {
            return true;
        }

        return data.compareTo(node.data) < 0
                ? containsRec(node.left, data)
                : containsRec(node.right, data);
    }

    private static class TreeNode<T> {
        T data;
        TreeNode<T> left, right;

        TreeNode(T data) {
            this.data = data;
        }
    }
}
