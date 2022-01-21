package com.huzhengxing.ds.tree;
import com.huzhengxing.ds.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-21 15:37:49
 * @LastEditTime: 2022-01-21 17:13:10
 * @Description: 
https://leetcode.com/problems/symmetric-tree/
Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return false;
        List<TreeNode> tmp = new ArrayList<>();
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        tmp.add(root.left);
        tmp.add(root.right);
        while (!tmp.isEmpty()) {
            int size = tmp.size();
            if (size % 2 != 0) {
                return false;
            }
            TreeNode[] tmpTreeNode = new TreeNode[size];
            for (int i = 0; i < size / 2; i++) {
                TreeNode leftNode = tmpTreeNode[i];
                TreeNode rightNode = tmpTreeNode[size - 1 - i];
                if (rightNode == null || leftNode == null) {
                    return false;
                }
                if (rightNode == null && leftNode == null) {
                    continue;
                }
                if ((leftNode.val == rightNode.val)) {
                    tmp.add(leftNode.left);
                    tmp.add(leftNode.right);
                }
                tmp.remove(leftNode);
            }
            for (int i = size / 2 - 1; i < tmpTreeNode.length; i++) {
                TreeNode rightNode = tmpTreeNode[i];
                if (rightNode == null) {
                    continue;
                }
                tmp.add(rightNode.left);
                tmp.add(rightNode.right);
                tmp.remove(rightNode);
            }

        }
        return true;
    }

    public static void main(String[] args) {

        TreeNode tn1 = new TreeNode(1);
        TreeNode tn2 = new TreeNode(2);
        TreeNode tn22 = new TreeNode(2);
        tn1.left = tn2;
        tn1.right = tn22;
        TreeNode tn3 = new TreeNode(3);
        TreeNode tn33 = new TreeNode(3);
        TreeNode tn4 = new TreeNode(4);
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
