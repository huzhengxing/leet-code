package com.huzhengxing.tree.huffman_tree;

/**
 * @Auther: Albert
 * @Date: 2020/2/21 23:35
 * @Contact: 1092144169@qq.com
 * @Description: 节点
 */
public class Node {

    int value;

    Node left;

    Node right;

    public Node() {
    }

    public Node(int value) {
        this.value = value;
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
