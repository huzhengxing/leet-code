package com.huzhengxing.ds.tree;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-20 20:17:11
 * @LastEditTime: 2022-01-21 17:11:37
 * @Description:
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
