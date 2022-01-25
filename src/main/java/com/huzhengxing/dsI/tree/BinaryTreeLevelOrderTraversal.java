package com.huzhengxing.dsI.tree;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-21 09:26:23
 * @LastEditTime: 2022-01-21 14:23:54
 * @Description:
https://leetcode.com/problems/binary-tree-level-order-traversal/
Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		traversal(root, result, 0);
		return result;
	}

	public void traversal(TreeNode node, List<List<Integer>> values, int level) {
		if (node == null) {
			return;
		}
		List<Integer> list;
		if (level > values.size() - 1) {
			list = new ArrayList<>();
			values.add(list);
		} else {
			list = values.get(level);
		}
		list.add(node.val);
		traversal(node.left, values, level + 1);
		traversal(node.right, values, level + 1);
	}

	public List<List<Integer>> levelOrder1(TreeNode root) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> innerResult = new ArrayList();
			int size = queue.size();
			while (size > 0) {
				TreeNode treeNode = queue.poll();
				innerResult.add(treeNode.val);
				size--;
				if (treeNode.left != null) {
					queue.add(treeNode.left);
				}
				if (treeNode.right != null) {
					queue.add(treeNode.right);
				}
			}
			result.add(innerResult);
		}
		return result;
	}
}
