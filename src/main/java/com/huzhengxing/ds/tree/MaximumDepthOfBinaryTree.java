/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-21 14:37:53
 * @LastEditTime: 2022-01-21 15:27:53
 * @Description: 
https://leetcode.com/problems/maximum-depth-of-binary-tree/
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		return traversal(root, 1);
	}

	// checking depth of tree is valid.
	public int traversal(TreeNode node, int level) {
		if (node == null) {
			return level - 1;
		}
		int leftDepth = level;
		if (node.left != null) {
			leftDepth = traversal(node.left, level + 1);
		}
		int rightDepth = level;
		if (node.right != null) {
			rightDepth = traversal(node.right, level + 1);
		}
		return Math.max(leftDepth, rightDepth);
	}
}
