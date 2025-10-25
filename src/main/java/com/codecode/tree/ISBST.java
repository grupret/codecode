package com.codecode.tree;

public class ISBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        BSTValidator validator = new BSTValidator();
        System.out.println("Is BST: " + validator.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)); // true

        BSTOperations operations = new BSTOperations();
        operations.insert(root, 2);

        operations.print(root);
        System.out.println("Is BST: " + validator.isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE)); // true
        Traversal traversal = new Traversal();
        System.out.println("================= pre ====================== \n");
        traversal.preorder(root);
        System.out.println("================= in ====================== \n");
        traversal.inorder(root);
        System.out.println("================= post ====================== \n");
        traversal.postorder(root);

        System.out.println("================= vertical  ====================== \n");
        traversal.virticalTraversal(root);
    }
}
