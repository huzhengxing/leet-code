package com.huzhengxing.tree;

import java.util.ArrayList;
import java.util.List;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-20 20:11:45
 * @LastEditTime: 2022-01-20 20:43:52
 * @Description: 
https://leetcode.com/problems/binary-tree-preorder-traversal/
Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> result = new ArrayList<Integer>();
		traversal(root, result);	
		return result;
    }	

	public void traversal(TreeNode node, List<Integer> result) {			
		if (node == null) {
			return;
		}
		result.add(node.val);
		traversal(node.left, result);
		traversal(node.right, result);
	}
	
}
