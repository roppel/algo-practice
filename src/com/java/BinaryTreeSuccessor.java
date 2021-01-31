package com.java;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeSuccessor {


    public static void main(String[] args) {


        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.parent = root;
        root.right = new BinaryTree(3);
        root.right.parent = root;
        root.left.left = new BinaryTree(4);
        root.left.left.parent = root.left;
        root.left.right = new BinaryTree(5);
        root.left.right.parent = root.left;
        root.left.left.left = new BinaryTree(6);
        root.left.left.left.parent = root.left.left;
        BinaryTree node = root.left.right;
        //watch out for NPE here when printing value
        System.out.println(findSuccessor(root, node).value);
        System.out.println(findSuccessorTraversal(root, node).value);

    }

    //notice you don't actually need to bother with the input tree, since
    //the node gives you everything you need
    //O(h) time, where h is height of tree. would be n if is a linked list
    //O(1) space
    public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {

        if (node.right != null) return getLeftMostChild(node.right);
        return getRightMostParent(node);

    }

    public static BinaryTree getLeftMostChild(BinaryTree node) {
        while (node.left != null) node = node.left;
        return node;
    }

    public static BinaryTree getRightMostParent(BinaryTree node) {
        while (node.parent != null && node.parent.right == node) {
            node = node.parent;
        }
        return node.parent;

    }

    //the following is O(n) time and space, you traverse the entire tree and make a copy
    //this works without touching the parent
    public static BinaryTree findSuccessorTraversal(BinaryTree tree, BinaryTree node) {
        List<BinaryTree> list = new ArrayList();
        fillList(tree, list);

        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i) == node) return list.get(i+1);
        }

        return null;
    }

    public static void fillList(BinaryTree tree, List<BinaryTree> list) {
        if(tree == null) return;
        fillList(tree.left, list);
        list.add(tree);
        fillList(tree.right, list);
    }




    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }


}
