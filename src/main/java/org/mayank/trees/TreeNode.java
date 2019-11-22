package org.mayank.trees;

/**
 * Created by mayank.goel on 21/11/19.
 */
public class TreeNode<T> {
    public T val;
    public  TreeNode<T> left;
    public  TreeNode<T> right;

    public  TreeNode(T x) {
        val = x;
    }
}
