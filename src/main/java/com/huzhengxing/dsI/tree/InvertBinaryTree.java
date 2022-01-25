package com.huzhengxing.dsI.tree;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-22 23:04:38
 * @LastEditTime: 2022-01-24 20:25:15
 * @Description: 
 */
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return root;

		invertTree(root.left, root.right);
		return root;
	}

	private void invertTree(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return;
		}
		if (left == null) {
			left = right;
			right = null;
			return;

		}
		if (right == null) {
			right = left;
			left = null;
			return;
		}

		int tmp = left.val;
		left.val = right.val;
		right.val = tmp;
		invertTree(left.left, right.right);
		invertTree(left.right, right.left);

	}

	public TreeNode invertTree1(TreeNode root) {
		if (root == null)
			return root;
		TreeNode result = new TreeNode(root.val);
		result.left = invertTree(root.right);
		result.right = invertTree(root.left);
		return result;
	}

	public static void main(String[] args) {
		TreeNode tn1 = new TreeNode(1);
		TreeNode tn2 = new TreeNode(2);
		TreeNode tn22 = new TreeNode(2);
		tn1.left = tn2;
		// tn1.right = tn22;
		TreeNode tn3 = new TreeNode(3);
		TreeNode tn33 = new TreeNode(3);
		TreeNode tn4 = new TreeNode(2);
		TreeNode tn44 = new TreeNode(4);
		// tn2.left = tn3;
		// tn2.right = tn4;
		tn22.left = tn33;
		// tn2.right = tn44;
		InvertBinaryTree invertTree = new InvertBinaryTree();
		invertTree.invertTree(tn1);
		System.out.println("Finish");
	}
}
