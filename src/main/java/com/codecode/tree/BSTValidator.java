package com.codecode.tree;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class BSTValidator {


    public boolean isBST(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }
        if (root.val >= max || root.val <= min) {
            return false;
        }
        System.out.printf("Will be calling for node %d min %d max %d \n", root.val, min, max);
        return isBST(root.left, min, root.val - 1) && isBST(root.right, root.val + 1, max);
    }
}


class BSTOperations {

    public TreeNode insert(TreeNode root, int value) {

        if (root == null) {
            TreeNode nNoot = new TreeNode(value);
            return nNoot;
        }

        if (root != null && value < root.val) {
            root.left = insert(root.left, value);
        }

        if (root != null && value > root.val) {
            root.right = insert(root.right, value);
        }
        return root;
    }


    public void print(TreeNode root) {

        if (root == null) {
            return;
        }

        System.out.println(root.val);
        print(root.left);
        print(root.right);
    }

}

class Traversal {

    public void inorder(TreeNode root) {

        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.println(root.val + " ");
        inorder(root.right);

    }

    public void postorder(TreeNode root) {

        if (root == null) {
            return;
        }
        preorder(root.left);
        preorder(root.right);
        System.out.println(root.val + " ");
    }

    public void preorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val + " ");
        preorder(root.left);
        preorder(root.right);

    }

    public void virticalTraversal(TreeNode root) {

        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> mp = new TreeMap<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair poll = queue.poll();
            TreeNode curr = poll.node;
            int hd = poll.hd;

            if (mp.containsKey(hd)) {
                mp.get(hd).add(curr.val);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(curr.val);
                mp.put(hd, list);
            }
            if (curr.left != null) {
                queue.add(new Pair(curr.left, hd - 1));
            }
            if (curr.right != null) {
                queue.add(new Pair(curr.right, hd + 1));
            }
        }


        mp.values().stream().forEach((values) -> {
            values.stream().forEach(System.out::println);
            System.out.println("======================= \n");
        });
    }

}
