package com.java;
/*

  Write a function that takes in a Binary Search Tree (BST) and a range of
  integers and returns the number of subtrees in the BST that are only made up
  of nodes with values contained in the range.

  For example, if the range is [10, 12], your function should
  return the number of subtrees in the BST that are only made up of nodes with
  values 10, 11, or 12.

  the following example with range [5, 15] should return 5:
        10
       /     \
      5      15
    /   \   /   \
   2     8 13   22
 /      / \  \
1      5   9  14

 The 5 subtrees are:
   8    5    9    13    14
  / \               \
 5   9               14

The following list of nodes should return 5
{
  "nodes": [
    {"id": "10", "left": "5", "right": "15", "value": 10},
    {"id": "15", "left": "13", "right": "22", "value": 15},
    {"id": "22", "left": null, "right": null, "value": 22},
    {"id": "13", "left": null, "right": "14", "value": 13},
    {"id": "14", "left": null, "right": null, "value": 14},
    {"id": "5", "left": "2", "right": "8", "value": 5},
    {"id": "5-2", "left": null, "right": null, "value": 5},
    {"id": "8", "left": "5-2", "right": "9", "value": 8},
    {"id": "9", "left": null, "right": null, "value": 9},
    {"id": "2", "left": "1", "right": null, "value": 2},
    {"id": "1", "left": null, "right": null, "value": 1}
  ],
  "root": "10"
}

 */
class SubtreesWithinRange {

    public static int subtreesWithinRange(BST tree, int[] targetRange) {
        return subTrees(tree, targetRange).count;
    }


    static BSTData subTrees(BST tree, int[] targetRange
    ) {
        if (tree == null) return new BSTData(null, true, 0);
        BSTData left = subTrees(tree.left, targetRange);
        BSTData right = subTrees(tree.right, targetRange);
        BSTData current = new BSTData(tree, false, left.count + right.count);
        if (left.isBst && right.isBst
                && tree.value >= targetRange[0]
                && tree.value <= targetRange[1]) {
            current.count += 1;
            current.isBst = true;
        }



        return current;

    }

    static class BSTData {
        public BST bst;
        public boolean isBst = false;
        public int count = 0;

        public BSTData(BST bst, boolean isBst, int count) {
            this.bst = bst;
            this.isBst = isBst;
            this.count = count;

        }

    }

    // This is an input class. Do not edit.
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}

