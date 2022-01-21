package com.huzhengxing.ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-21 15:37:49
 * @LastEditTime: 2022-01-21 20:45:42
 * @Description: 
https://leetcode.com/problems/symmetric-tree/
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        // check first node
        if (root.left == null && root.right == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int midSize = size / 2;
            Stack<TreeNode> stack = new Stack<>();
            while (size > 0) {
                TreeNode child = queue.poll();
                if (size > midSize) {
                    stack.add(child);
                } else {
                    // check symmetric
                    TreeNode tmp = stack.pop();
                    if (tmp != null && child != null) {
                        if (tmp.val != child.val) {
                            return false;
                        }
                        if ((child.left == null && tmp.right != null) || child.right == null && tmp.left != null) {
                            return false;
                        }
                    }
                    if ((tmp == null && child != null) || (tmp != null && child == null)) {
                        return false;
                    }
                }
                if (child != null && child.left != null) {
                    queue.add(child.left);
                }
                if (child != null && child.right != null) {
                    queue.add(child.right);
                }
                size--;
            }

        }
        return true;
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right != null)
            return false;
        if (left != null && right == null)
            return false;
        return (left == right) || left.val == right.val && isSymmetric(left.left, right.right)
                && isSymmetric(left.right, right.left);

    }

    public boolean isSymmetric1(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {

        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn22 = new TreeNode(2);
        tn1.left = tn2;
        tn1.right = tn22;
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn33 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(2);
        TreeNode tn44 = new TreeNode(4);
        tn2.left = tn3;
        tn2.right = tn4;
        tn22.left = tn33;
        tn2.right = tn44;
        SymmetricTree test = new SymmetricTree();
        boolean result = test.isSymmetric(tn1);
        System.out.println(result);
    }
}
