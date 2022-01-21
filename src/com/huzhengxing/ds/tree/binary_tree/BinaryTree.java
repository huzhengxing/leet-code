package com.huzhengxing.tree.binary_tree;

/**
 * @Auther: Albert
 * @Date: 2020/2/20 15:44
 * @Contact: 1092144169@qq.com
 * @Description: 树
 */
public class BinaryTree {

    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    public void preOrder() {
        preOrder(this.root);
    }

    /**
     * 前序遍历
     */
    public void preOrder(TreeNode root) {
        System.out.print(root.getValue());
        if (root.getLeftNode() != null) {
            preOrder(root.getLeftNode());
        }
        if (root.getRightNode() != null) {
            preOrder(root.getRightNode());
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(TreeNode root) {
        if (root.getLeftNode() != null) {
            inOrder(root.getLeftNode());
        }
        System.out.println(root.getValue());
        if (root.getRightNode() != null) {
            inOrder(root.getRightNode());
        }

    }

    /**
     * 后序遍历
     */
    public void postOrder(TreeNode root) {
        if (root.getLeftNode() != null) {
            postOrder(root.getLeftNode());
        }
        if (root.getRightNode() != null) {
            postOrder(root.getRightNode());
        }
        System.out.print(root.getValue());
    }

    /**
     * 层次遍历
     */
    public void levelOrder(TreeNode root) {

    }

    public void levelOrder(TreeNode root, int level) {
        System.out.println(root.getValue());
    }

    /**
     * 前序查找
     *
     * @param i
     */
    public TreeNode preSearch(int i) {
        return preSearch(this.root, i);
    }

    /**
     * 前序遍历线索化二叉树
     */
    public void inClue() {
        inClue(this.root);
    }

    /**
     * 记录上个节点
     */
    private TreeNode preNode = null;

    /**
     * 中序遍历线索化二叉树
     *
     * @param currentNode 当前节点
     */
    public void inClue(TreeNode currentNode) {
        if (currentNode == null) {
            return;
        }
        // 处理左节点
        inClue(currentNode.getLeftNode());
        if (currentNode.getLeftNode() == null) {
            currentNode.setLeftNode(this.preNode);
            currentNode.setLeftFlag(1);
        }
        if (preNode != null) {
            if (preNode.getRightNode() == null) {
                preNode.setRightNode(currentNode);
                preNode.setRightFlag(1);
            }
        }
        preNode = currentNode;
        // 处理右节点
        inClue(currentNode.getRightNode());
    }

    /**
     * 线索遍历二叉树
     */
    public void clueIterator() {

        // 线索化二叉树
        inClue();
        TreeNode currentNode = root;
        while (currentNode != null) {
            // 找到最左侧节点
            while (currentNode.getLeftFlag() == 0) {
                currentNode = currentNode.getLeftNode();
            }
            System.out.println(currentNode.getValue());
            while (currentNode.getRightFlag() == 1) {
                currentNode = currentNode.getRightNode();
                System.out.println(currentNode.getValue());
            }
            currentNode = currentNode.getRightNode();
        }

    }

    private TreeNode findLastLeftNode(TreeNode root) {
        if (root.getLeftNode() == null) {
            return root;
        } else {
            return findLastLeftNode(root.getLeftNode());
        }
    }

    public TreeNode preSearch(TreeNode root, int i) {
        TreeNode target = null;
        if (root.getValue() == i) {
            return root;
        }
        if (root.getLeftNode() != null) {
            target = preSearch(root.getLeftNode(), i);
        }
        if (target != null) {
            return target;
        }
        if (root.getRightNode() != null) {
            return preSearch(root.getRightNode(), i);
        }
        return target;
    }

    /**
     * 删除节点
     *
     * @param i
     */
    private void delete(int i) {
        if (this.root.getValue() == i) {
            this.root = null;
        }
        delete(this.root, i);

    }

    private void delete(TreeNode root, int i) {
        if (root.getLeftNode() != null) {
            if (root.getLeftNode().getValue() == i) {
                root.setLeftNode(null);
                return;
            } else {
                delete(root.getLeftNode(), i);
            }
        }
        if (root.getRightNode() != null) {
            if (root.getRightNode().getValue() == i) {
                root.setLeftNode(null);
            } else {
                delete(root.getRightNode(), i);
            }
        }

    }

    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode(1);
        TreeNode leftNode = new TreeNode(2, new TreeNode(4), new TreeNode(5));

        TreeNode rightNode = new TreeNode(3, new TreeNode(6), new TreeNode(7));
        treeNode.setLeftNode(leftNode);
        treeNode.setRightNode(rightNode);
        BinaryTree binaryTree = new BinaryTree(treeNode);

        // binaryTree.preOrder(treeNode);

        // System.out.println(binaryTree.preSearch(7).getValue());
        // binaryTree.delete(4);
        // binaryTree.preOrder(treeNode);
        // System.out.println();

        // binaryTree.inClue();
        // System.out.println();
        //
        binaryTree.clueIterator();

    }

}

class TreeNode {

    private int value;

    private TreeNode leftNode;

    private TreeNode rightNode;

    /**
     * 标记左右指针的类型区分是子节点或前驱节点/后级节点，默认0，代表子节点的位置
     */
    private int leftFlag;
    private int rightFlag;

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode(int value, TreeNode leftNode, TreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getLeftFlag() {
        return leftFlag;
    }

    public void setLeftFlag(int leftFlag) {
        this.leftFlag = leftFlag;
    }

    public int getRightFlag() {
        return rightFlag;
    }

    public void setRightFlag(int rightFlag) {
        this.rightFlag = rightFlag;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
