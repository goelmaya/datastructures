package org.mayank.trees;

/**
 * Created by mayank.goel on 21/11/19.
 */
public class CheckIFBinaryTreeIsBalanced {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return (Math.abs(findHeight(root.right) - findHeight(root.left)) <= 1) && isBalanced(root.right) && isBalanced(root.left);
    }

    public static int findHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }
        return Math.max(findHeight(node.right), findHeight(node.left)) + 1;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(1);
        TreeNode<Integer> rootLeft = new TreeNode(2);
        TreeNode<Integer> rootRight = new TreeNode(2);
        root.left = rootLeft;
        root.right = rootRight;

        TreeNode<Integer> rootLeftLeft = new TreeNode(3);
        TreeNode<Integer> rootLeftRight = new TreeNode(3);
        rootLeft.left = rootLeftLeft;
        rootLeft.right = rootLeftRight;

        TreeNode<Integer> rootLeftLeftLeft = new TreeNode(4);
        TreeNode<Integer> rootLeftLeftRight = new TreeNode(4);
        rootLeftLeft.left = rootLeftLeftLeft;
        rootLeftLeft.right = rootLeftLeftRight;
        System.out.println("The Binary tree is balanced==" + CheckIFBinaryTreeIsBalanced.isBalanced(root));

    }

}
