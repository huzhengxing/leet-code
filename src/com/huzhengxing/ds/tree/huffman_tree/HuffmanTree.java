package com.huzhengxing.tree.huffman_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Auther: Albert
 * @Date: 2020/2/21 23:36
 * @Contact: 1092144169@qq.com
 * @Description: 霍夫曼树
 */
public class HuffmanTree {

    public Node root;


    public HuffmanTree() {

    }


    public HuffmanTree(Node root) {
        this.root = root;
    }


    public HuffmanTree(int[] arrays) {
        toHuffmanTree(arrays);
    }

    /**
     * 将数组转成哈夫曼树
     *
     * @param arrays
     */
    public void toHuffmanTree(int[] arrays) {
        List<Node> nodes = toNodeArray(arrays);
        this.root = toHuffmanTree(nodes);
    }

    private List<Node> toNodeArray(int[] arrays) {
        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < arrays.length; i++) {
            nodes.add(new Node(arrays[i]));
        }
        return nodes;
    }

    /**
     * 递归生成新的树
     *
     * @param nodes
     * @return
     */
    public Node toHuffmanTree(List<Node> nodes) {

        if (nodes.size() == 0) {
            return null;
        }

        while (nodes.size() > 1) {
            nodes.sort(Comparator.comparingInt(n->n.value));
            Node node = new Node((nodes.get(0).value + nodes.get(1).value));
            node.left = nodes.get(0);
            node.right = nodes.get(1);
            nodes.add(node);
            nodes.remove(nodes.get(0));
            nodes.remove(nodes.get(1));


        }
        return nodes.get(0);
    }

    /**
     * 剔除前2位，把新的元素插入进去
     *
     * @param nodes
     * @param newNode
     * @return
     */
    private Node[] orderNodes(Node[] nodes, Node newNode) {
        if (nodes.length == 2) {
            return new Node[]{newNode};
        } else {
            Node[] newNodes = new Node[nodes.length - 1];
            //标记插入元素的位置
            boolean flag = false;
            for (int i = 0; i < newNodes.length - 2; i++) {
                if (!flag) {
                    if (newNode.value < nodes[i + 2].value) {
                        newNodes[i] = newNode;
                        flag = true;
                    } else {
                        newNodes[i] = nodes[i + 2];
                    }
                } else {
                    newNodes[i] = nodes[i + 1];
                }
            }
            return newNodes;
        }

    }

    /**
     * 两个节点相加，组成一颗新的树
     *
     * @param var
     * @param var1
     * @return
     */
    private Node plusNode(Node var, Node var1) {
        return new Node(var.value + var1.value, var, var1);
    }

    /**
     * 数据排序
     *
     * @param
     */
//    private void orderNodeArray(List nodes) {
//        for (int i = 0; i < nodes.length; i++) {
//            for (int j = i + 1; j < nodes.length; j++) {
//                if (nodes[i].value > nodes[j].value) {
//                    int tmp = nodes[i].value;
//                    nodes[i].value = nodes[j].value;
//                    nodes[j].value = tmp;
//                }
//            }
//        }
//    }


    public static void main(String[] args) {
        int[] arrays = {2, 4, 3, 8, 1, 6};
        HuffmanTree huffmanTree = new HuffmanTree(arrays);
//        System.out.println(huffmanTree.root);

//        Node[] nodes = huffmanTree.toNodeArray(arrays);
//        huffmanTree.orderNodeArray(nodes);
        System.out.println(huffmanTree);
    }
}
