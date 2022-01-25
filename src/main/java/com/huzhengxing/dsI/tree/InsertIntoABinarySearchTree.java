package com.huzhengxing.dsI.tree;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-24 20:14:36
 * @LastEditTime: 2022-01-24 20:48:45
 * @Description: 
https://leetcode.com/problems/insert-into-a-binary-search-tree/
You are given the root node of a binary search tree (BST) and a value to insert into the tree. Return the root node of the BST after the insertion. 
It is guaranteed that the new value does not exist in the original BST.
Notice that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

Binary Search Tree is a node-based binary tree data structure which has the following properties:
	- The left subtree of a node contains only nodes with keys lesser than the node’s key.
	- The right subtree of a node contains only nodes with keys greater than the node’s key.
	- The left and right subtree each must also be a binary search tree.
 */
public class InsertIntoABinarySearchTree {

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);
		}
		if (val > root.val) {
			root.right = insertIntoBST(root.right, val);
		}
		if (val < root.val) {
			root.left = insertIntoBST(root.left, val);
		}
		return root;
	}

}